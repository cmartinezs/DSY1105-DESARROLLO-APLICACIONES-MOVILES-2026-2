# Ejemplo 2 · Validación visible

## Objetivo

Representar un error de manera explícita y comprensible.

```kotlin
val invalido = nombre.isNotBlank() && nombre.trim().length < 3

OutlinedTextField(
    value = nombre,
    onValueChange = { nombre = it },
    isError = invalido,
    supportingText = {
        if (invalido) Text("Mínimo 3 caracteres")
    }
)
```

## Modifica

Evita que un nombre formado sólo por espacios sea válido.

## Explica

¿Por qué un mensaje específico ayuda más que mostrar solamente "Error"?
