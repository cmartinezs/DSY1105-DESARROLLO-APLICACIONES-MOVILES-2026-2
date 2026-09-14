# PocketLog · Requerimientos funcionales

PocketLog es un registro personal de tareas/pendientes. Los requerimientos se conocen como producto, pero se implementan sólo cuando el conocimiento de la asignatura lo permite.

## Convención

- **RF**: requerimiento funcional.
- **RN**: regla de negocio.
- **Habilitado**: se implementa en el checkpoint de la semana.
- **Conocido**: se explica, pero puede quedar pendiente técnicamente.

## Requerimientos

### RF-01 · Registrar una entrada
El usuario puede registrar una entrada con identificador, título, categoría y estado.

Reglas: identificador positivo; título y categoría obligatorios; una entrada nueva comienza pendiente.

### RF-02 · Mostrar entradas
El usuario puede visualizar una entrada y, cuando existan colecciones, listar todas.

### RF-03 · Cambiar estado
El usuario puede marcar una entrada pendiente como completada.

### RF-04 · Buscar por identificador
El usuario puede localizar una entrada por su ID.

### RF-05 · Filtrar por categoría
El usuario puede ver entradas de una categoría determinada.

### RF-06 · Filtrar por estado
El usuario puede distinguir pendientes y completadas.

### RF-07 · Contar entradas
El sistema informa total, pendientes y completadas.

### RF-08 · Validar datos
El sistema rechaza valores inválidos y evita terminar abruptamente por entradas no numéricas.

### RF-09 · Mantener múltiples entradas
El sistema conserva más de una entrada durante la ejecución.

### RF-10 · Presentar el producto en Android
La funcionalidad acumulada se expone mediante Jetpack Compose.

### RF-11 · Separar UI y comportamiento
En Android, la interfaz emite eventos y observa estado; el comportamiento no queda mezclado dentro de composables.

## Habilitación real por semana

| Requerimiento | S1 | S2 | S3 | S4 | S5 | S6 |
|---|---:|---:|---:|---:|---:|---:|
| RF-01 registrar | parcial | sí | sí | sí | pausa | sí |
| RF-02 mostrar/listar | parcial | parcial | sí | sí | pausa | sí |
| RF-03 completar | sí, un registro | sí, un registro | sí | sí | pausa | sí |
| RF-04 buscar ID | conocido | conocido | sí | sí | pausa | sí |
| RF-05 categoría | parcial | parcial | sí | sí | pausa | sí |
| RF-06 estado | parcial | sí | sí | sí | pausa | sí |
| RF-07 contar | no | no | sí | sí | pausa | sí |
| RF-08 validar | inicial | sí | sí | sí | pausa | sí |
| RF-09 múltiples | no | no | sí | sí | pausa | sí |
| RF-10 Android | no | no | no | exploración | pausa | sí |
| RF-11 separación UI | no | no | no | no | pausa | sí |

La tabla refleja el **avance pedagógico real**, no la arquitectura ideal. Semana 2 no utiliza colecciones porque al cierre real todavía no habían sido trabajadas; entran al comienzo de Semana 3.
