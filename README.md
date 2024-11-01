🧬 MutantDetectorML - Identificador de Mutantes
🎯 Descripción
Sistema revolucionario desarrollado para Magneto que permite identificar mutantes mediante el análisis de secuencias de ADN. La plataforma procesa matrices genéticas para detectar patrones específicos que determinan si un individuo posee el gen mutante, basándose en la repetición de secuencias en múltiples direcciones.
🔬 Especificaciones Técnicas
La detección se realiza sobre una matriz cuadrada de ADN donde cada elemento representa una base nitrogenada. El sistema procesa únicamente las bases (A,T,C,G), analizando la presencia de secuencias repetitivas que indican la presencia del gen mutante.
⚡ Características Principales

Análisis multidireccional de ADN (horizontal, vertical y diagonal)
Detección de secuencias mutantes (4 elementos idénticos)
Procesamiento de matrices desde 4x4 hasta 15x15
Sistema de verificación de integridad matricial
Base de datos para registro histórico de análisis

📝 Método Principal
javaCopyboolean isMutant(String[] dna)
El método recibe un array de Strings que representa la matriz de ADN a analizar. Cada string debe contener únicamente los caracteres A, T, C, G.
🛠️ Funcionalidades Core

Análisis bidimensional completo del ADN
Sistema de detección de ADN duplicado
Validación de dimensiones matriciales
Verificación de integridad de datos
Registro histórico de análisis

🌐 API Endpoints
Análisis de ADN
POST /mutant
jsonCopy{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]
}
Estadísticas de Análisis
GET /stats
jsonCopy{
    "count_mutant_dna": 50,
    "count_human_dna": 150,
    "ratio": 0.33
}
📊 Ejemplos de ADN
Matriz MUTANTE:
jsonCopy{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAAG",
        "CCCCTA",
        "TCACTG"
    ]
}
Matriz NO MUTANTE:
jsonCopy{
    "dna": [
        "ATGGTG",
        "GTCTTA",
        "AATTGG",
        "ACTAGT",
        "GGATTC",
        "AGGCAA"
    ]
}
