# Reconciliación de verticales · DSY1105 · 2026-08-28

Se completó la migración física de las Semanas 01–03 hacia el contrato de cuatro verticales independientes.

## Resultado

### Semanas
`semanas/` conserva contenido curricular y enlaces hacia las otras verticales. Los ejemplos ejecutables que estaban mezclados en Semanas 01–02 fueron retirados de esta vertical.

### Labs
Los labs de Semanas 01–03 mantienen su código/scaffolding y ahora distribuyen la guía en varios Markdown secuenciales, con checkpoints y dependencia explícita de laboratorios anteriores.

### Examples
Los ejemplos de Semanas 01–02 fueron migrados físicamente a `examples/semana-01` y `examples/semana-02`. Semana 03 incorpora ejemplos breves propios bajo `examples/semana-03`.

### Proyecto formativo
`proyecto-formativo/guias/semana-01..03` fue migrado a `proyecto-formativo/semana-01..03`. La carpeta `guias/` dejó de ser una ubicación activa. Semana 01 y Semana 03 fueron completadas con documentación secuencial, checkpoints y checklists; Semana 02 conservó su estructura ya segmentada.

## Contrato vigente

```text
semanas/semana-XX/               # qué se enseña
labs/semana-XX-<nombre>/          # laboratorio guiado semanal
examples/semana-XX/               # ejemplos pequeños e independientes
proyecto-formativo/semana-XX/     # incremento longitudinal de PocketLog
proyecto-formativo/pocketlog/      # única base de código viva
```

## Validación aplicada

- [x] ejemplos de Semana 01 fuera de `semanas/`;
- [x] ejemplos de Semana 02 fuera de `semanas/`;
- [x] ejemplos de Semana 03 presentes en `examples/`;
- [x] proyecto formativo Semanas 01–03 en ruta canónica;
- [x] `proyecto-formativo/guias/` sin contenido activo;
- [x] labs Semanas 01–03 divididos en etapas;
- [x] dependencias de labs declaradas;
- [x] checkpoints explícitos en cada etapa;
- [x] enlaces semanales actualizados hacia fuentes canónicas;
- [x] índices raíz de las cuatro verticales reconciliados.

## Regla para Semana 04 en adelante

No crear contenido nuevo fuera de su vertical canónica. Antes de cerrar una semana, verificar índice semanal, lab, ejemplos, incremento de PocketLog, checkpoints y enlaces cruzados sin duplicación activa.
