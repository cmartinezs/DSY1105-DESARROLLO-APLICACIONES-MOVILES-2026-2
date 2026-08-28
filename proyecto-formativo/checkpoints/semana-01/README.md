# PocketLog · Checkpoint Semana 01 · v0.1

## Estado

PocketLog **comienza realmente en Semana 01** como una aplicación Kotlin de consola deliberadamente simple.

No usa POO todavía. Los datos relacionados viven como variables independientes y las operaciones como funciones top-level independientes. Esa incomodidad es intencional: será la deuda técnica que permitirá justificar colecciones y luego POO sin cambiar de proyecto.

## Requerimientos conocidos desde el inicio

PocketLog ya tiene un alcance funcional definido para la Unidad 1 / EV1. Ver [REQUERIMIENTOS.md](../../REQUERIMIENTOS.md).

Los requerimientos se conocen desde ahora, pero no todas las técnicas para implementarlos están habilitadas todavía.

## Qué existe en v0.1

- un registro con `id`, título, categoría y estado;
- una función para mostrarlo;
- una función para cambiar su estado;
- una función simple para comprobar categoría;
- ejecución completa por consola;
- datos sueltos y funciones sueltas, sin clases propias.

Archivo ejecutable: [PocketLog.kt](./PocketLog.kt).

## Intención pedagógica

El estudiante debe reconocer que:

```text
los datos pertenecen conceptualmente al mismo registro
pero todavía están separados en variables
```

La pregunta que queda abierta es cómo escalar el mismo sistema cuando aparezcan varios registros.

## No adelantar

- clases/data classes;
- herencia/polimorfismo;
- arquitectura móvil;
- Android/Compose;
- persistencia;
- APIs.

## Siguiente incremento

Semana 02 reorganiza **los mismos requerimientos** usando fundamentos Kotlin, funciones, ciclos y colecciones cuando el contenido los habilite.
