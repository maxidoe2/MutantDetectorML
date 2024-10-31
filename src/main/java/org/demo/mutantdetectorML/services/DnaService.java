package org.demo.mutantdetectorML.services;

import org.demo.mutantdetectorML.entities.Dna;
import org.demo.mutantdetectorML.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;

@Service
public class DnaService {

    // Referencia al repositorio de ADN
    private final DnaRepository dnaRepository;

    // Longitud requerida de una secuencia mutante
    private static final int SEQUENCE_LENGTH = 4;

    @Autowired
    public DnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    /**
     * Analiza si una secuencia de ADN es mutante.
     * Si ya se analizó previamente, devuelve el resultado guardado en la base de datos.
     *
     * @param dna Matriz de ADN representada como un array de Strings.
     * @return true si es mutante, false en caso contrario.
     */
    public boolean analyzeDna(String[] dna) {
        String dnaSequence = String.join(",", dna);

        // Verificar si la secuencia ya fue analizada previamente
        Optional<Dna> existingDna = dnaRepository.findByDna(dnaSequence);
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        // Realizar el análisis y guardar el resultado
        boolean isMutant = isMutant(dna);
        Dna dnaEntity = Dna.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();
        dnaRepository.save(dnaEntity);

        return isMutant;
    }

    /**
     * Verifica si una matriz de ADN contiene suficientes secuencias mutantes
     * de 4 letras consecutivas idénticas en cualquier dirección.
     *
     * @param dna Matriz de ADN representada como un array de Strings.
     * @return true si contiene al menos una secuencia mutante, false en caso contrario.
     */
    public static boolean isMutant(String[] dna) {
        // Validar dimensiones de la matriz
        int n = dna.length;

        if (n < 4 || n > 15) {
            throw new IllegalArgumentException("La matriz de ADN debe tener dimensiones de entre 4x4 y 15x15.");
        }

        HashSet<String> foundSequences = new HashSet<>();

        // Recorrer la matriz para verificar cada posición
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Verificar en todas las direcciones
                if (hasMutantSequence(dna, i, j, 0, 1, n, foundSequences)) return true;
                if (hasMutantSequence(dna, i, j, 1, 0, n, foundSequences)) return true;
                if (hasMutantSequence(dna, i, j, 1, 1, n, foundSequences)) return true;
                if (hasMutantSequence(dna, i, j, 1, -1, n, foundSequences)) return true;
            }
        }

        return false; // No se encontraron suficientes secuencias mutantes
    }

    /**
     * Verifica si existe una secuencia de 4 letras idénticas en una dirección específica
     * desde una posición inicial (row, col) en la matriz de ADN.
     *
     * @param dna Matriz de ADN.
     * @param row Fila de inicio.
     * @param col Columna de inicio.
     * @param rowStep Incremento de fila para la dirección.
     * @param colStep Incremento de columna para la dirección.
     * @param size Tamaño de la matriz.
     * @param foundSequences Conjunto de secuencias encontradas.
     * @return true si se encontró una secuencia mutante de 4 letras idénticas en la dirección especificada.
     */
    private static boolean hasMutantSequence(String[] dna, int row, int col, int rowStep, int colStep, int size, HashSet<String> foundSequences) {
        // Verificar si la secuencia de 4 letras cabe en los límites de la matriz
        if (row + (SEQUENCE_LENGTH - 1) * rowStep >= size || row + (SEQUENCE_LENGTH - 1) * rowStep < 0 ||
                col + (SEQUENCE_LENGTH - 1) * colStep >= size || col + (SEQUENCE_LENGTH - 1) * colStep < 0) {
            return false;
        }

        // Construir la secuencia de 4 letras
        StringBuilder sequence = new StringBuilder();
        char initialChar = dna[row].charAt(col);
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            if (dna[row + i * rowStep].charAt(col + i * colStep) != initialChar) {
                return false; // Secuencia no es homogénea
            }
            sequence.append(initialChar);
        }

        // Verificar si la secuencia ya fue encontrada
        String seqString = sequence.toString();
        if (foundSequences.contains(seqString)) {
            return false;
        }

        // Agregar la secuencia encontrada y retornar true
        foundSequences.add(seqString);
        return true;
    }
}
