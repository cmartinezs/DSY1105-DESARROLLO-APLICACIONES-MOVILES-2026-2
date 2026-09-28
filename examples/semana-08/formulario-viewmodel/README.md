# Ejemplo 4 · MutableStateFlow + ViewModel

## Objetivo

Mover el estado y la validación fuera del Composable.

```kotlin
class FormViewModel : ViewModel() {
    private val _estado = MutableStateFlow(FormUiState())
    val estado: StateFlow<FormUiState> = _estado

    fun onNombreChange(value: String) {
        _estado.update {
            it.copy(
                nombre = value,
                errores = it.errores.copy(nombre = null)
            )
        }
    }
}
```

En la pantalla:

```kotlin
val estado by viewModel.estado.collectAsState()
```

## Modifica

Agrega la actualización del correo y limpia su error al editar.

## Explica

¿Qué responsabilidad deja de pertenecer al Composable?
