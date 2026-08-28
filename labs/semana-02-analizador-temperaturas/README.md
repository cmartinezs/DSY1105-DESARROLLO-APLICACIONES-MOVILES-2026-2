# Laboratorio semanal · Semana 2 · Analizador de temperaturas

**Duración sugerida:** 35–45 minutos  
**Modalidad:** individual  
**Prerrequisito:** fundamentos Kotlin y [ejercicios básicos de Semana 2](../../semanas/semana-02/ejercicios-basicos.md)

## Objetivo

Integrar progresivamente:

- variables;
- operadores;
- condicionales;
- ciclos;
- funciones;
- null safety básico;
- `List` / `MutableList`;
- `for` / `forEach`;
- `filter`, `map` y `count` cuando hayan sido trabajados.

> El laboratorio está diseñado por checkpoints. Si una operación todavía no se ha visto en clase, se detiene ahí y se continúa cuando corresponda.

## Problema

Una aplicación registra estas temperaturas durante el día:

```text
18, 22, 25, 17, 29, 31, 20
```

Debes construir un analizador en Kotlin.

## Checkpoint 0 · Proyecto ejecutable

1. crea o abre un proyecto Kotlin de consola;
2. crea `AnalizadorTemperaturas.kt`;
3. agrega `fun main()`;
4. imprime `Analizador iniciado`;
5. ejecuta.

No continúes hasta ver el mensaje en consola.

## Checkpoint 1 · Lista y recorrido básico

Crea una `List<Int>` con los siete valores, imprime la lista completa y recórrela con `for` mostrando una temperatura por línea.

## Checkpoint 2 · Función de clasificación

Crea `clasificarTemperatura(temperatura: Int): String`.

Reglas:

- menor a `18` → `Frío`;
- de `18` a `24` → `Templado`;
- `25` o más → `Caluroso`.

Prueba primero `17`, `18`, `24` y `25`, luego aplica la función a la lista completa.

## Checkpoint 3 · Conteo sin magia

Antes de usar `count`, calcula cuántas temperaturas son `>= 25` con una variable contador, un `for` y un `if`.

El objetivo es comprender el algoritmo antes de reemplazarlo por una operación de colección.

## Checkpoint 4 · Colección mutable

Copia o transforma los datos a `MutableList` y agrega `26`. Comprueba que ahora existan ocho valores.

## Checkpoint 5 · `filter`

Solo cuando haya sido trabajado, obtén una nueva colección con temperaturas `>= 25`. No modifiques la colección original.

## Checkpoint 6 · `map`

Obtén otra colección donde cada temperatura aumente en `1` grado. Debes poder explicar que `map` transforma y produce otra colección.

## Checkpoint 7 · `count`

Calcula cuántas temperaturas son mayores a `25` con `count` y compara el resultado con el contador manual.

## Checkpoint 8 · Resumen final

Muestra un resumen con cantidad de registros, temperaturas `>= 25` y temperaturas `> 25`. Promedio, mínima y máxima son extensiones sólo si ya fueron explicados.

## Errores frecuentes

- intentar `add` sobre `List`;
- confundir `>` con `>=`;
- creer que `map` modifica la lista original;
- usar `filter`, `map` o `count` sin poder explicar qué hacen.

## Evidencia mínima

- archivo `.kt` ejecutable;
- salida de ejecución;
- función `clasificarTemperatura`;
- recorrido con `for`;
- uso de `MutableList`;
- `filter`, `map` y `count` sólo si ya fueron trabajados;
- explicación de `List` vs `MutableList`, `filter`, `map` y `count`.

## Criterio de logro

- [ ] programa ejecuta sin errores;
- [ ] puedo recorrer una colección;
- [ ] sé clasificar con una función;
- [ ] sé modificar una colección mutable;
- [ ] comprendo qué hacen `filter`, `map` y `count`;
- [ ] puedo explicar el código paso a paso.
