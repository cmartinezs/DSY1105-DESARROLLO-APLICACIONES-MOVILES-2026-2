# Reconciliación de verticales · DSY1105 · 2026-08-28

## Objetivo

Conciliar la estructura real del repositorio con el canon docente vigente, manteniendo cuatro verticales independientes:

1. `semanas/`
2. `labs/`
3. `examples/`
4. `proyecto-formativo/`

## Estado observado

### `semanas/`

Existe estructura semanal hasta Semana 03 y cada semana posee `README.md`.

Deuda observada:

- todavía existen ejemplos ejecutables dentro de carpetas semanales;
- existen materiales que por su naturaleza pueden corresponder a labs o ejemplos;
- se debe evitar seguir agregando contenido no curricular directo dentro de `semanas/`.

### `labs/`

Existe un lab por semana hasta Semana 03.

Deuda observada:

- varios labs concentran demasiada guía en `README.md`;
- deben separarse progresivamente en varios Markdown secuenciales alineados a materias/etapas;
- cada paso debe incorporar checkpoint explícito;
- cada lab debe declarar dependencia de labs anteriores incluso cuando sea `ninguna`.

### `examples/`

La carpeta existía como índice, pero el contenido real estaba alojado principalmente dentro de `semanas/`.

Corrección aplicada al contrato:

- `examples/` pasa a ser la fuente canónica de ejemplos;
- los ejemplos nuevos deben vivir bajo `examples/semana-XX/`;
- el contenido histórico mezclado dentro de `semanas/` queda marcado como legacy a migrar.

### `proyecto-formativo/`

PocketLog ya está definido como una única base de código viva y utiliza históricos Git.

Deuda observada:

- el `README.md` declaraba `proyecto-formativo/semana-XX/`, pero las guías reales estaban bajo `proyecto-formativo/guias/semana-XX/`;
- las guías existentes son todavía demasiado monolíticas para el contrato final;
- deben migrarse a carpetas `proyecto-formativo/semana-XX/` con varios `.md`, checklist inicial, checkpoints y checklist final.

## Contrato reconciliado

```text
/
├── semanas/
│   ├── README.md
│   └── semana-XX/
│       ├── README.md
│       ├── 01-materia.md
│       ├── 02-materia.md
│       └── ampliacion-<tema>/
│           └── README.md
├── labs/
│   ├── README.md
│   └── semana-XX-<nombre>/
│       ├── README.md
│       ├── 01-<etapa>.md
│       ├── 02-<etapa>.md
│       └── ...
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
    │   ├── 02-<implementacion>.md
    │   └── ...
    └── historicos/
```

## Reglas de creación de nuevas semanas

Antes de considerar una semana reconciliada:

- [ ] `semanas/semana-XX/README.md` indexa todas las materias;
- [ ] cada materia principal tiene su propio Markdown;
- [ ] ampliaciones poseen carpeta e índice cuando sean necesarias;
- [ ] existe lab semanal o se documenta explícitamente por qué no corresponde;
- [ ] el lab tiene checkpoints y dependencias declaradas;
- [ ] `examples/semana-XX/` contiene sólo ejemplos breves e independientes;
- [ ] `proyecto-formativo/semana-XX/` depende explícitamente de la semana anterior;
- [ ] el proyecto formativo tiene checklist de inicio y finalización;
- [ ] el incremento del proyecto formativo está dividido en varios Markdown;
- [ ] `pocketlog/` queda en estado ejecutable para la semana siguiente;
- [ ] el hito histórico es reconstruible mediante Git;
- [ ] no existe una segunda fuente activa del mismo contenido en otra vertical.

## Migración de deuda existente

Prioridad recomendada:

1. migrar ejemplos de Semanas 01–03 desde `semanas/` hacia `examples/`;
2. migrar `proyecto-formativo/guias/semana-01..03` hacia `proyecto-formativo/semana-01..03`;
3. dividir labs 01–03 en archivos secuenciales con checkpoints;
4. revisar `semanas/semana-01..03` y retirar material que pertenezca a otra vertical;
5. validar enlaces internos y actualizar portal/documentación auxiliar.

La migración debe preservar trazabilidad mediante Git; no se requiere mantener copias activas duplicadas para conservar históricos.
