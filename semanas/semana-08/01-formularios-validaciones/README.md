# Profundización · StateFlow, errores y responsabilidad del ViewModel

## Estado único del formulario

El formulario se modela como una estructura completa. El ViewModel modifica copias del estado y expone un `StateFlow` observable.

## Errores por campo

Separar `UsuarioErrores` evita esconder strings de error dentro de múltiples Composables y permite actualizar sólo la condición corregida.

## Eventos de campo

Cada cambio puede limpiar el error del campo correspondiente antes de la siguiente validación final.

## Validación reactiva y validación final

No son equivalentes:

- reactiva: entrega feedback mientras cambia el estado;
- final: protege la acción antes de navegar.

## collectAsState

Compose observa el flujo y recompone cuando cambia el estado.

```kotlin
val estado by viewModel.estado.collectAsState()
```

## Shared ViewModel

Guía 11 usa el mismo `UsuarioViewModel` en Registro y Resumen. El objetivo es que la segunda pantalla observe el mismo estado sin transportar todos los datos como argumentos de ruta.

## Navegación después de validar

```text
RegistroScreen
→ validarFormulario()
→ true
→ navController.navigate("resumen")
→ ResumenScreen
→ mismo ViewModel
```

## Límite arquitectónico

El ViewModel mantiene datos y validación; la capa de navegación conoce `NavController`. No hace falta acoplarlos.
