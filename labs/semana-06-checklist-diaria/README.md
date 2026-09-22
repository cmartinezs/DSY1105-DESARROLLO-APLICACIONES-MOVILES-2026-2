# Laboratorio Semana 06 · ChecklistDiaria

## Propósito

Construir desde cero una aplicación Android pequeña e independiente para practicar:

- Jetpack Compose;
- componentes visuales básicos;
- `Modifier`;
- estado de pantalla;
- eventos mediante callbacks;
- `UiState`;
- `ViewModel`;
- `StateFlow`;
- separación UI / comportamiento;
- repository temporal en memoria.

Este laboratorio **no tiene relación funcional con PocketLog** y no continúa ningún laboratorio anterior.

## Resultado esperado

La aplicación permite:

- escribir una tarea;
- agregarla a una lista;
- impedir tareas vacías;
- marcar una tarea como completada o pendiente;
- mostrar total de tareas y cantidad completada.

El flujo principal es:

```text
usuario
→ ChecklistScreen
→ callback
→ ChecklistViewModel
→ TareaRepository
→ ChecklistUiState
→ Compose actualiza la pantalla
```

## Proyecto de referencia

Esta carpeta contiene un proyecto Android autónomo:

```text
semana-06-checklist-diaria/
├── settings.gradle.kts
├── build.gradle.kts
├── gradle.properties
└── app/
    ├── build.gradle.kts
    └── src/main/
        ├── AndroidManifest.xml
        └── java/cl/duoc/checklistdiaria/
            ├── MainActivity.kt
            ├── ChecklistScreen.kt
            ├── ChecklistViewModel.kt
            ├── Tarea.kt
            └── TareaRepository.kt
```

Puede abrirse directamente desde Android Studio seleccionando la carpeta `semana-06-checklist-diaria`.

La implementación incluida funciona como **checkpoint de referencia**. La recomendación para el estudiante es construir primero siguiendo los pasos y comparar el código sólo al finalizar.

---

## Paso 0 · Crear y ejecutar el proyecto

Si trabajas desde cero:

1. crea un proyecto **Empty Activity**;
2. usa Kotlin y Jetpack Compose;
3. minSdk 26 o superior;
4. ejecuta el template antes de modificarlo.

Si utilizas el proyecto incluido, ábrelo y ejecuta la aplicación antes de revisar el código.

**Checkpoint 0:** la aplicación abre correctamente.

---

## Paso 1 · Modelo

Crea:

```kotlin
data class Tarea(
    val id: Int,
    val titulo: String,
    val completada: Boolean = false
)
```

Pregúntate:

- ¿qué representa este objeto?;
- ¿qué información pertenece a la tarea?;
- ¿qué información sería sólo visual y por tanto no debería agregarse aquí?

---

## Paso 2 · Repository temporal

Crea `TareaRepository`.

Debe mantener:

- una colección privada;
- generación simple de IDs;
- `listar()`;
- `agregar(titulo)`;
- `alternar(id)`.

```text
TareaRepository
→ almacena tareas sólo mientras vive el proceso
```

No uses Room, SQLite, archivos ni red.

**Importante:** repository en memoria **no significa persistencia**.

---

## Paso 3 · UiState

Modela lo que la pantalla necesita representar:

```kotlin
data class ChecklistUiState(
    val titulo: String = "",
    val tareas: List<Tarea> = emptyList(),
    val mensaje: String? = null,
    val total: Int = 0,
    val completadas: Int = 0
)
```

La UI no debería reconstruir estos valores consultando directamente el repository.

---

## Paso 4 · ViewModel

Crea `ChecklistViewModel`.

Responsabilidades:

- recibir cambios del campo de texto;
- validar antes de agregar;
- coordinar el repository;
- alternar estado de una tarea;
- recalcular la fotografía de pantalla.

Implementa:

- `cambiarTitulo(valor)`;
- `agregar()`;
- `alternar(id)`;
- `refrescar()`.

Usa:

```text
MutableStateFlow privado
→ StateFlow público
```

**Checkpoint 1:** ninguna regla de agregar o completar vive dentro de un composable.

---

## Paso 5 · Construir la UI por capas

Construye `ChecklistScreen` progresivamente.

### 5.1 Encabezado

Agrega:

- título;
- resumen total/completadas.

### 5.2 Entrada

Agrega un `OutlinedTextField` controlado por:

```text
state.titulo
onTituloChange
```

### 5.3 Acción

Agrega un botón **Agregar** que emita `onAgregar`.

El botón no debe modificar listas.

### 5.4 Mensaje

Si `state.mensaje` tiene valor, muéstralo.

### 5.5 Lista

Usa `LazyColumn`.

Cada tarea se representa mediante una `Card` que muestra:

- título;
- estado PENDIENTE/COMPLETADA.

Al pulsarla, emite:

```kotlin
onAlternar(tarea.id)
```

**Checkpoint 2:** `ChecklistScreen` sólo recibe estado y callbacks.

---

## Paso 6 · Conectar MainActivity

La Activity:

1. obtiene el `ChecklistViewModel`;
2. observa `uiState` con `collectAsStateWithLifecycle()`;
3. llama `ChecklistScreen`;
4. conecta callbacks con funciones del ViewModel.

Debe quedar conceptualmente así:

```text
MainActivity
→ observa UiState
→ dibuja ChecklistScreen
→ conecta eventos
```

---

## Paso 7 · Casos manuales

Prueba al menos:

| Caso | Resultado esperado |
|---|---|
| abrir app | lista vacía y contadores en 0 |
| agregar vacío | muestra validación |
| agregar “Estudiar Kotlin” | aparece una tarea pendiente |
| agregar segunda tarea | aparecen ambas |
| pulsar una tarea | queda COMPLETADA |
| volver a pulsarla | vuelve a PENDIENTE |
| cambiar estados | contadores coinciden |
| cerrar completamente el proceso | los datos pueden perderse |

La última prueba es importante: explica **por qué** ocurre.

---

## Paso 8 · Explica el flujo

Sin mirar el código, debes poder explicar:

```text
usuario escribe
→ onTituloChange
→ ViewModel actualiza UiState
→ Compose representa el texto

usuario pulsa Agregar
→ onAgregar
→ ViewModel valida
→ Repository agrega
→ ViewModel refresca UiState
→ LazyColumn muestra la nueva tarea
```

---

## Paso 9 · DevLog

Registra:

- captura de la aplicación;
- estructura principal;
- una decisión de separación de responsabilidades;
- un error que hayas resuelto;
- qué se pierde al cerrar la app;
- qué tecnología futura podría resolver esa pérdida;
- commit final.

## Límites de Semana 06

No incorporar todavía:

- Navigation Compose;
- múltiples pantallas;
- Room/SQLite;
- REST;
- DI;
- cámara;
- adaptabilidad avanzada;
- lógica de negocio dentro de los composables.

`Scaffold` tampoco es requisito de este lab. La estructura visual con `Scaffold` se trabaja explícitamente en Semana 7.

## Definition of Done

El lab termina cuando:

- la aplicación ejecuta;
- puedes agregar y alternar tareas;
- la validación funciona;
- los contadores coinciden;
- la UI sólo representa estado y emite eventos;
- puedes explicar qué responsabilidad tiene cada una de estas piezas:

```text
Tarea
TareaRepository
ChecklistUiState
ChecklistViewModel
ChecklistScreen
MainActivity
```
