# Canon transversal de repositorios docentes · 2026-2

Este documento define la estructura y reglas comunes de los repositorios docentes activos del semestre.

## 1. Principios

1. Una fuente canónica por artefacto.
2. `semanas/`, `labs/`, `examples/` y `proyecto-formativo/` son verticales independientes.
3. Todo recurso navegable tiene `README.md` como índice y punto de entrada.
4. Evitar mega-documentos: dividir contenido por materia, etapa o propósito.
5. El contenido se crea progresivamente hasta Semana 18.
6. El estado semanal procesable vive en `data/weekly/`.

## 2. Estructura base

```text
/
├── README.md
├── docs/
├── data/weekly/
├── semanas/
│   ├── README.md
│   └── semana-XX/
├── labs/
│   ├── README.md
│   └── semana-XX/
├── examples/
│   ├── README.md
│   └── semana-XX/
├── proyecto-formativo/
│   ├── README.md
│   ├── REQUERIMIENTOS.md
│   ├── ROADMAP-SEMANAL.md
│   ├── app/ o <proyecto-vivo>/
│   ├── semana-XX/
│   └── historicos/
└── page/
```

## 3. `semanas/`

Cada semana tiene una carpeta `semana-XX/` con un `README.md` que actúa como índice y resumen de la semana.

Debe incluir:
- descripción breve de la semana;
- materias que deben enseñarse;
- índice a los `.md` de cada materia;
- resumen general de cada contenido;
- enlaces a ampliaciones cuando corresponda.

Las materias que requieran profundización adicional pueden tener una subcarpeta propia, también con `README.md` índice.

`semanas/` explica **qué se enseña**. No contiene copias de labs, ejemplos o proyecto formativo.

## 4. `labs/`

Debe existir, normalmente, un laboratorio por semana.

Cada lab:
- aplica principalmente lo aprendido esa semana;
- es guiado paso a paso, sin omitir pasos por parecer obvios;
- incluye checkpoints explícitos de verificación;
- declara prerrequisitos de semanas previas;
- declara explícitamente si depende de un lab anterior;
- intenta ser independiente de otros labs;
- usa un caso de aplicación lo más agnóstico posible respecto del proyecto formativo;
- prioriza ejecución local y reproducible;
- puede incluir scaffolding, Docker y servicios externos gratuitos cuando sean pertinentes al contenido.

Cada `labs/semana-XX/` tiene `README.md` con objetivos, resultados esperados, contenidos relacionados de la semana y conocimientos previos requeridos.

El lab no debe ser un único Markdown excesivamente largo. Se divide en varios `.md`, preferentemente alineados con las materias enseñadas y en secuencia pedagógica.

## 5. `examples/`

Los ejemplos son ejecuciones individuales, pequeñas e independientes de una materia o concepto.

Reglas:
- lo más cortos y concretos posible;
- un objetivo demostrativo por ejemplo;
- agrupados por semana;
- `examples/README.md` como índice general;
- `examples/semana-XX/README.md` como índice semanal.

No sustituyen labs ni proyecto formativo.

## 6. `proyecto-formativo/`

El proyecto formativo es longitudinal e incremental.

### Modelo canónico

Se utiliza **una única base de código viva**:

```text
proyecto-formativo/
├── README.md
├── REQUERIMIENTOS.md
├── ROADMAP-SEMANAL.md
├── <proyecto-vivo>/
├── semana-01/
├── semana-02/
├── ...
└── historicos/
```

Las carpetas `semana-XX/` contienen documentación y guía incremental, no una copia completa del proyecto.

Cada semana del proyecto formativo:
- depende de que la semana anterior haya sido realizada;
- tiene checklist de inicio;
- explica el contenido curricular aplicado;
- implementa secuencialmente el incremento correspondiente;
- tiene varios `.md`, no un único archivo extenso;
- tiene checkpoints de verificación durante la implementación;
- tiene checklist de finalización;
- deja el proyecto vivo listo para continuar la semana siguiente.

El proyecto formativo aplica explícitamente las tecnologías, servicios y plataformas indicados por la asignatura.

### Históricos

Los históricos no duplican el proyecto completo por semana.

El estado histórico se conserva mediante Git:
- commit o tag identificable por hito;
- índice en `proyecto-formativo/historicos/`;
- registro del estado alcanzado, versión, semana y referencia Git.

Así se puede reconstruir un estado anterior sin mantener 18 copias físicas del mismo código.

Regla:

```text
una base de código viva
+ documentación incremental por semana
+ historial reproducible mediante Git
```

## 7. `data/weekly/`

Contiene el estado agregado y procesable de cada semana.

Reglas:
- un `semana-XX.yml` por semana curricular;
- plan y avance real separados;
- valores desconocidos como `null`;
- sin datos personales;
- sirve para estadísticas, dashboard y reconciliación operacional.

## 8. No duplicación

Antes de crear un archivo nuevo:

> ¿Es una nueva fuente o sólo otra forma de acceder a una fuente existente?

Si es acceso, enlazar. Si es fuente, definir un único hogar canónico.

## 9. Reconciliación semanal

Antes de abrir una nueva semana:

- [ ] `semanas/semana-XX/` existe y está indexado;
- [ ] materias y ampliaciones están documentadas;
- [ ] `labs/semana-XX/` está disponible cuando corresponde;
- [ ] `examples/semana-XX/` está reconciliado;
- [ ] `proyecto-formativo/semana-XX/` contiene guía incremental y checklists;
- [ ] proyecto vivo actualizado cuando corresponde;
- [ ] histórico Git del hito identificable;
- [ ] `data/weekly/semana-XX.yml` reconciliado;
- [ ] enlaces internos válidos;
- [ ] portal web actualizado.

## 10. Extensiones por asignatura

- DSY1102: práctica, laboratorios, PetCare y desafíos progresivos.
- DSY1105: Kotlin/Android, PocketLog y evolución consola → app móvil → persistencia/REST.
- DSY1107: ReservApp y progresión concepto → laboratorio local/neutral → laboratorio cloud real.
