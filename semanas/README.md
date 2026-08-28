# Semanas · DSY1105 Desarrollo de Aplicaciones Móviles

`semanas/` contiene exclusivamente el contenido curricular que debe enseñarse semana a semana.

Es una vertical independiente de `labs/`, `examples/` y `proyecto-formativo/`.

## Contrato de organización

Cada semana se crea progresivamente mediante una carpeta `semana-XX/` con un `README.md` como índice y resumen.

Cada `semanas/semana-XX/README.md` debe incluir:

- descripción breve de la semana;
- materias que deben enseñarse;
- resumen de cada materia;
- índice a cada `.md` de contenido;
- orden sugerido de estudio/enseñanza;
- enlaces hacia ampliaciones cuando corresponda;
- enlaces cruzados hacia labs, ejemplos y proyecto formativo, **sin duplicar su contenido**.

## Ampliaciones

Cuando una materia requiera conocimientos adicionales más allá del mínimo curricular, debe usar una subcarpeta propia dentro de la semana:

```text
semanas/semana-XX/
├── README.md
├── 01-materia.md
├── 02-materia.md
└── ampliacion-<tema>/
    ├── README.md
    ├── 01-<subtema>.md
    └── ...
```

La ampliación también debe tener `README.md` índice.

## Regla de separación

`semanas/` responde **qué se enseña**.

No debe contener nuevas copias activas de:

- ejemplos ejecutables: pertenecen a `examples/`;
- laboratorios guiados: pertenecen a `labs/`;
- implementación incremental de PocketLog: pertenece a `proyecto-formativo/`.

El contenido histórico que todavía esté mezclado dentro de semanas se considera deuda de conciliación y debe migrarse gradualmente a su vertical canónica.

## Índice actual

| Semana | Periodo | Contenido principal | Material |
|---|---|---|---|
| **01** | 10–15 agosto 2026 | Panorama del desarrollo de aplicaciones y transición Java → Kotlin | [Abrir Semana 01](semana-01/) |
| **02** | 17–22 agosto 2026 | Programación Kotlin y fundamentos | [Abrir Semana 02](semana-02/) |
| **03** | 24–29 agosto 2026 | Colecciones, POO, errores y puente a corrutinas | [Abrir Semana 03](semana-03/) |

Las semanas 04–18 se crean a medida que avance el semestre; no se generan carpetas vacías anticipadamente.
