# Checkpoint Semana 03 · PocketLog v0.3

Primer checkpoint con múltiples registros y POO.

```bash
kotlinc PocketLog.kt -include-runtime -d pocketlog-s3.jar
java -jar pocketlog-s3.jar
```

Incluye `MutableList`, `class Registro`, búsqueda, filtros, conteos y cambio de estado. No incluye `sealed class` ni corrutinas.
