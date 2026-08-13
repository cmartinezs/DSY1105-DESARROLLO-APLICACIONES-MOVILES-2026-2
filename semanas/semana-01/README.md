# Semana 1 · Panorama del desarrollo de aplicaciones

**Periodo:** 10 al 15 de agosto de 2026  
**Sección:** DSY1105-009V  
**Actividad institucional:** 1.1 Panorama del desarrollo de aplicaciones

← [Volver al índice de semanas](../README.md)

## Objetivo semanal

Comprender el ecosistema de aplicaciones móviles y diferenciar plataforma, lenguaje, framework/toolkit e IDE. Como transición inicial se incorpora un puente breve Java → Kotlin y se inicia la Guía 1 junto con la organización de parejas del proyecto semestral.

## Distribución horaria real

La sección tiene **5 bloques pedagógicos** esta semana:

- **Lunes 10 · 19:01–21:10 · 3 bloques.**
- **Jueves 13 · 21:11–22:30 · 2 bloques.**

La planificación se actualiza según el avance efectivo de la sección.

## Lunes 10 · realizado

### Bloque 1 · 19:01–19:40

- presentación general de la asignatura;
- propósito y organización del semestre;
- fechas y ponderaciones de evaluaciones;
- reglas y dinámica de trabajo;
- dudas iniciales.

### Bloque 2 · 19:41–20:20

PPT **1.1.1 Ecosistema de Aplicaciones Móviles**:

- nativas;
- web móvil;
- híbridas;
- multiplataforma;
- PWA;
- Android e iOS.

### Bloque 3 · 20:31–21:10

Continuación de la PPT 1.1.1:

- lenguajes;
- frameworks y toolkits;
- herramientas;
- distribución;
- panorama del mercado;
- criterios de elección tecnológica.

**Avance real:** la primera PPT fue revisada. El puente Java → Kotlin inicialmente planificado no alcanzó a desarrollarse.

## Jueves 13 · planificación ajustada

### Bloque 1 · 21:11–21:50 · Puente Java → Kotlin

El contenido práctico se organiza en tres capas:

1. **Guía explicada:** conceptos Java → Kotlin desarrollados paso a paso y en lenguaje simple.
2. **Ejemplo acompañado:** mismo programa construido en Java y Kotlin dentro del mismo proyecto IntelliJ.
3. **Laboratorio autónomo:** problema nuevo de aproximadamente 15 minutos, resuelto primero en Java y luego en Kotlin por cada estudiante.

#### 1. Guía paso a paso

📘 [**Guía · De Java a Kotlin sin partir de cero**](./guia-java-kotlin-paso-a-paso.md)

Explica con detalle:

- variables y tipos;
- inferencia de tipos;
- `val` y `var`;
- String templates;
- `if/else`;
- funciones y parámetros;
- retorno de valores;
- `String?`;
- operador Elvis `?:`.

#### 2. Ejemplo práctico acompañado

📁 [**Ejemplo práctico · Java → Kotlin**](./ejemplo-java-kotlin/README.md)

Proyecto Gradle ejecutable en IntelliJ IDEA con:

- `AppJava.java`;
- `AppKotlin.kt`;
- ambos lenguajes dentro del mismo módulo;
- misma lógica implementada en paralelo.

La recomendación para la clase es mantener ambos archivos abiertos mediante **Split Right**, construir primero cada fragmento en Java y escribir inmediatamente su equivalente Kotlin.

#### 3. Laboratorio autónomo · 15 minutos

🧪 [**Laboratorio · Control de batería Java → Kotlin**](./laboratorio-java-kotlin/README.md)

Los estudiantes reciben un problema diferente al ejemplo y deben:

1. resolverlo primero en Java;
2. comprobar su ejecución;
3. reproducir la misma lógica en Kotlin;
4. aplicar `val`, inferencia, String templates, funciones y null safety;
5. comparar ambas salidas.

La carpeta contiene solamente estructura inicial y `TODO`; **no contiene la solución terminada**.

### Bloque 2 · 21:51–22:30 · Guía 1 + proyecto

- explicar el propósito de la Guía 1;
- comparar tecnologías por rendimiento, hardware, costo, time-to-market, mantenibilidad y ecosistema;
- trabajar con fuentes oficiales;
- iniciar la ficha comparativa;
- conformar parejas o registrar incidencias para quienes aún no tengan compañero/a.

La Guía 1 puede quedar iniciada y continuar fuera de este bloque. La prioridad es que quede claro qué investigar, con qué criterios y con qué fuentes.

## Evidencia mínima de la semana

Al finalizar la semana el estudiante debería poder:

1. distinguir enfoques nativo, híbrido, multiplataforma, PWA y web móvil;
2. diferenciar plataforma, lenguaje, framework/toolkit e IDE;
3. explicar por qué Kotlin es relevante para Android;
4. reconocer equivalencias básicas Java ↔ Kotlin;
5. escribir un programa breve primero en Java y luego en Kotlin conservando la misma lógica;
6. diferenciar `String` y `String?` y utilizar `?:` en un caso sencillo;
7. iniciar una comparación técnica basada en criterios y fuentes oficiales;
8. tener pareja de proyecto definida o una incidencia registrada.

## Material

- [Biblioteca pública del curso](https://drive.google.com/drive/folders/1_Ew_IE0InqJbPY0Ggu8p0cHl4Avv3rYs?usp=sharing)
- [Semana 01 · 10 al 15 de agosto](https://drive.google.com/drive/folders/1ieL6EOF475qNxCErYrQfjqw8EL-GXeiV)
- `1.1.1 Ecosistema de Aplicaciones Moviles.pptx`

> La Guía 1 figura en el cronograma institucional y permanece pendiente de extracción desde el paquete global de experiencias para su publicación separada.
