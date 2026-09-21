# PocketLog · Matriz de trazabilidad requisito → concepto → evidencia

| ID | Requerimiento | Concepto que lo habilita | Primera evidencia completa |
|---|---|---|---|
| RF-01 | Registrar | variables + funciones; luego modelo | S1 parcial / S3 completo |
| RF-02 | Mostrar/listar | salida; luego colecciones | S1 parcial / S3 completo |
| RF-03 | Completar | condicional + función | S1 |
| RF-04 | Buscar ID | recorrido de colección | S3 |
| RF-05 | Filtrar categoría | colecciones + predicado | S3 |
| RF-06 | Filtrar estado | condicional/colecciones | S2 parcial / S3 completo |
| RF-07 | Contar | colección + `count` o recorrido | S3 |
| RF-08 | Validar | null safety, `toIntOrNull`, `try/catch` | S1→S4 incremental |
| RF-09 | Múltiples entradas | `MutableList` | S3 |
| RF-10 | Android | Android Studio + Compose | S6 |
| RF-11 | UI/comportamiento | estado + ViewModel | S6 |
| RF-12 | Navegación multipantalla | Navigation Compose + rutas + back stack | S7 |
| RF-13 | Ver detalle de registro | argumento simple por ID + pantalla de detalle | S7 |
| RF-14 | Adaptabilidad visual básica | constraints, ancho máximo y layouts flexibles | S7 |

Evidencias: `checkpoints/semana-01` a `checkpoints/semana-07`. Semana 5 es pausa documentada, no código nuevo.
