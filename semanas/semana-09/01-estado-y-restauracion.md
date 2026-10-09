# Estado de UI y restauración
## Tres preguntas
1. ¿Quién conserva el valor mientras Compose recompone? `remember`.
2. ¿Qué estado pequeño debe sobrevivir recreación y restauración permitida por Android? `rememberSaveable`.
3. ¿Qué valor debe quedar guardado en almacenamiento local? `DataStore` u otra persistencia.

`remember` no persiste al recrear la Activity; `rememberSaveable` usa estado guardable, **no equivale a almacenamiento permanente**; `ViewModel` sobrevive cambios de configuración habituales pero no garantiza sobrevivir muerte del proceso. `SavedStateHandle` permite restaurar estado guardable del ViewModel. Las entidades estructuradas se estudian la semana 10.

## Pruebas observables
Cambiar valor, forzar recomposición, rotar dispositivo, finalizar y reiniciar app. Distinguir cada mecanismo: no dar por válida una prueba de persistencia porque sobrevivió a la rotación.

## Flujo
UI → evento → estado → recomposición. Persistencia: evento → ViewModel → repositorio/preferencias → almacenamiento → Flow → UI.

## Preguntas de defensa
¿Qué ocurre al cerrar app? ¿Qué estado conviene guardar? ¿Qué falla si el usuario borra datos de la aplicación?
