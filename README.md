# 🚀 Parcial Magneto - Detección de Mutantes

## 🧬 Introducción
Magneto está en busca de mutantes para su causa y te ha contratado para desarrollar un sistema que detecte si un humano es mutante basándose en su secuencia de ADN. El sistema debe procesar secuencias de ADN y determinar si existen más de una secuencia de cuatro letras iguales de forma oblicua, horizontal o vertical.

## ⚙️ Funcionamiento
Se recibirá como parámetro un array de Strings que representan cada fila de una tabla de (6x6) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.

Se sabrá si un humano es mutante, si se encuentra MAS DE UNA SECUENCIA de cuatro letras iguales, de forma oblicua, horizontal o vertical.

Las filas de la matriz a verificar se ingresan por teclado.

Ejemplo de input: 'ATCGTA' (esto equivale a una fila de la matriz)

Una vez cargada correctamente la misma, se aplica una función que verifica si hay presencia en la matriz de mutantes o no y se devuelve el resultado al usuario en base a eso.

## 🚀 Firma del método:
```java
boolean isMutant(String[] dna)
```
Recibe un array de Strings que representan cada fila de una tabla de NxN con la secuencia del ADN. Las letras válidas son: A, T, C, G, representando las bases nitrogenadas del ADN.

## 🔍 Funcionalidades principales:

•Verificación de secuencias mutantes: Se detectan secuencias en las direcciones horizontal, vertical y diagonal.

•Detección de ADN ya registrado en la base de datos.

•Soporte de matrices desde 4x4 a 15x15.

•Detección de Matrices No Cuadradas.

## 🚀 Ejecución
El proyecto ha sido deployado a Render y puedes accederlo mediante el siguiente link:

## 🌐 Endpoints

- **POST /mutant** - Recibe un JSON con la matriz de ADN a verificar. Ejemplo:

```json
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]
}
```
- **GET /stats** - Devuelve un JSON con la cantidad de mutantes y humanos verificados. Ejemplo:
```json
{
    "count_mutant_dna": 50,
    "count_human_dna": 150,
    "ratio": 0.33
}
```
## 🧬 Ejemplo de ADN

Ejemplo de matriz **MUTANTE**:

```json
{
    "dna": [
      "ATGCGA",
      "CAGTGC",
      "TTATGT",
      "AGAAAG",
      "CCCCTA",
      "TCACTG"
    ]
}
```
## 🧬 Ejemplo de ADN

Ejemplo de matriz **NO MUTANTE**:

```json
{
    "dna": [
      "ATGGTG",
      "GTCTTA",
      "AATTGG",
      "ACTAGT",
      "GGATTC", 
      "AGGCAA"
    ]
}
```
