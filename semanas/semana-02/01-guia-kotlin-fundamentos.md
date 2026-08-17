# Guía práctica · Kotlin fundamentos

Esta guía acompaña **1.2.1 Programación en Kotlin y sus fundamentos** y **1.2.2 Guía 2 – Aplicando Kotlin Básico**.

La idea no es memorizar sintaxis: cada concepto se prueba inmediatamente en IntelliJ.

## 1. `val` y `var`

```kotlin
val nombre = "Ana"
var intentos = 1
intentos = intentos + 1
```

- `val`: referencia que no será reasignada.
- `var`: referencia cuyo valor puede cambiar.

**Regla práctica:** partir con `val`; cambiar a `var` solo cuando el problema requiere reasignación.

## 2. Tipos e inferencia

```kotlin
val edad = 20
val promedio = 5.8
val activo = true
val curso = "DSY1105"
```

## 3. String templates

```kotlin
val nombre = "Camila"
val nota = 6.1
println("$nombre obtuvo nota $nota")
println("Aprobó: ${nota >= 4.0}")
```

## 4. Conversiones

```kotlin
val texto = "42"
val numero = texto.toIntOrNull()
```

## 5. `if` como expresión

```kotlin
val nota = 5.2
val estado = if (nota >= 4.0) "Aprobado" else "Reprobado"
```

## 6. `when`

```kotlin
val opcion = 2
val mensaje = when (opcion) {
    1 -> "Crear"
    2 -> "Editar"
    3 -> "Eliminar"
    else -> "Opción desconocida"
}
```

## 7. Ciclos

```kotlin
for (numero in 1..5) println(numero)
```

```kotlin
var contador = 1
while (contador <= 3) {
    println(contador)
    contador++
}
```

## 8. Funciones

```kotlin
fun calcularDescuento(precio: Double, porcentaje: Double): Double {
    return precio * porcentaje / 100
}

fun esAprobado(nota: Double): Boolean = nota >= 4.0
```

## 9. Primera lista

```kotlin
val notas = listOf(5.5, 4.8, 6.2)
for (nota in notas) println(nota)
```

`MutableList`, `map` y `filter` se profundizan en la segunda sesión.

## Rutina práctica

Después de cada apartado:

1. ejecutar;
2. cambiar un dato;
3. predecir la nueva salida;
4. provocar un error pequeño;
5. leer el mensaje del compilador;
6. corregir y explicar.

## Errores frecuentes

- usar `var` para todo;
- confundir `=` con `==`;
- olvidar que `1..5` incluye ambos extremos;
- usar `toInt()` sobre texto inválido sin considerar error;
- escribir toda la lógica en `main` aunque sea reutilizable.
