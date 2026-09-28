# Profundización · Estado de formulario y validación

## Validar no es decorar

La validación protege un requisito. Debe poder trazarse a una razón funcional.

## Estado derivado

No todo necesita almacenarse:

```kotlin
val puedeGuardar
    get() = nombre.trim().length >= 3 && correo.contains("@")
```

Si un valor puede derivarse confiablemente de otro estado, evita duplicarlo.

## Validación por campo vs validación de acción

Puede existir validación temprana para feedback y validación final antes de persistir/enviar.

## ViewModel

```kotlin
class PerfilViewModel : ViewModel() {
    var uiState by mutableStateOf(PerfilUiState())
        private set

    fun onNombreChange(value: String) {
        uiState = uiState.copy(nombre = value, nombreError = null)
    }

    fun guardar(): Boolean {
        val error = if (uiState.nombre.trim().length < 3) {
            "Nombre demasiado corto"
        } else null

        uiState = uiState.copy(nombreError = error)
        return error == null
    }
}
```

## StateFlow

La experiencia contempla posteriormente validación y estado con `StateFlow`. Si la sección ya lo trabaja, puede usarse. Si aún no, un estado observable simple es suficiente para comprender el patrón.

La arquitectura no debe volverse compleja sólo para anticipar una API futura.

## Errores como parte del estado

Un error visible es parte del estado de pantalla y debe desaparecer o cambiar cuando el usuario corrige la condición.

## Validación y navegación

La navegación ocurre **después** de que la operación sea válida:

```text
Guardar
→ ViewModel valida
→ válido
→ UI recibe resultado/evento
→ capa de navegación cambia destino
```

El ViewModel no necesita conocer `NavController`.
