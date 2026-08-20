# Tipos, inferencia, `val` y `var`

Kotlin es un lenguaje de tipado estático. Que muchas veces no escribamos el tipo no significa que el tipo no exista.

## Inferencia de tipos

```kotlin
val edad = 30
val promedio = 6.2
val nombre = "Ana"
```

El compilador infiere:

```text
edad     → Int
promedio → Double
nombre   → String
```

También podemos escribirlos explícitamente:

```kotlin
val edad: Int = 30
val promedio: Double = 6.2
val nombre: String = "Ana"
```

## `val` y `var`

```kotlin
val rut = "12345678-9"
var intentos = 0
```

`val` evita reasignar la referencia. `var` permite hacerlo.

```kotlin
intentos = intentos + 1
```

Una práctica útil es comenzar con `val` y cambiar a `var` solamente cuando el problema realmente requiera reasignación.

## El tipo puede inferirse mal para nuestra intención

```kotlin
val descuento = 5
```

Aquí Kotlin infiere `Int`. Si necesitamos un decimal:

```kotlin
val descuento = 5.0
```

Por eso la inferencia no reemplaza la necesidad de comprender los tipos.

## Preguntas de control

1. ¿Kotlin deja de ser tipado porque omite el tipo escrito?
2. ¿Cuál es la diferencia semántica entre `val` y `var`?
3. ¿Qué tipo se infiere para `5` y para `5.0`?
