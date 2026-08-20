# De sintaxis explícita a sintaxis idiomática

Kotlin permite escribir código muy compacto, pero en esta asignatura la progresión debe ser intencional: **primero entender, después abreviar**.

## Ejemplo 1 · tipo explícito e inferido

```kotlin
val nombre: String = "MichiApp"
```

Después de comprender el tipo:

```kotlin
val nombre = "MichiApp"
```

## Ejemplo 2 · función con bloque y función expresión

Forma explícita:

```kotlin
fun esPopular(descargas: Int): Boolean {
    return descargas >= 1000
}
```

Forma idiomática:

```kotlin
fun esPopular(descargas: Int) = descargas >= 1000
```

## Ejemplo 3 · `if` que retorna valor

```kotlin
val estado = if (descargas >= 1000) {
    "Popular"
} else {
    "En crecimiento"
}
```

No necesitamos crear una variable, modificarla dentro de cada rama y luego utilizarla.

## Criterio de la asignatura

Una forma corta es apropiada cuando:

- el alumno entiende la forma explícita equivalente;
- la intención sigue siendo legible;
- la reducción no oculta un concepto que todavía estamos aprendiendo.

El objetivo no es escribir la menor cantidad de caracteres, sino llegar gradualmente a Kotlin idiomático sin convertir la sintaxis en magia.
