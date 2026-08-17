# Laboratorio · Analizador simple de temperaturas

**Duración sugerida:** 15–20 minutos.  
**Modalidad:** individual.  
**Objetivo:** aplicar fundamentos de Kotlin sin copiar el ejemplo guiado.

## Problema

Una aplicación móvil recibe una lista fija de temperaturas registradas durante el día:

```text
18, 22, 25, 17, 29, 31, 20
```

Debes construir un programa Kotlin que:

1. almacene las temperaturas en una colección;
2. muestre todas las temperaturas;
3. determine cuáles son mayores o iguales a 25;
4. cuente cuántas cumplen esa condición;
5. obtenga una nueva colección con cada temperatura aumentada en 1 grado;
6. implemente una función `clasificarTemperatura()` que retorne:
   - `"Frío"` si es menor a 18;
   - `"Templado"` si está entre 18 y 24;
   - `"Caluroso"` si es 25 o superior;
7. recorra la colección original mostrando temperatura + clasificación.

## Restricciones

- usar `val` por defecto;
- utilizar al menos un `if` o `when`;
- utilizar al menos una función propia;
- no resolver todo dentro de una sola línea;
- poder explicar qué hacen `filter` y `map` si decides utilizarlos.

## Parte A · hoy lunes

Si todavía no se ha trabajado `map`/`filter`, resuelve los puntos 1, 2, 6 y 7 utilizando `for`.

## Parte B · jueves

Refactoriza la solución para incorporar `filter` y `map` en los puntos 3, 4 y 5.

## Evidencia

En el repositorio o entrega indicada debe quedar:

- archivo `.kt` ejecutable;
- salida de una ejecución;
- tres respuestas breves:
  1. ¿qué variable declaraste con `var` y por qué? Si ninguna, explica por qué;
  2. ¿cuándo preferiste `when` frente a `if`?;
  3. ¿qué transformación realiza `map` y qué selección realiza `filter`?

## Extensión opcional

Calcular promedio, mínima y máxima temperatura utilizando las operaciones de colección de Kotlin.
