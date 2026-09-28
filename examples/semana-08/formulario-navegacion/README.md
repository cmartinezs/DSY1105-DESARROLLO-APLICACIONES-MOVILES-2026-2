# Ejemplo 5 · Registro → Resumen con ViewModel compartido

## Objetivo

Integrar formulario reactivo, validación, navegación y visualización del mismo estado en una segunda pantalla.

## Flujo

```text
RegistroScreen
→ UsuarioViewModel
→ validarFormulario()
→ "resumen"
→ ResumenScreen
→ mismo UsuarioViewModel
```

## Navegación

```kotlin
if (viewModel.validarFormulario()) {
    navController.navigate("resumen")
}
```

## Resumen

```kotlin
val estado by viewModel.estado.collectAsState()

Text("Nombre: " + estado.nombre)
Text("Correo: " + estado.correo)
```

## Modifica

Agrega una acción Volver y permite corregir un dato manteniendo el mismo estado.

## Explica

¿Por qué no fue necesario pasar nombre, correo y dirección como argumentos de ruta?
