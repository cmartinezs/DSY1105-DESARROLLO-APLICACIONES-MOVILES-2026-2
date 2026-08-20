# Null-safety paso a paso

Kotlin incorpora la posibilidad de `null` en el sistema de tipos.

```kotlin
val nombre: String = "Ana"
val apodo: String? = null
```

`String` y `String?` son tipos distintos para el compilador.

## Acceso directo

Esto es seguro porque `nombre` no es nullable:

```kotlin
println(nombre.length)
```

Pero esto no compila directamente:

```kotlin
println(apodo.length)
```

porque `apodo` podría ser `null`.

## Safe call `?.`

```kotlin
println(apodo?.length)
```

Si `apodo` tiene valor, se evalúa `length`. Si es `null`, el resultado es `null`.

## Elvis `?:`

```kotlin
val largo = apodo?.length ?: 0
```

Se lee como: usa `apodo?.length`; si el resultado es `null`, usa `0`.

## Comprobación explícita

```kotlin
if (apodo != null) {
    println(apodo.length)
}
```

Kotlin puede aprovechar la comprobación previa y tratar el valor como no nulo dentro del bloque cuando corresponde.

## `!!`

```kotlin
println(apodo!!.length)
```

Significa que el programador afirma que el valor no es `null`. Si la afirmación es falsa, habrá una excepción. No debe usarse como solución automática ante una advertencia del compilador.

## Mapa mental

```text
T   → no nullable
T?  → nullable
?.  → acceso seguro
?:  → valor alternativo
!!  → forzar no-null, con riesgo
```
