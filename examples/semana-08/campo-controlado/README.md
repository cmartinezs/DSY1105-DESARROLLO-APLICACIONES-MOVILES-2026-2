# Ejemplo 1 · Campo controlado

## Objetivo

Entender que el valor visible de un campo proviene del estado.

```kotlin
@Composable
fun NombreForm() {
    var nombre by remember { mutableStateOf("") }

    OutlinedTextField(
        value = nombre,
        onValueChange = { nombre = it },
        label = { Text("Nombre") }
    )

    Text("Actual: " + nombre)
}
```

## Modifica

Agrega un botón para limpiar el campo.

## Explica

¿Por qué el `OutlinedTextField` no debe convertirse en una segunda fuente de verdad?
