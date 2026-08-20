# Variables, tipos, `val` y `var`

La guía base presenta la equivalencia inicial entre Java y Kotlin. Aquí profundizamos en qué cambia realmente.

## El tipo no desaparece

Cuando Kotlin permite escribir:

```kotlin
val nombre = "MichiApp"
```

no significa que la variable no tenga tipo. El compilador infiere `String` a partir del valor inicial.

También es válido escribirlo explícitamente:

```kotlin
val nombre: String = "MichiApp"
```

La inferencia reduce ruido cuando el tipo ya es evidente.

## `val` no significa necesariamente objeto inmutable

`val` impide reasignar la referencia:

```kotlin
val nombre = "MichiApp"
// nombre = "OtraApp" // no compila
```

Pero si una referencia apunta a un objeto mutable, el estado interno de ese objeto podría cambiar. Por tanto:

```text
val → referencia no reasignable
var → referencia reasignable
```

No debe simplificarse como `val = todo inmutable`.

## ¿Por qué preferir `val`?

Porque expresa intención. Si un dato no necesita cambiar, declarar esa restricción reduce estados posibles y hace el código más fácil de razonar.

## Comparación mental

```text
Java                     Kotlin
String nombre             val nombre: String
int descargas             var descargas: Int
```

Kotlin mueve el tipo después del nombre y permite omitirlo cuando puede inferirlo.

## Preguntas para comprobar comprensión

1. ¿La inferencia elimina el tipo de una variable?
2. ¿Qué impide exactamente `val`?
3. ¿Cuándo usarías `var` en vez de `val`?
