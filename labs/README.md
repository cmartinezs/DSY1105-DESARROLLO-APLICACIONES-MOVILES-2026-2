# Laboratorios · DSY1105 Desarrollo de Aplicaciones Móviles

`labs/` es una vertical independiente y la fuente canónica de los laboratorios guiados de la asignatura.

## Regla general

Normalmente existe un laboratorio por semana y aplica principalmente lo aprendido en esa semana.

Cada laboratorio debe:
- ser ejecutable paso a paso, sin omitir acciones por parecer obvias;
- declarar objetivos y resultados esperados;
- listar contenidos relacionados de la semana;
- declarar conocimientos requeridos de semanas anteriores;
- indicar explícitamente si depende de un laboratorio previo;
- ser independiente de otros labs siempre que la naturaleza del contenido lo permita;
- incluir checkpoints de verificación durante la ejecución;
- priorizar ejecución local y reproducible;
- usar scaffolding, Docker o servicios externos gratuitos sólo cuando ayuden a enseñar el contenido;
- aplicar los conceptos de forma agnóstica respecto de PocketLog y del proyecto formativo.

## Organización canónica

```text
labs/
├── README.md
├── semana-01-<nombre>/
│   ├── README.md
│   ├── 01-<materia-o-etapa>.md
│   ├── 02-<materia-o-etapa>.md
│   └── ...
└── semana-XX-<nombre>/
```

El `README.md` de cada lab actúa como portada e índice y debe contener propósito, objetivos, resultado esperado, contenidos aplicados, conocimientos previos, dependencia explícita de labs anteriores, requisitos técnicos, secuencia documental y criterio de finalización.

Los pasos de implementación deben repartirse en varios Markdown cuando el lab cubra más de una materia o etapa. Un único `README.md` largo no es el formato objetivo.

## Laboratorios disponibles

- Semana 01 · [Control de batería Java → Kotlin](./semana-01-java-kotlin/)
- Semana 02 · [Analizador de temperaturas](./semana-02-analizador-temperaturas/)
- Semana 03 · [De datos sueltos a objetos](./semana-03-de-datos-a-objetos/)

`semanas/` puede enlazar estos laboratorios, pero nunca debe contener una segunda copia activa del lab.
