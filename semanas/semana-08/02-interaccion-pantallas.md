# 02 · Navegación y paso de información mediante ViewModel compartido

## Punto de partida

Semana 7 dejó navegación funcional. Guía 11 plantea un flujo distinto al detalle por ID: Registro y Resumen comparten el mismo estado de formulario.

## Flujo

```text
RegistroScreen
→ eventos de campos
→ UsuarioViewModel
→ MutableStateFlow
→ validarFormulario()
→ navegar a "resumen"
→ ResumenScreen
→ mismo UsuarioViewModel
→ collectAsState()
```

## RegistroScreen

La pantalla observa `estado` y conecta callbacks con funciones del ViewModel.

## Navegar sólo después del éxito

```kotlin
Button(
    onClick = {
        if (viewModel.validarFormulario()) {
            navController.navigate("resumen")
        }
    }
) {
    Text("Continuar")
}
```

## ResumenScreen

```kotlin
@Composable
fun ResumenScreen(viewModel: UsuarioViewModel) {
    val estado by viewModel.estado.collectAsState()

    Column {
        Text("Nombre: " + estado.nombre)
        Text("Correo: " + estado.correo)
        Text("Dirección: " + estado.direccion)
    }
}
```

## ¿Por qué no pasar todos los datos por la ruta?

En este ejercicio el formulario pertenece a un flujo compartido. La ruta representa el destino; el ViewModel compartido mantiene el estado del proceso.

Eso no invalida el patrón de Semana 7 de pasar un ID a un detalle. Son problemas distintos.

## AppNavigation

```text
registro
resumen
```

El mismo ViewModel debe ser utilizado por ambos destinos.

## Definition of Done

Puedes explicar cómo los datos escritos en RegistroScreen aparecen en ResumenScreen sin serializarlos en la ruta y sin duplicar el estado.
