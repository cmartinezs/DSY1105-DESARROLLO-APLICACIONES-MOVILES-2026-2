# Semana 09 · Estado, persistencia local y recursos nativos
**5–10 octubre 2026 · DSY1105-009V · EA2**

## Ruta
1. [Estado y restauración](01-estado-y-restauracion.md)
2. [DataStore y recursos nativos](02-datastore-y-recursos-nativos.md)
3. [Ejercicio focalizado](ejercicios-basicos.md)
4. [Ejemplos progresivos](../../examples/semana-09/README.md)
5. [Laboratorio independiente FocusCounter](../../labs/semana-09-focuscounter/README.md)
6. [PocketLog v0.9](../../proyecto-formativo/semana-09/README.md)

## Objetivo
Diferenciar estado de UI, restauración del estado y persistencia durable. Demostrar una preferencia que permanece tras reiniciar normalmente la app.

## Sesiones
- Lunes 05/10 (3 HP): repaso StateFlow, ciclo de vida, remember/rememberSaveable, persistencia y demostraciones. **Plan, no evidencia de ejecución**.
- Jueves 08/10 (2 HP): ejercicio guiado, FocusCounter y puente a SQLite/Room.
- Lunes 12/10: feriado; sin clase. Jueves 15/10: SQLite/Room estructurado.

## Secuencia
Concepto → ejemplo pequeño → ejercicio autónomo → laboratorio desde cero → transferencia a PocketLog.

## Límites
DataStore sólo para preferencias; no persistir entidades de PocketLog antes de semana 10. No REST, DI ni hardware por exhibición. Recursos nativos se discuten en función de necesidad, permisos y fallos; las miniapps monofoco siguen su propia ruta. El proyecto VcM es autónomo y no recibe una solución modelo.

## Evidencia
Captura antes/después de recrear Activity; captura antes/después de cerrar y reabrir app; commits progresivos; DevLog con explicación de tres tipos de estado.
