# De la forma larga a la idiomática

Para aprender Kotlin sin saltos bruscos conviene transformar una llamada paso a paso.

Partimos con:

```kotlin
val pares = numeros.filter({ numero: Int ->
    numero % 2 == 0
})
```

## 1. El tipo puede inferirse

```kotlin
val pares = numeros.filter({ numero ->
    numero % 2 == 0
})
```

`filter` ya conoce el tipo de elementos de `numeros`, por lo que Kotlin puede inferir el tipo del parámetro de la lambda.

## 2. La lambda es el último argumento

```kotlin
val pares = numeros.filter() { numero ->
    numero % 2 == 0
}
```

## 3. Los paréntesis están vacíos

```kotlin
val pares = numeros.filter { numero ->
    numero % 2 == 0
}
```

## 4. Existe un único parámetro

```kotlin
val pares = numeros.filter {
    it % 2 == 0
}
```

## La transformación completa

```text
filter({ numero: Int -> ... })
            ↓ inferencia
filter({ numero -> ... })
            ↓ trailing lambda
filter { numero -> ... }
            ↓ parámetro implícito
filter { it ... }
```

Cada paso elimina información que el compilador puede reconstruir, no conceptos del programa.

El objetivo pedagógico es que puedas viajar en ambas direcciones: compactar una forma explícita y expandir una forma idiomática cuando necesites comprenderla.
