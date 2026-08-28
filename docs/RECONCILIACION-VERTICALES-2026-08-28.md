# Reconciliación de verticales · DSY1105 · 2026-08-28

## Objetivo

Conciliar la estructura real del repositorio con cuatro verticales independientes: `semanas/`, `labs/`, `examples/` y `proyecto-formativo/`.

## Hallazgos

### Semanas
Existe estructura hasta Semana 03 con `README.md`, pero todavía hay ejemplos y material ejecutable mezclado dentro de carpetas semanales.

### Labs
Existe un lab por semana hasta Semana 03. La principal deuda es documental: algunos labs concentran demasiado en `README.md`; deben dividirse en varios Markdown secuenciales, con checkpoints y dependencia explícita de labs anteriores.

### Examples
La carpeta existía sólo como índice mientras los ejemplos reales vivían en `semanas/`. Eso contradice la independencia de verticales. `examples/` queda definido como fuente canónica y lo antiguo dentro de `semanas/` queda como legacy a migrar.

### Proyecto formativo
PocketLog ya usa una base de código viva e históricos Git, pero existe una inconsistencia entre el contrato documentado (`proyecto-formativo/semana-XX/`) y la estructura real (`proyecto-formativo/guias/semana-XX/`). La ruta `guias/` queda como legacy a migrar.

## Contrato reconciliado

```text
/
├── semanas/
│   ├── README.md
│   └── semana-XX/
│       ├── README.md
│       ├── 01-materia.md
│       └── ampliacion-<tema>/README.md
├── labs/
│   ├── README.md
│   └── semana-XX-<nombre>/
│       ├── README.md
│       ├── 01-<etapa>.md
│       └── 02-<etapa>.md
├── examples/
│   ├── README.md
│   └── semana-XX/
│       ├── README.md
│       └── <ejemplo>/
└── proyecto-formativo/
    ├── README.md
    ├── REQUERIMIENTOS.md
    ├── ROADMAP-SEMANAL.md
    ├── pocketlog/
    ├── semana-XX/
    │   ├── README.md
    │   ├── 01-<implementacion>.md
    │   └── 02-<implementacion>.md
    └── historicos/
```

## Checklist de una semana reconciliada

- [ ] `semanas/semana-XX/README.md` indexa todas las materias.
- [ ] Cada materia principal tiene su propio Markdown.
- [ ] Las ampliaciones poseen carpeta e índice cuando son necesarias.
- [ ] Existe lab semanal o se documenta por qué no corresponde.
- [ ] El lab tiene checkpoints y dependencias declaradas.
- [ ] `examples/semana-XX/` contiene sólo ejemplos breves e independientes.
- [ ] `proyecto-formativo/semana-XX/` depende explícitamente de la semana anterior.
- [ ] Proyecto formativo con checklist de inicio y finalización.
- [ ] Incremento del proyecto formativo dividido en varios Markdown.
- [ ] `pocketlog/` queda ejecutable para continuar.
- [ ] Hito histórico reconstruible mediante Git.
- [ ] No existe una segunda fuente activa del mismo contenido.

## Deuda de migración existente

1. Migrar ejemplos de Semanas 01–03 desde `semanas/` hacia `examples/`.
2. Migrar `proyecto-formativo/guias/semana-01..03` hacia `proyecto-formativo/semana-01..03`.
3. Dividir labs 01–03 en archivos secuenciales con checkpoints.
4. Revisar `semanas/semana-01..03` y retirar material que pertenezca a otra vertical.
5. Validar enlaces internos y portal.

La migración debe preservar trazabilidad mediante Git; no se requieren copias activas duplicadas para conservar históricos.
