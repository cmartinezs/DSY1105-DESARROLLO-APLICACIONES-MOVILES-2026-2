# Persistencia de preferencias y recursos nativos
## Preferencias
Preferences DataStore es apropiado para valores de configuración pequeños: meta diaria, tema visual, elección de orden. Sus datos se leen como `Flow`; `edit` modifica preferencias de forma transaccional. No reemplaza una base relacional.

## Diseño recomendado
Compose observa un `UiState` del ViewModel; el ViewModel recibe eventos, delega la escritura; el repositorio encapsula DataStore. Evitar escribir en DataStore directamente desde un botón Composable. El flujo inicial puede emitir un valor predeterminado antes de cargar almacenamiento.

## Recursos nativos
Una API de cámara, ubicación o sensores sólo se introduce cuando el problema la necesita. Antes de integrarla revisar permiso, denegación, disponibilidad de hardware, impacto en privacidad y alternativa. Las miniapps nativas independientes exploran cada capacidad con profundidad; no agregarlas a FocusCounter ni a PocketLog sólo para cumplir una lista.

## Puente a semana 10
Guardar un registro con ID, fecha y categoría requiere consultas estructuradas: SQLite/Room. La clase del 12/10 se pierde por feriado; la introducción conceptual se hace esta semana y la implementación guiada queda para el 15/10.
