# `it`, parámetros explícitos y múltiples parámetros

Cuando una lambda recibe un solo parámetro, Kotlin permite omitir su nombre y usar `it`.

Forma explícita:

```kotlin
val positivos = numeros.filter { numero -> numero > 0 }
```

Forma abreviada:

```kotlin
val positivos = numeros.filter { it > 0 }
```

## ¿De dónde sale `it`?

No es una variable global ni una palabra mágica independiente. Kotlin la ofrece como nombre implícito cuando la lambda tiene exactamente un parámetro y no declaramos otro nombre.

## Cuándo conviene nombrar el parámetro

```kotlin
usuarios.filter { usuario -> usuario.activo }
```

puede ser más claro que:

```kotlin
usuarios.filter { it.activo }
```

especialmente cuando la expresión crece o existen lambdas anidadas.

## Más de un parámetro

Cuando hay varios parámetros deben declararse:

```kotlin
val suma = { a: Int, b: Int -> a + b }
```

Aquí `it` ya no sirve porque no existe un único parámetro implícito.

## Regla de legibilidad

Usa `it` cuando la lambda sea corta y el significado del elemento sea evidente. Usa un nombre explícito cuando ayude a explicar el dominio o evite ambigüedad.
