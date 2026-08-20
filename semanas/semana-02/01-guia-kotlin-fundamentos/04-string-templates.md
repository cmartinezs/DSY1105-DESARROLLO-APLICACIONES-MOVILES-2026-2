# String templates y expresiones

Kotlin permite interpolar valores dentro de un `String` sin concatenar manualmente cada fragmento.

## Variable simple

```kotlin
val nombre = "Ana"
println("Hola $nombre")
```

## Expresión

Cuando necesitamos evaluar algo usamos `${...}`:

```kotlin
val precio = 1000
val cantidad = 3
println("Total: ${precio * cantidad}")
```

## Diferencia práctica

Java suele escribir:

```java
System.out.println("Total: " + (precio * cantidad));
```

Kotlin permite mantener la expresión dentro del texto:

```kotlin
println("Total: ${precio * cantidad}")
```

## Cuándo usar `$variable` y `${expresion}`

```text
$nombre           → valor simple
${nombre.length}  → expresión o acceso más complejo
${precio * 1.19}  → cálculo
```

## Legibilidad

Un string template puede contener expresiones, pero no conviene convertirlo en un lugar donde ocurra demasiada lógica. Si una expresión es difícil de leer, calcula primero el valor y luego insértalo.

```kotlin
val totalConIva = precio * 1.19
println("Total: $totalConIva")
```

La meta sigue siendo comunicar intención, no concentrar todo en una sola línea.
