# Semana 3 · Aplicación Orientada a Objetos en Kotlin

**Periodo:** 24 al 29 de agosto de 2026  
**Sección:** DSY1105-009V  
**Actividad institucional:** Aplicación Orientada a Objetos

← [Volver al índice](../README.md)

## Particularidad de esta sección

La Semana 2 cerró realmente en **funciones básicas → próxima clase: colecciones**. Por eso esta semana no salta artificialmente a POO: primero cierra `List`, `MutableList`, recorridos y operaciones funcionales; luego aplica ese conocimiento a PocketLog y recién después introduce objetos.

## Ruta real

```text
List / MutableList
→ for / forEach
→ filter / map / count
→ PocketLog con colecciones
→ checkpoint real v0.2
→ problema de listas paralelas
→ clases y objetos
→ propiedades y comportamiento
→ encapsulamiento
→ control de errores
→ sintaxis avanzada según ritmo
→ corrutinas solo con prerrequisitos cerrados
```

## Material

1. [Colecciones Kotlin · cierre pendiente](./01-colecciones-kotlin.md)
2. [POO en Kotlin](./02-poo-kotlin.md)
3. [Control de errores y puente a corrutinas](./03-errores-corrutinas.md)
4. [Laboratorio y práctica](./04-laboratorio.md)
5. [Dinámica viva · Tres listas son una pista](./dinamica-viva-tres-listas.md)

## Objetivos

El estudiante deberá poder agrupar y procesar datos con colecciones; reconocer cuándo múltiples datos relacionados deberían convertirse en un objeto; declarar clases e instancias Kotlin; usar propiedades y métodos; aplicar encapsulamiento básico; manejar errores previsibles sin esconderlos; y comprender conceptualmente por qué una aplicación móvil necesita trabajo asíncrono antes de entrar a corrutinas.

## PocketLog

PocketLog es proyecto formativo transversal y evoluciona desde el **estado realmente alcanzado**, no desde código objetivo adelantado. La promoción del checkpoint v0.2 ocurre después de demostrar colecciones. El siguiente incremento transforma el modelo hacia objetos, evitando mantener listas paralelas de títulos, categorías y estados.

## Evidencia mínima

- código Kotlin ejecutable;
- una colección creada, recorrida, filtrada y transformada;
- PocketLog actualizado al concepto efectivamente cubierto;
- una clase propia con instancias y comportamiento;
- manejo razonable de al menos un error cuando ese contenido sea alcanzado;
- DevLog semanal con aprendizaje, dificultad, error real y siguiente paso.

## Criterio sobre corrutinas

Las corrutinas forman parte del horizonte curricular, pero **no se enseñan como magia sintáctica**. Si colecciones, funciones y POO consumen la semana, el cierre docente debe registrar corrutinas como pendiente real. Si se alcanzan, se introduce `suspend`, coroutine scope y una demostración controlada, sin convertir la sesión en un catálogo de operadores.

## Cierre docente obligatorio

Registrar último concepto efectivamente alcanzado, estado real de PocketLog, checkpoint promovido o no promovido, errores/bloqueos frecuentes y punto exacto de inicio de la próxima clase.