# Laboratorio Semana 06 · ChecklistDiaria

## Propósito
Construir **desde cero** una app útil de una pantalla aplicando:
```text
modelo → repository en memoria → UiState → ViewModel → Compose
```

La app crea tareas breves y permite marcarlas como completadas.

## Paso 0 · Proyecto
Crea **Empty Activity**, Kotlin + Compose, minSdk 26+. Ejecuta el template antes de cambiarlo.

**Checkpoint 0:** la app inicial abre.

## Paso 1 · Reconocer Compose
Ubica `MainActivity`, `setContent`, `MaterialTheme` y una función `@Composable`.

## Paso 2 · Modelo
```kotlin
data class Tarea(
    val id: Int,
    val titulo: String,
    val completada: Boolean = false
)
```

## Paso 3 · Repository temporal
Crea `TareaRepository` con lista privada, IDs, `listar()`, `agregar(titulo)` y `alternar(id)`. No uses Room.

## Paso 4 · UiState
Incluye: texto actual, lista, mensaje opcional, total y completadas.

## Paso 5 · ViewModel
Implementa `cambiarTitulo`, `agregar`, `alternar` y `refrescar`. No permitas títulos vacíos.

**Checkpoint 1:** las reglas no viven en Compose.

## Paso 6 · UI por capas
Agrega en orden:
1. título;
2. resumen;
3. OutlinedTextField;
4. botón Agregar;
5. mensaje;
6. LazyColumn;
7. Card por tarea.

Compila después de cada bloque.

## Paso 7 · Eventos
`ChecklistScreen` recibe estado y callbacks. Nunca recibe el repository.

## Paso 8 · Activity
La Activity obtiene ViewModel, observa `uiState`, dibuja Screen y conecta callbacks.

## Paso 9 · Pruebas
| Caso | Esperado |
|---|---|
| agregar vacío | validación |
| agregar tarea | aparece |
| segunda tarea | ambas visibles |
| completar | cambia estado |
| volver a pulsar | vuelve a pendiente |
| resumen | coincide |

## Paso 10 · Explica
```text
usuario → Screen → callback → ViewModel → Repository → UiState → recomposición
```

## Paso 11 · DevLog
Incluye captura, estructura, una decisión, un error resuelto, qué se pierde al cerrar la app y qué resolvería persistencia.

## Límites
Sin Navigation, Room/SQLite, REST, cámara, DI ni múltiples pantallas.

La Semana 7 agregará jerarquía visual, adaptabilidad y navegación.
