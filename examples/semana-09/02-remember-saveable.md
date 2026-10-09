# Ejemplo 02 · rememberSaveable
Parte del ejemplo anterior y sustituye la declaración:

```kotlin
import androidx.compose.runtime.saveable.rememberSaveable
var sesiones by rememberSaveable { mutableIntStateOf(0) }
```

**Checkpoint:** incrementa a 3 y rota el teléfono. El valor debe restaurarse bajo las condiciones normales de estado guardado. Finaliza/reabre la app: no interpretes `rememberSaveable` como una base de datos.
