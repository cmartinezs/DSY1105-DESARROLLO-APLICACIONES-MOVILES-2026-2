# Funciones y expresiones en Kotlin

Kotlin conserva la idea de función que ya conoces, pero permite expresarla con menos ceremonia.

## Función con bloque

```kotlin
fun obtenerEstado(descargas: Int): String {
    if (descargas >= 1000) {
        return "Popular"
    }
    return "En crecimiento"
}
```

## `if` como expresión

En Kotlin, `if` puede producir un valor:

```kotlin
fun obtenerEstado(descargas: Int): String {
    return if (descargas >= 1000) {
        "Popular"
    } else {
        "En crecimiento"
    }
}
```

Esto permite una forma aún más compacta:

```kotlin
fun obtenerEstado(descargas: Int): String =
    if (descargas >= 1000) "Popular" else "En crecimiento"
```

Las tres formas expresan la misma intención. La forma más corta no es automáticamente mejor: primero debe resultar legible.

## Parámetros y retorno

```kotlin
fun calcularPromedio(a: Double, b: Double): Double
```

Se lee así:

```text
fun → función
calcularPromedio → nombre
a: Double, b: Double → parámetros
: Double → tipo retornado
```

## Idea importante

La sintaxis idiomática debe aparecer después de comprender la forma explícita. No se trata de memorizar atajos, sino de reconocer que Kotlin permite tratar ciertas construcciones como expresiones.
