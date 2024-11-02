🧬 MutantDetectorML

[![Render Deploy](https://img.shields.io/badge/Render-Deploy-green)](https://mutantdetectorml.onrender.com)
[![API Status](https://img.shields.io/badge/API-Active-brightgreen)](https://mutantdetectorml.onrender.com/stats)
[![DNA Analysis](https://img.shields.io/badge/DNA-Analysis-blue)](https://mutantdetectorml.onrender.com/mutant)

## 🎯 Descripción

Sistema revolucionario desarrollado para Magneto que permite identificar mutantes mediante el análisis de secuencias de ADN. La plataforma procesa matrices genéticas para detectar patrones específicos que determinan si un individuo posee el gen mutante, basándose en la repetición de secuencias en múltiples direcciones.

## 🔬 Especificaciones Técnicas

La detección se realiza sobre una matriz cuadrada de ADN donde cada elemento representa una base nitrogenada. El sistema procesa únicamente las bases (A,T,C,G), analizando la presencia de secuencias repetitivas que indican la presencia del gen mutante.

## ⚡ Características Principales

- Análisis multidireccional de ADN (horizontal, vertical y diagonal)
- Detección de secuencias mutantes (4 elementos idénticos)
- Procesamiento de matrices desde 4x4 hasta 15x15
- Sistema de verificación de integridad matricial
- Base de datos para registro histórico de análisis

## 📝 Método Principal

```java
boolean isMutant(String[] dna)
```

El método recibe un array de Strings que representa la matriz de ADN a analizar. Cada string debe contener únicamente los caracteres A, T, C, G.

## 🛠️ Funcionalidades Core

| Funcionalidad | Descripción |
|---------------|-------------|
| Análisis ADN | Verificación bidimensional completa |
| Detección | Sistema de identificación de ADN duplicado |
| Validación | Control de dimensiones matriciales |
| Integridad | Verificación de datos entrantes |
| Registro | Historial completo de análisis |

## 🌐 API Endpoints

### 🧪 Análisis de ADN

```http
POST /mutant
```

#### Request Body

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

### 📊 Estadísticas

```http
GET /stats
```

#### Response

```json
{
    "count_mutant_dna": 50,
    "count_human_dna": 150,
    "ratio": 0.33
}
```

## 📊 Ejemplos de ADN

### ✨ Matriz MUTANTE

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

### 👤 Matriz NO MUTANTE

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

## 🚀 Despliegue

El proyecto está desplegado en Render y puede accederse a través de:

```
https://mutantdetectorml.onrender.com
```

## 💀​ Diagrama de Secuencia del proyecto
## POST MUTANT METHOD
![POST METHOD](https://i.imgur.com/UIfUUum.jpeg)
## GET STATS METHOD
![GET METHOD](https://i.imgur.com/8Ea5fp5.jpeg)

## 👀​ Resultados en JMeter
## 1000 HILOS POST /MUTANT (1 SEGUNDO SUBIDA)
![POST METHOD](https://i.imgur.com/kFrD1Eb.png)
## 10000 HILOS POST /MUTANT (5 SEGUNDOS SUBIDA)
![POST METHOD](https://i.imgur.com/iLTr6TY.png)

## 😎​ Magneto está feliz.
![POST METHOD](https://i.imgur.com/xUjRxa1.jpeg)

## 📫 Contacto

Si tienes preguntas o sugerencias sobre el proyecto, no dudes en enviarme un correo a maxidoe2004@gmail.com

⚡️ Desarrollado con 💙 para Magneto
