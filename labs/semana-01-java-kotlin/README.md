# Laboratorio semanal · Semana 1 · Control de batería Java → Kotlin

**Duración sugerida:** 25–35 minutos  
**Modalidad:** individual  
**Prerrequisito:** completar o comprender los [ejercicios básicos de Semana 1](../../semanas/semana-01/ejercicios-basicos.md)

← [Volver a Semana 01](../../semanas/semana-01/README.md)

## Objetivo

Construir un programa pequeño primero en Java y luego en Kotlin, manteniendo la misma lógica y aplicando los conceptos introductorios de la semana:

- variables y tipos;
- `val` / `var`;
- inferencia;
- salida por consola;
- `if/else`;
- funciones;
- String templates;
- `String?` y operador Elvis `?:`.

> No se busca Android todavía. El foco es comprender el cambio de sintaxis y de estilo entre Java y Kotlin.

## Problema

Un teléfono tiene inicialmente `modelo = Galaxy A55`, `bateria = 18`, `modoAhorro = false` y propietario sin dato. El programa debe mostrar un resumen, clasificar la batería y mostrar `Sin propietario` cuando corresponda.

Reglas de batería:

- menor a `20` → `Batería baja`;
- entre `20` y `79` → `Batería suficiente`;
- `80` o más → `Batería alta`.

## Parte A · Java

Trabaja en `src/main/java/cl/duoc/dsy1105/lab/LaboratorioJava.java`.

1. Declara los datos.
2. Muestra modelo, batería y modo ahorro.
3. Implementa `obtenerEstadoBateria(int bateria)` usando `if / else if / else`.
4. Prueba con batería `18`.
5. Controla propietario `null` y muestra `Sin propietario`.

## Parte B · Kotlin

Trabaja en `src/main/kotlin/cl/duoc/dsy1105/lab/LaboratorioKotlin.kt`.

1. Usa `val` por defecto e inferencia cuando sea clara.
2. Declara propietario como `String?`.
3. Imprime usando String templates.
4. Implementa `obtenerEstadoBateria(bateria: Int): String`.
5. Usa Elvis `?:` para resolver propietario ausente.

## Pruebas manuales

Ejecuta ambas versiones con `18`, `55` y `90`. Deben clasificar respectivamente batería baja, suficiente y alta.

## Evidencia mínima

- archivo Java ejecutable;
- archivo Kotlin ejecutable;
- salida de al menos una ejecución de cada uno;
- explicación breve de `val`, `String?`, Elvis y dos diferencias Java ↔ Kotlin.

## Criterio de éxito

- ambas versiones ejecutan sin errores;
- ambas implementan las tres reglas;
- Kotlin usa `val`, String templates, `String?` y `?:`;
- se probaron al menos tres valores de batería;
- el estudiante puede explicar el código sin depender de una solución copiada.
