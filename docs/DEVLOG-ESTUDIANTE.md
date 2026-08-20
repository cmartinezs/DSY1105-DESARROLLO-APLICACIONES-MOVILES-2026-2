# DevLog del estudiante · manual de uso

El **DevLog** es una bitácora técnica breve que vive en el repositorio personal del estudiante y registra cómo avanza su trabajo durante el semestre.

No es un diario personal, no mide horas y no busca que escribas páginas. Su objetivo es dejar una traza útil de tu proceso: qué querías lograr, qué hiciste, dónde te bloqueaste, qué aprendiste y qué harás después.

## Dónde vive

```text
docs/
└── devlog/
    ├── README.md
    ├── semana-02.md
    ├── semana-03.md
    └── ...
```

El repositorio del curso contiene **este manual y ejemplos**. Tu DevLog real se mantiene en tu repositorio personal.

## Formato mínimo

```markdown
# DevLog · Semana XX

## Objetivo
¿Qué quería avanzar esta semana?

## Avance
¿Qué hice realmente?

## Bloqueo
¿Qué me costó, falló o quedó sin resolver?

## Aprendizaje
¿Qué entendí, corregí o descubrí?

## Siguiente
¿Cuál es el próximo paso concreto?
```

Cinco secciones son suficientes. Se valora precisión, no extensión.

## Ejemplo útil

```markdown
# DevLog · Semana 03

## Objetivo
Refactorizar PocketLog usando las herramientas Kotlin trabajadas esta semana.

## Avance
- reemplacé una estructura frágil por un modelo más claro;
- mantuve la aplicación funcionando;
- actualicé el README.

## Bloqueo
Al principio confundí una solución corta con una solución más legible.

## Aprendizaje
Entendí que usar sintaxis idiomática tiene sentido cuando ya comprendo el mecanismo que reemplaza.

## Siguiente
Aplicar el mismo criterio a otra operación de PocketLog.
```

## No registrar horas

No se pide `trabajé 2 horas`. Es mejor registrar evidencia observable:

```text
mal: trabajé 90 minutos
bien: resolví el filtro primero con un ciclo y luego pude explicar qué reemplaza `filter`
```

## Si no hubo avance

También es válido registrarlo. No inventes actividad para llenar el archivo.

```markdown
## Avance
No alcancé a modificar PocketLog esta semana.

## Bloqueo
Todavía no comprendo bien null safety y preferí no copiar una solución.

## Siguiente
Revisar un ejemplo pequeño y llevar una pregunta concreta a clase.
```

## Relación con Git y GitHub

```text
Issue      → qué quiero hacer
Commits    → qué cambié
DevLog     → qué ocurrió y qué aprendí
README     → cómo funciona el resultado actual
```

El DevLog puede actualizarse como parte del commit de cierre de una sesión o semana. No debe duplicar innecesariamente Issues o README.

## Cómo se utilizará

El docente puede revisar DevLogs públicos para detectar bloqueos repetidos, preguntas útiles, continuidad, decisiones técnicas y necesidades de refuerzo para la clase siguiente.

El objetivo es **feedback y evidencia formativa**, no vigilar horas ni premiar quién escribe más.

## Reglas

- breve y específico;
- escrito con tus propias palabras;
- coherente con el trabajo real del repo;
- puede declarar que algo no se logró;
- no inventar dificultades ni aprendizajes;
- no incluir secretos ni datos personales innecesarios;
- no convertirlo en una transcripción de la clase.

## Checklist semanal

- [ ] existe `docs/devlog/semana-XX.md`;
- [ ] tiene objetivo, avance, bloqueo, aprendizaje y siguiente;
- [ ] describe resultados reales;
- [ ] deja una pregunta pendiente si existe;
- [ ] es coherente con commits/código/documentación;
- [ ] está enviado a GitHub.
