# PocketLog vivo

Esta carpeta contiene la **versión objetivo vigente** del proyecto formativo transversal.

## Estado curricular actual

- Semana 01 → **v0.1 conceptual**: presentación del problema y del proyecto, sin implementación formal.
- Semana 02 → **v0.2 procedural**: Kotlin de consola con datos simples, funciones y colecciones.
- Semana 03 → **v0.3 orientada a objetos**: modelo `Registro`, colecciones de objetos, control de errores y sintaxis avanzada acorde a la unidad.

El archivo actual es:

- [PocketLog.kt](./PocketLog.kt)

## Regla de trazabilidad

El proyecto vivo muestra **a dónde debe llegar PocketLog según el contenido curricular disponible**. El avance real de la sección se registra por separado en `data/weekly/semana-XX.yml` y puede ir detrás sin que se falsifique el historial.

```text
programa / semana vigente
        ↓
versión objetivo PocketLog
        ↓
avance real registrado
        ↓
checkpoint histórico confirmado
```

No crear copias vivas por semana:

```text
NO pocketlog-semana-03/
NO pocketlog-semana-04/
```

Las instrucciones están en `../guias/` y los hitos históricos en `../checkpoints/`.

PocketLog permanece en **Kotlin de consola** durante esta etapa. No incorporar todavía Android, Compose, ViewModel, SQLite, Retrofit ni una arquitectura no exigida por el contenido real.
