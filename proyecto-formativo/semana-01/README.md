# PocketLog · Guía Semana 01 · v0.1

PocketLog comienza esta semana como una aplicación Kotlin de consola pequeña, con **datos sueltos y funciones sueltas**.

## RECIBE

No hay versión anterior: ésta es la primera versión del proyecto longitudinal.

## REQUERIMIENTOS

Antes de programar, revisa [los requerimientos funcionales de PocketLog](../../REQUERIMIENTOS.md). El alcance de la Unidad 1 se conoce desde el principio; lo que cambia semana a semana es la técnica disponible para implementarlo.

## APRENDEMOS

Esta primera versión utiliza únicamente elementos introductorios compatibles con el puente inicial hacia Kotlin:

- variables;
- tipos simples;
- `val` / `var`;
- funciones top-level;
- `if` sencillo;
- salida por consola.

## PROBLEMA

PocketLog necesita representar un registro con:

```text
id
título
categoría
estado
```

Todavía no usamos clases. Por eso esos datos viven por separado.

## DECISIÓN

Implementar un único registro mediante variables independientes y operaciones mediante funciones independientes.

Esto **no pretende ser el diseño final**. Es el punto de partida que luego podremos comparar con soluciones mejores.

## PASO A PASO

1. declara `idRegistro`, `tituloRegistro`, `categoriaRegistro` y `registroCompletado`;
2. muestra los valores por consola;
3. extrae la presentación a `mostrarRegistro(...)`;
4. crea `cambiarEstado(actual)`;
5. crea una comprobación sencilla de categoría;
6. ejecuta nuevamente y verifica el cambio de estado.

Puedes comparar tu resultado con el checkpoint sólo después de intentar construirlo: [PocketLog.kt](../../checkpoints/semana-01/PocketLog.kt).

## DESCUBRE TÚ

Cambia los datos para representar otro registro sin modificar las funciones.

Luego responde:

- ¿qué variables pertenecen conceptualmente a una misma cosa?;
- ¿qué ocurriría si necesitáramos 10 registros?;
- ¿tendríamos que copiar variables?;

## COMPRUEBA

La aplicación debe:

- ejecutar sin errores;
- mostrar el registro;
- indicar su categoría;
- cambiar de pendiente a completado;
- volver a mostrar el estado actualizado.

## CHECKPOINT

El checkpoint de Semana 01 es **ejecutable** y constituye PocketLog v0.1.

## DEJA ABIERTO

Los requerimientos ya contemplan varios registros, búsqueda, filtros y conteos. Todavía no implementamos todo porque aún faltan estructuras del lenguaje.

La deuda deliberada queda expresada así:

```text
un registro -> varias variables relacionadas
muchos registros -> ¿cómo evitamos multiplicar variables?
```

Esa pregunta conduce naturalmente a Semana 02.

## No adelantar

- clases propias;
- `data class`;
- herencia/polimorfismo;
- Android/Compose;
- base de datos;
- APIs.
