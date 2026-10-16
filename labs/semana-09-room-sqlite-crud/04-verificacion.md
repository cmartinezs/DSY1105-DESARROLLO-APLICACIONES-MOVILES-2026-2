# 04 · Probar CRUD, persistencia y ruiditas

[← Interfaz](03-interfaz.md) · [Siguiente → Desafío](05-desafio-entrega.md)

## Paso 9 · Pruebas manuales reproducibles

| Caso | Acción | Resultado |
|---|---|---|
| Create | Guardar «Estudiar Room» | Aparece una fila; contador 1 |
| Read | Guardar otras dos notas | Tres tarjetas, ID descendente |
| Update | Editar una y guardar otro texto | Cambia una fila; el total no aumenta |
| Delete | Eliminar una | Desaparece; el contador disminuye |
| Validación | Intentar guardar espacios | Botón deshabilitado; sin registro |
| Persistencia | Cerrar completamente y reabrir | Siguen las notas restantes |
| Edición cancelada | Pulsar Editar y luego Cancelar | No cambia SQLite |

🔔 **Checkpoint 7:** registra evidencia de las siete pruebas.

## Paso 10 · Verificar el archivo SQLite

En Android Studio, ejecuta la app y abre **View → Tool Windows → App Inspection → Database Inspector**. Selecciona `mis_notas.db` y la tabla `notas`. Consulta:

```sql
SELECT id, texto FROM notas ORDER BY id DESC;
```

El ID debe mantenerse cuando editas; al borrar, desaparece la fila. Los ID eliminados **no** tienen por qué reutilizarse.

🔔 **Checkpoint 8:** una captura de Database Inspector demuestra almacenamiento real, no solo estado de Compose.

## Paso 11 · Ruiditas opcionales

Las **campanitas 🔔** de este material son puntos de control docentes. Si quieres además una ruidita literal del teléfono, existe el pequeño archivo [Sonidos.kt](referencia/app/src/main/java/cl/duoc/misnotasroom/ui/Sonidos.kt) para usar `ToneGenerator`:

```kotlin
reproducirConfirmacion()
```

Puedes llamarlo tras pulsar Guardar/Actualizar/Eliminar como **respuesta táctil-auditiva al clic**, pero eso **no confirma** que Room haya terminado. Para sonidos de éxito reales, el ViewModel tendría que emitir un evento **después** de completar la operación y la UI reaccionar. Es una mejora posterior, no requisito del CRUD.

## Diagnóstico

- `Unresolved reference: ksp`: plugin ausente o incompatible.
- `Cannot find implementation for AppDatabase`: problema en generación Room/KSP.
- Error al observar `collectAsStateWithLifecycle`: falta `lifecycle-runtime-compose`.
- Lista no se actualiza: confirma `Flow` y su observación.
- Datos desaparecen: revisa si desinstalaste la app, limpiaste datos o cambiaste nombre de base.
- Error de schema al agregar campos: requiere migración o recreación consciente de una base de prueba; no uses borrado silencioso en producción.
