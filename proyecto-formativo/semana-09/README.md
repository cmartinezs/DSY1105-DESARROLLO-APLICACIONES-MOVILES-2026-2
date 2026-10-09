# PocketLog v0.9 · Preferencias persistentes
## Recibe
PocketLog v0.8: formularios, validación, navegación y registros en memoria.

## Problema real
Al cerrar/reabrir, la configuración elegida por el usuario se pierde. **No** corregiremos aún pérdida de registros: eso corresponde a SQLite/Room en semana 10.

## Cambio mínimo
Incorporar preferencia persistente `mostrarCompletados` (o criterio equivalente de visualización) mediante Preferences DataStore. Mantener fuente de verdad en repositorio de preferencias y observar `Flow` desde el ViewModel. No guardar entidades como JSON dentro de DataStore.

## Implementación por etapas
1. Ejecuta checkpoint v0.8 y confirma filtros actuales.
2. Define valor predeterminado de preferencia.
3. Agrega dependencia DataStore compatible con el proyecto.
4. Crea repositorio de preferencias: leer Flow y escribir valor.
5. Expón preferencia en UiState/StateFlow del ViewModel; evita acceso directo a DataStore desde Compose.
6. Agrega control de UI para cambiar preferencia.
7. Prueba recreación, cierre/reapertura y comportamiento con registros en memoria.
8. Registra en DevLog qué persiste y qué **no**.

## Criterios de cierre
Preferencia persiste; estado visible es coherente con almacenamiento; funcionalidad v0.8 no se rompe; ViewModel no conoce detalles de Compose; registros siguen deliberadamente en memoria.

**Estado:** guía de evolución preparada, checkpoint Android v0.9 ejecutable y compilación todavía pendientes.
