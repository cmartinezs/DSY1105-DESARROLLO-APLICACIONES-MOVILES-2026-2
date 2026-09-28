# 01 · Formularios, validaciones y componentes interactivos

## Qué problema resolvemos

Un formulario no es una colección de `TextField`. Es una interacción donde el usuario intenta realizar una acción y la aplicación debe guiarlo para que los datos sean válidos.

## Campo controlado

```kotlin
var nombre by remember { mutableStateOf("") }

OutlinedTextField(
    value = nombre,
    onValueChange = { nombre = it },
    label = { Text("Nombre") }
)
```

El valor visible proviene del estado.

## Validación

Una regla debe responder a una necesidad real:

```kotlin
val nombreValido = nombre.trim().length >= 3
```

Evita reglas arbitrarias sin relación con el requerimiento.

## Mensaje de error

```kotlin
OutlinedTextField(
    value = nombre,
    onValueChange = { nombre = it },
    isError = nombre.isNotBlank() && !nombreValido,
    supportingText = {
        if (nombre.isNotBlank() && !nombreValido) {
            Text("Ingresa al menos 3 caracteres")
        }
    }
)
```

## Habilitar una acción

```kotlin
Button(
    enabled = nombreValido,
    onClick = onGuardar
) {
    Text("Guardar")
}
```

No confíes sólo en el botón deshabilitado: la lógica que guarda también debe validar.

## Estado de formulario

Cuando aparecen varios campos conviene agruparlos:

```kotlin
data class FormUiState(
    val nombre: String = "",
    val correo: String = "",
    val nombreError: String? = null,
    val correoError: String? = null,
    val guardando: Boolean = false
)
```

## Evento → validación → estado

```text
usuario escribe
→ callback
→ cambia estado
→ UI refleja el cambio

usuario guarda
→ validar
→ error o acción válida
→ nuevo estado
→ UI refleja resultado
```

## Qué evitar

- validar sólo al final sin feedback;
- reglas escondidas dentro de muchos Composables;
- mensajes genéricos como "error";
- duplicar el mismo dato en varios estados;
- mezclar navegación y validación dentro de cada campo.

## Definition of Done

Puedes cerrar este contenido cuando seas capaz de explicar dónde vive el dato, dónde se valida y cómo la UI reacciona tanto a éxito como a error.
