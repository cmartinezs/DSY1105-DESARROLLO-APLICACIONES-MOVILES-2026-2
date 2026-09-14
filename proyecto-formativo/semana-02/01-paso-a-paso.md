# Semana 02 · Paso a paso

## Menú
```kotlin
fun mostrarMenu() {
    println("1. Registrar")
    println("2. Mostrar")
    println("3. Completar")
    println("4. Estado")
    println("0. Salir")
}
```

## Ciclo
```kotlin
var ejecutando = true
while (ejecutando) {
    mostrarMenu()
    when (readln().toIntOrNull()) {
        1 -> { /* registrar */ }
        2 -> { /* mostrar */ }
        3 -> { /* completar */ }
        4 -> { /* estado */ }
        0 -> ejecutando = false
        else -> println("Opción inválida")
    }
}
```

Validar textos vacíos y probar letras como opción. El checkpoint conserva deliberadamente un solo registro.
