# 01 · Formularios reactivos y validaciones

## Qué problema resolvemos

Guía 11 propone un flujo de registro donde los datos ingresados forman parte de un estado observable y la validación pertenece al ViewModel.

## Modelo de estado

```kotlin
data class UsuarioUiState(
    val nombre: String = "",
    val correo: String = "",
    val clave: String = "",
    val direccion: String = "",
    val aceptaTerminos: Boolean = false,
    val errores: UsuarioErrores = UsuarioErrores()
)

data class UsuarioErrores(
    val nombre: String? = null,
    val correo: String? = null,
    val clave: String? = null,
    val direccion: String? = null
)
```

## MutableStateFlow

```kotlin
class UsuarioViewModel : ViewModel() {
    private val _estado = MutableStateFlow(UsuarioUiState())
    val estado: StateFlow<UsuarioUiState> = _estado

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

## Observar desde Compose

```kotlin
val estado by viewModel.estado.collectAsState()
```

La UI representa el estado y emite eventos.

## Componentes

La guía trabaja explícitamente:
- `OutlinedTextField`;
- `PasswordVisualTransformation`;
- `Checkbox`;
- `Button`;
- `isError`;
- `supportingText`.

## Validación final

```kotlin
fun validarFormulario(): Boolean {
    // calcular errores
    // actualizar UsuarioErrores
    // retornar true sólo cuando todo sea válido
}
```

El botón puede anticipar condiciones evidentes, pero la acción final vuelve a validar.

## Flujo

```text
usuario escribe
→ callback
→ ViewModel actualiza MutableStateFlow
→ collectAsState observa
→ Compose representa

usuario presiona continuar
→ validarFormulario()
→ error o éxito
```

## Definition of Done

Puedes explicar por qué el formulario es reactivo, dónde vive la validación y cómo los errores forman parte del estado observable.
