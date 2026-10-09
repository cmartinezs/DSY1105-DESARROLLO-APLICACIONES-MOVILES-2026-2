# Ejemplo 01 · remember
En un Composable dentro de una Empty Activity Compose:

```kotlin
@Composable
fun Contador() {
    var sesiones by remember { mutableIntStateOf(0) }
    Column {
        Text("Sesiones: $sesiones")
        Button(onClick = { sesiones++ }) { Text("Agregar") }
    }
}
```

**Checkpoint:** al pulsar cambia texto inmediatamente. Rota el dispositivo y observa qué ocurre. `remember` no ofrece restauración tras recreación.
