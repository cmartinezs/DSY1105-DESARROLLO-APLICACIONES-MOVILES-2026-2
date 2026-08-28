# PocketLog · Proyecto formativo DSY1105

PocketLog es el proyecto formativo longitudinal de **DSY1105 Desarrollo de Aplicaciones Móviles**.

Es una vertical independiente de `semanas/`, `labs/` y `examples/`. Aquí se aplica explícitamente el material, tecnologías, servicios y plataformas indicados por la asignatura sobre una única base de código viva.

## Principio de continuidad

Cada semana requiere que la anterior haya sido completada. No se reinicia el proyecto y no se mantiene una copia completa del código por semana.

```text
proyecto-formativo/
├── README.md
├── REQUERIMIENTOS.md
├── ROADMAP-SEMANAL.md
├── pocketlog/          # única base de código viva
├── semana-01/          # documentación incremental
├── semana-02/
├── semana-03/
└── historicos/         # referencias a hitos Git
```

## Contrato de cada semana

Cada `proyecto-formativo/semana-XX/` debe contener un `README.md` índice y varios Markdown secuenciales.

Debe incluir obligatoriamente:
- checklist de inicio;
- objetivo del incremento;
- materias aplicadas;
- secuencia de implementación dividida en varios `.md`;
- checkpoints verificables;
- cambios aplicados sobre `pocketlog/`;
- checklist de finalización;
- estado esperado para iniciar la semana siguiente.

No se acepta como formato objetivo una única guía Markdown extensa.

## Código vivo e históricos

`pocketlog/` contiene el código vigente. Los estados anteriores se conservan mediante Git y se registran en `historicos/`; no se duplican físicamente 18 versiones del proyecto.

## Conciliación de estructura legacy

La ruta histórica `proyecto-formativo/guias/semana-XX/` no corresponde al contrato canónico actual. Debe considerarse legacy durante la migración hacia `proyecto-formativo/semana-XX/`.

A partir de esta conciliación, todo contenido semanal nuevo se crea directamente en `proyecto-formativo/semana-XX/`.

- [Requerimientos funcionales](./REQUERIMIENTOS.md)
- [Roadmap semanal](./ROADMAP-SEMANAL.md)
- [Trazabilidad curricular](../docs/PROYECTO-FORMATIVO-TRANSVERSAL.md)
