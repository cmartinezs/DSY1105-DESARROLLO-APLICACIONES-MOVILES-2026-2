# PocketLog · Proyecto formativo DSY1105

PocketLog es el proyecto longitudinal e incremental de **DSY1105 Desarrollo de Aplicaciones Móviles**.

`proyecto-formativo/` es una vertical independiente de `semanas/`, `labs/` y `examples/`.

## Estructura

```text
proyecto-formativo/
├── README.md
├── REQUERIMIENTOS.md
├── ROADMAP-SEMANAL.md
├── pocketlog/          # única base de código viva
├── semana-01/
├── semana-02/
├── semana-03/
└── historicos/
```

## Regla de continuidad

Cada semana depende obligatoriamente de la anterior. No se reinicia PocketLog ni se mantiene una copia completa del proyecto por semana.

Cada `semana-XX/` debe incluir:
- `README.md` como índice;
- checklist de inicio;
- varios Markdown secuenciales de implementación;
- checkpoints verificables;
- checklist de finalización;
- estado esperado para iniciar la semana siguiente.

## Semanas disponibles

- [Semana 01](./semana-01/)
- [Semana 02](./semana-02/)
- [Semana 03](./semana-03/)

## Código vivo e históricos

El código vigente vive en [`pocketlog/`](./pocketlog/). Los estados anteriores se reconstruyen mediante Git y se registran en [`historicos/`](./historicos/), evitando duplicar físicamente el proyecto.

- [Requerimientos funcionales](./REQUERIMIENTOS.md)
- [Roadmap semanal](./ROADMAP-SEMANAL.md)
- [Trazabilidad curricular](../docs/PROYECTO-FORMATIVO-TRANSVERSAL.md)
