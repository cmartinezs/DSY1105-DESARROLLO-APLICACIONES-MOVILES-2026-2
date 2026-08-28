# Ejemplos · DSY1105 Desarrollo de Aplicaciones Móviles

`examples/` es una vertical independiente y la fuente canónica de los ejemplos breves de la asignatura.

## Propósito

Un ejemplo demuestra **un concepto o técnica puntual** con el mínimo código y documentación necesarios para entenderlo y ejecutarlo.

No es un laboratorio, no es una guía semanal y no es una etapa de PocketLog.

## Organización canónica

```text
examples/
├── README.md
├── semana-01/
│   ├── README.md
│   └── <ejemplo-concreto>/
├── semana-02/
└── semana-XX/
```

Cada `semana-XX/README.md` actúa como índice de los ejemplos de esa semana. Cada ejemplo debe ser independiente de los demás y tener un objetivo demostrativo único.

## Reglas

- ejemplos agrupados por semana;
- pequeños, concretos y ejecutables;
- un objetivo demostrativo por ejemplo;
- sin depender del proyecto formativo;
- sin convertirse en un lab guiado extenso;
- cuando necesite código, incluir sólo el scaffolding mínimo;
- la explicación debe indicar qué observar al ejecutar el ejemplo.

## Estado de conciliación

El contenido histórico que hoy siga dentro de `semanas/semana-XX/ejemplos*` se considera **legacy a migrar**. La nueva fuente activa de ejemplos debe vivir aquí. No se debe crear nuevo contenido de ejemplos dentro de `semanas/`.

## Semanas

- Semana 01 — migración/reconciliación de ejemplos Java ↔ Kotlin.
- Semana 02 — migración/reconciliación de ejemplos de fundamentos Kotlin.
- Semana 03 — ejemplos de colecciones, POO, errores y sintaxis Kotlin.

Las carpetas semanales se crean progresivamente, sólo cuando exista contenido real para esa semana.
