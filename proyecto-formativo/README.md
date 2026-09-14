# PocketLog · Proyecto formativo longitudinal DSY1105

PocketLog es el proyecto transversal de **DSY1105 Desarrollo de Aplicaciones Móviles**. Su propósito no es anticipar contenido ni servir como pauta de evaluaciones: sirve para que el estudiante vea cómo un mismo producto evoluciona cuando aprende nuevas herramientas.

## Principio rector

> El producto crece con el conocimiento realmente trabajado en la sección.

Por eso cada semana conserva dos cosas:
1. los mismos requerimientos funcionales, que se van habilitando gradualmente;
2. una implementación compatible con lo que ya fue enseñado.

No se usa una técnica sólo porque hoy sepamos que es mejor. Si una técnica todavía no ha sido enseñada, no pertenece al checkpoint histórico de esa semana.

## Estado conciliado hasta Semana 6

| Semana | Estado pedagógico real | PocketLog |
|---|---|---|
| 01 | Java → Kotlin; variables, tipos, `val`/`var`, String templates, `if/else`, funciones, null safety inicial | `v0.1` · un registro, datos sueltos y funciones |
| 02 | fundamentos Kotlin; condicionales, ciclos, funciones; colecciones quedan para la siguiente clase | `v0.2` · interacción por consola, validaciones y flujo; aún sin colecciones |
| 03 | cierre de colecciones y transición a POO/control de errores | `v0.3` · `MutableList<Registro>`, clase, búsqueda, filtro, conteo y errores |
| 04 | consolidación Kotlin consola previa a EP1; Android sólo introducción controlada | `v0.4` · aplicación de consola completa y defendible |
| 05 | EP1 | pausa explícita; no se entrega nuevo código |
| 06 | transición a Android, Compose y separación inicial de responsabilidades | `v0.6` · app Android con Compose + ViewModel + dominio preservado |

## Estructura

```text
proyecto-formativo/
├── README.md
├── REQUERIMIENTOS.md
├── ROADMAP-SEMANAL.md
├── TRAZABILIDAD.md
├── pocketlog/                 # referencia del estado vigente
├── semana-01/ ... semana-06/  # guías de implementación
└── checkpoints/
    ├── semana-01/
    ├── semana-02/
    ├── semana-03/
    ├── semana-04/
    ├── semana-05/
    └── semana-06/
```

## Cómo debe trabajar un estudiante

Cada semana:
1. lee el `README.md` semanal;
2. revisa qué conceptos están permitidos y cuáles todavía no;
3. parte desde el checkpoint anterior;
4. implementa los cambios en el orden indicado;
5. ejecuta y prueba después de cada paso;
6. compara su resultado con el checkpoint completo sólo al final;
7. actualiza su DevLog.

## Reglas de continuidad

- No se reinicia PocketLog desde cero.
- No se copia el checkpoint final antes de realizar los pasos.
- Cada cambio debe poder explicarse con contenido ya trabajado.
- Semana 5 queda congelada por evaluación.
- Semana 6 no reescribe el dominio: lo reutiliza dentro de Android.
- Navegación, persistencia, REST, cámara y otras tecnologías posteriores **no aparecen aún**.

## Enlaces

- [Requerimientos funcionales](./REQUERIMIENTOS.md)
- [Roadmap real hasta Semana 6](./ROADMAP-SEMANAL.md)
- [Matriz de trazabilidad](./TRAZABILIDAD.md)
- [Checkpoints completos](./checkpoints/)
