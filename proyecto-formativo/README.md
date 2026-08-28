# PocketLog · Proyecto formativo transversal

PocketLog es el proyecto formativo longitudinal de **DSY1105 Desarrollo de Aplicaciones Móviles**.

Comienza en **Semana 01** como una aplicación Kotlin de consola con datos y funciones sueltas, y evoluciona sobre la misma base de código durante el semestre.

## Modelo de trabajo

PocketLog utiliza una única base de código viva. Las carpetas semanales documentan cómo incrementarla; no contienen copias completas del proyecto.

```text
proyecto-formativo/
├── README.md
├── REQUERIMIENTOS.md
├── ROADMAP-SEMANAL.md
├── pocketlog/          # código vivo
├── semana-01/          # guía incremental
├── semana-02/
├── semana-03/
└── historicos/         # índice de hitos Git
```

## Evolución

Los requerimientos funcionales se conocen desde el inicio; la implementación cambia con el contenido curricular.

```text
Semana 01 -> datos sueltos + funciones top-level
Semana 02 -> colecciones + funciones
Semana 03 -> objetos + POO + errores
Semana 04 -> consolidación Kotlin consola pre-EV1
```

- [Requerimientos funcionales](./REQUERIMIENTOS.md)
- [Roadmap semanal](./ROADMAP-SEMANAL.md)

## Regla de continuidad

Cada semana recibe el proyecto vivo dejado por la anterior.

Antes de comenzar debe existir un **checklist de inicio**. Durante la guía se incorporan los contenidos de la semana de manera secuencial y verificable. Al terminar debe existir un **checklist de finalización** que confirme que el estado es apto para continuar.

No se reinicia PocketLog por semana.

## Históricos

Los estados anteriores se conservan mediante Git, no duplicando el proyecto.

`historicos/` mantiene el índice de hitos y referencias de commit/tag necesarias para reconstruir versiones anteriores.

```text
código vivo actual -> pocketlog/
implementación semanal -> semana-XX/
estado histórico -> Git + historicos/
```

PocketLog no replica el caso de negocio de EV1, pero ejercita progresivamente las capacidades técnicas esperadas para Kotlin de consola y POO.

Para decisiones docentes y trazabilidad curricular, ver [Proyecto formativo transversal · PocketLog](../docs/PROYECTO-FORMATIVO-TRANSVERSAL.md).
