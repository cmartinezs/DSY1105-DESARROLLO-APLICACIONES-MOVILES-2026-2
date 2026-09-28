# Ejemplo 3 · UiState + modelo de errores

## Objetivo

Agrupar los datos y errores del formulario.

```kotlin
data class FormErrores(
    val nombre: String? = null,
    val correo: String? = null
)

data class FormUiState(
    val nombre: String = "",
    val correo: String = "",
    val errores: FormErrores = FormErrores()
)
```

## Modifica

Agrega un campo opcional y su representación en el estado.

## Explica

¿Qué ventaja tiene modelar errores junto al estado en vez de mantener variables sueltas en cada Composable?
