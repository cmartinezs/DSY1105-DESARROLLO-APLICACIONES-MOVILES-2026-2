# Semana 3 · Aplicación Orientada a Objetos en Kotlin

**Periodo:** 24 al 29 de agosto de 2026  
**Sección:** DSY1105-009V  
**Actividad institucional:** **1.3 · Aplicación Orientada a Objetos**

← [Volver al índice](../README.md)

## Alineación con coordinación

Esta semana corresponde trabajar la Actividad 1.3 utilizando como referencia los recursos institucionales:

- **1.3.1** POO y Control de errores en Kotlin.
- **1.3.2** Guía 4 – Aplicando POO y control de errores.
- **1.3.3** Corrutinas y sintaxis avanzada Kotlin.
- **1.3.4** Guía 5 – Aplicando corrutinas y sintaxis avanzada.

La progresión conceptual esperada es:

```text
clase → atributos/propiedades → métodos → objetos → encapsulamiento
→ herencia → sobrescritura → polimorfismo
→ control de errores
→ data class / sealed class
→ asincronía → corrutinas
```

El foco no es volver a enseñar POO desde cero, sino **reconocer conceptos ya conocidos y aprender cómo Kotlin los expresa**.

## Particularidad real de esta sección

La Semana 2 cerró realmente en **funciones básicas → próxima clase: colecciones**. Por eso no se fingirá un avance inexistente. Antes de entrar a POO se cerrará `List`, `MutableList`, recorridos y operaciones funcionales esenciales. Ese cierre sirve además como puente hacia colecciones de objetos.

La secuencia real queda así:

```text
List / MutableList
→ for / forEach
→ filter / map / count
→ problema de datos relacionados
→ clases y objetos en Kotlin
→ encapsulamiento
→ herencia / override / polimorfismo
→ control de errores
→ data class / sealed class
→ corrutinas si los prerrequisitos están cerrados
```

## Ruta práctica semanal

La práctica queda dividida explícitamente en dos niveles:

1. 🧩 [**Ejercicios básicos · Semana 3**](./ejercicios-basicos.md) — problemas pequeños y neutrales para cerrar colecciones y practicar clase/objeto, encapsulamiento, herencia, polimorfismo, errores y sintaxis avanzada cuando corresponda.
2. 🧪 [**Laboratorio semanal · De datos sueltos a objetos**](../../labs/semana-03-de-datos-a-objetos/README.md) — problema integrador guiado por checkpoints, desde `MutableList` hasta modelado con objetos y control de errores.

Secuencia recomendada:

```text
contenido / ejemplo pequeño
→ ejercicio básico del concepto
→ laboratorio semanal por checkpoints
→ transferencia a PocketLog
```

> Si un bloque todavía no fue trabajado en clase, el estudiante no debe saltar a él solo porque aparezca publicado. El laboratorio está preparado para detenerse en el checkpoint real alcanzado.

## Material de la semana

1. [Colecciones Kotlin · cierre pendiente](./01-colecciones-kotlin.md)
2. [POO en Kotlin · de clases a polimorfismo](./02-poo-kotlin.md)
3. [Control de errores y corrutinas](./03-errores-corrutinas.md)
4. [Ejercicios básicos · Semana 3](./ejercicios-basicos.md)
5. [Laboratorio semanal guiado](../../labs/semana-03-de-datos-a-objetos/README.md)
6. [Sintaxis avanzada · data class y sealed class](./05-sintaxis-avanzada.md)
7. [Dinámica viva · Tres listas son una pista](./dinamica-viva-tres-listas.md)

## Proyecto formativo transversal · PocketLog

PocketLog llega a esta semana desde la evolución acumulada de Semanas 1 y 2:

```text
datos + funciones sueltas
→ múltiples registros + colecciones
→ objetos + responsabilidades + control de errores
```

La meta no es reescribir el proyecto, sino refactorizarlo usando el contenido nuevo. Los requerimientos funcionales permanecen estables; cambia la calidad del modelo y la forma de implementarlos.

Material principal:

- [Guía PocketLog · Semana 03](../../proyecto-formativo/guias/semana-03/)
- [PocketLog vivo](../../proyecto-formativo/pocketlog/)
- [Checkpoint Semana 03 · v0.3](../../proyecto-formativo/checkpoints/semana-03/)
- [Requerimientos PocketLog](../../proyecto-formativo/REQUERIMIENTOS.md)

## Objetivos de aprendizaje

Al finalizar la semana, según el avance efectivamente alcanzado, el estudiante debería poder:

- crear clases, propiedades, métodos e instancias en Kotlin;
- aplicar encapsulamiento y controlar la mutabilidad del estado;
- implementar una relación de herencia simple con `open`, `:` y `override`;
- observar polimorfismo mediante referencias de un tipo general;
- distinguir validación preventiva de manejo de excepciones con `try/catch`;
- explicar cuándo una `data class` resulta apropiada;
- comprender el propósito de una `sealed class` para modelar conjuntos cerrados de estados o resultados;
- explicar qué problema resuelven las corrutinas y qué significa realmente `suspend`.

## Regla pedagógica

Se mantiene una separación explícita entre tres capas:

1. **Contenido:** ejemplos pequeños, neutrales y progresivos para aprender Kotlin.
2. **Práctica:** ejercicios breves y laboratorio guiado donde el estudiante programa sin copiar una solución completa.
3. **PocketLog:** proyecto formativo transversal que aplica lo aprendido después de comprenderlo; no es la ejemplificación principal del contenido.

## Kotlin no es «Java con menos líneas»

Durante los ejemplos se compararán conceptos conocidos con su implementación Kotlin, destacando diferencias como constructor primario, propiedades, `open`, `override`, null-safety, expresiones, `data class` y `sealed class`. Se evita traducir mecánicamente código Java línea por línea.

## Criterio sobre corrutinas

Las corrutinas forman parte del contenido institucional de la semana, pero no se enseñan como magia sintáctica. Antes de usarlas se debe comprender el problema de bloquear una aplicación, el flujo normal de una función y el significado de suspensión.

Si el ritmo real obliga a priorizar POO y control de errores, debe registrarse explícitamente qué parte de corrutinas queda pendiente. Publicar material no equivale a haberlo trabajado en aula.

## Evidencia mínima

- código Kotlin ejecutable;
- ejercicios básicos acordes al contenido efectivamente trabajado;
- laboratorio semanal avanzado hasta el checkpoint alcanzado;
- una clase propia con al menos dos instancias;
- propiedades y comportamiento coherentes;
- encapsulamiento básico;
- herencia/sobrescritura/polimorfismo cuando ese bloque sea alcanzado;
- manejo razonable de al menos un error;
- uso o explicación justificada de `data class` y `sealed class` cuando corresponda;
- DevLog semanal con aprendizaje, dificultad, error real y siguiente paso.

## Cierre docente obligatorio

Registrar: último concepto efectivamente alcanzado, práctica realizada, checkpoint del laboratorio alcanzado, estado real de PocketLog, errores/bloqueos frecuentes, contenidos institucionales pendientes y punto exacto de inicio de la próxima clase.
