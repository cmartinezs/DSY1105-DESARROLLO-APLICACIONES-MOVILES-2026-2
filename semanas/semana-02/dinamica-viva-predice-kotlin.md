# Dinámica viva · Predice Kotlin antes de ejecutar

**Duración sugerida:** 5–10 minutos  
**Objetivo:** razonar sobre Kotlin antes de depender del IDE.

Cada estudiante anota primero qué cree que ocurrirá. Después se ejecuta y se comparan predicción y resultado.

## Caso 1 · Inferencia y String template

```kotlin
val producto = "Café"
var stock = 4
stock = stock - 1

println("$producto: quedan $stock unidades")
```

Antes de ejecutar:

1. ¿qué tipos infiere Kotlin?;
2. ¿por qué `producto` no puede reasignarse y `stock` sí?;
3. ¿qué imprime?

## Caso 2 · Operadores

```kotlin
val edad = 19
val tieneEntrada = false
val puedeIngresar = edad >= 18 && tieneEntrada

println(puedeIngresar)
```

Antes de ejecutar:

1. ¿qué valor queda en `puedeIngresar`?;
2. ¿qué operador obliga a que ambas condiciones sean verdaderas?;
3. cambia una sola variable para invertir el resultado.

## Caso 3 · Null safety · usar cuando el concepto ya haya sido cerrado en clase

```kotlin
val apodo: String? = null
val largo = apodo?.length ?: 0

println(largo)
```

Antes de ejecutar:

1. ¿por qué `apodo` acepta `null`?;
2. ¿qué evita `?.`?;
3. ¿qué papel cumple `?:`?;
4. ¿qué se imprime?

## Cierre rápido

El objetivo no es memorizar símbolos. Cada estudiante debe poder explicar el recorrido:

```text
dato
→ operación
→ resultado
→ salida
```

El docente puede cambiar un valor u operador y repetir inmediatamente la predicción.
