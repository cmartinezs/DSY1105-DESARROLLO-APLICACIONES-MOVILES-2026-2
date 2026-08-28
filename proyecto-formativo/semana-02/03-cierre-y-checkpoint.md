# PocketLog · Semana 02 · Cierre y checkpoint

## Estado esperado

PocketLog v0.2 debe demostrar únicamente contenidos trabajados hasta esta semana: variables, tipos, `val`/`var`, salida por consola, condicionales, ciclos, funciones, `List`, `MutableList` y operaciones de colección cuando hayan sido comprendidas.

## Checklist de cierre

- [ ] El proyecto ejecuta desde el estado vivo en [`../pocketlog/`](../pocketlog/).
- [ ] Muestra todos los registros correctamente.
- [ ] Un filtro por categoría entrega los resultados esperados.
- [ ] El conteo de pendientes coincide con los datos.
- [ ] Una transformación con `map` conserva la cantidad de elementos.
- [ ] Puedo explicar la diferencia entre resolver manualmente con ciclos y usar `filter`, `map` o `count`.
- [ ] Identifico la fragilidad de mantener listas paralelas sin adelantar todavía la solución de POO.

## Checkpoint histórico

La referencia estable de cierre está en:

➡️ [`../checkpoints/semana-02/PocketLog.kt`](../checkpoints/semana-02/PocketLog.kt)

El checkpoint es una evidencia histórica; la Semana 03 continúa modificando el proyecto vivo, no una copia nueva.

## Deuda observable

Actualmente `titulos`, `categorias` y `completados` dependen de índices sincronizados. Registra por qué esto puede fallar si las colecciones se desalinean.

**Checkpoint final:** ejecuta PocketLog, cambia al menos un dato, vuelve a ejecutar y confirma que el comportamiento sigue siendo coherente.

➡️ [Exploración opcional](./EXPLORA.md)
