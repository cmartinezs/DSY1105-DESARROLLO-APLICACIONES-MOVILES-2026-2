# PocketLog · Proyecto formativo DSY1105

PocketLog es el proyecto formativo longitudinal de **DSY1105 Desarrollo de Aplicaciones Móviles**.

Es una vertical independiente de `semanas/`, `labs/` y `examples/`. Aquí se aplica explícitamente el material, tecnologías, servicios y plataformas indicados por la asignatura sobre una única base de código viva.

## Principio de continuidad

PocketLog comienza en Semana 01 y evoluciona incrementalmente durante el semestre.

Cada semana **requiere que la anterior haya sido completada**. No se reinicia el proyecto y no se mantiene una copia completa del código por semana.

```text
proyecto-formativo/
├── README.md
├── REQUERIMIENTOS.md
├── ROADMAP-SEMANAL.md
├── pocketlog/          # única base de código viva
├── semana-01/          # documentación incremental
├── semana-02/
├── semana-03/
├── ...
└── historicos/         # referencias a hitos Git
```

## Contrato de cada semana

Cada `proyecto-formativo/semana-XX/` debe contener un `README.md` que actúe como índice y varios Markdown secuenciales de implementación.

La semana debe incluir obligatoriamente:

- **checklist de inicio**, verificando que el incremento anterior está terminado;
- objetivo del incremento;
- materias de la semana que se aplicarán;
- secuencia de implementación dividida en varios `.md`;
- checkpoints verificables durante la implementación;
- cambios aplicados sobre `pocketlog/`;
- **checklist de finalización**;
- estado esperado para poder iniciar la semana siguiente.

No se acepta como formato objetivo una única guía Markdown extensa que concentre toda la semana.

## Evolución inicial

```text
Semana 01 -> datos y funciones iniciales en Kotlin
Semana 02 -> fundamentos Kotlin y evolución funcional
Semana 03 -> colecciones + objetos + POO + manejo de errores
Semana 04 -> consolidación Kotlin previa al siguiente incremento curricular
```

- [Requerimientos funcionales](./REQUERIMIENTOS.md)
- [Roadmap semanal](./ROADMAP-SEMANAL.md)

## Código vivo e históricos

`pocketlog/` contiene el código vigente. Los estados anteriores se conservan mediante Git y se registran en `historicos/` mediante referencias de commit/tag; no se duplican físicamente 18 versiones del proyecto.

```text
código actual        -> pocketlog/
guía incremental     -> semana-XX/
estados anteriores   -> Git + historicos/
```

## Conciliación de estructura legacy

La ruta histórica `proyecto-formativo/guias/semana-XX/` no corresponde al contrato canónico actual. Debe considerarse legacy durante la migración hacia `proyecto-formativo/semana-XX/`.

A partir de esta conciliación, **todo contenido semanal nuevo del proyecto formativo se crea directamente en `proyecto-formativo/semana-XX/`**. Una vez migradas las semanas existentes, `guias/` debe quedar sólo como referencia histórica o eliminarse si ya no aporta trazabilidad.

Para decisiones docentes y trazabilidad curricular, ver [Proyecto formativo transversal · PocketLog](../docs/PROYECTO-FORMATIVO-TRANSVERSAL.md).
