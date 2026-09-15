# PocketLog · Lineamientos de evolución futura

Este documento define cómo debe evolucionar PocketLog desde Semana 7 en adelante. Su propósito es evitar improvisación, adelanto de contenidos o pérdida de continuidad cuando se implemente una nueva semana del proyecto formativo.

## 1. Regla principal

PocketLog evoluciona a partir del **avance efectivamente enseñado en DSY1105-009V**, no solamente desde el cronograma institucional.

Antes de implementar una nueva semana se debe verificar:

1. qué conceptos fueron realmente trabajados en aula;
2. qué conceptos quedaron pendientes;
3. qué checkpoint de PocketLog está confirmado como alcanzado;
4. qué requerimientos funcionales ya existen;
5. qué deuda o limitación de la versión anterior justifica usar el contenido nuevo.

Nunca se debe introducir una tecnología sólo porque aparece en el cronograma si todavía no fue trabajada o comprendida por la sección.

---

## 2. Fuente de verdad para comenzar Semana X

Cuando se solicite «hacer Semana X de PocketLog», revisar en este orden:

1. `semanas/semana-XX/README.md` y, cuando exista, evidencia de avance real de esa semana;
2. `data/weekly/semana-XX.yml` para diferenciar planificado, cubierto y pendiente;
3. `proyecto-formativo/README.md`;
4. `proyecto-formativo/REQUERIMIENTOS.md`;
5. `proyecto-formativo/TRAZABILIDAD.md`;
6. checkpoint inmediatamente anterior en `proyecto-formativo/checkpoints/`;
7. guía de implementación de la semana anterior;
8. labs y ejemplos usados realmente en la asignatura.

Si existe contradicción entre cronograma y avance real, manda el avance real.

---

## 3. Contrato obligatorio de cada nueva semana

Toda Semana X nueva del proyecto formativo debe producir, como mínimo:

```text
proyecto-formativo/semana-XX/
├── README.md
├── 00-checklist-inicio.md
├── 01-...md
├── 02-...md
├── ...
└── 99-checklist-final.md

proyecto-formativo/checkpoints/semana-XX/
└── checkpoint ejecutable completo
```

La cantidad de archivos intermedios depende de la complejidad de la semana. No se debe condensar una evolución compleja en un único README monolítico.

### README semanal

Debe declarar:

- estado de entrada;
- conceptos realmente habilitados;
- conceptos todavía prohibidos;
- requerimientos funcionales afectados;
- arquitectura antes/después;
- secuencia de implementación;
- evidencia esperada;
- enlace al checkpoint completo.

### Paso a paso

Cada paso debe incluir:

1. propósito;
2. archivo(s) que se crean o modifican;
3. código concreto a escribir;
4. explicación del código;
5. cómo ejecutar/probar;
6. resultado esperado;
7. error frecuente o decisión pedagógica cuando corresponda.

No basta con indicar «crear un ViewModel» o «agregar navegación»: se debe enseñar cómo hacerlo usando el contenido disponible en la asignatura.

### Checkpoint

El checkpoint debe ser una **fotografía completa y ejecutable** del producto al terminar la semana.

No debe contener:

- pseudocódigo donde corresponde código real;
- archivos críticos omitidos;
- referencias a fragmentos externos necesarios para compilar;
- tecnologías de semanas posteriores;
- abstracciones que el estudiante aún no pueda explicar.

---

## 4. Regla de evolución funcional

Cada técnica nueva debe responder a una necesidad observable del PocketLog anterior.

Formato obligatorio de razonamiento:

```text
REQUERIMIENTO EXISTENTE
        ↓
LIMITACIÓN DE LA VERSIÓN ACTUAL
        ↓
CONCEPTO NUEVO ENSEÑADO
        ↓
REFACTOR O EXTENSIÓN MÍNIMA
        ↓
NUEVA EVIDENCIA FUNCIONAL
```

Ejemplos:

- varias pantallas necesarias → navegación cuando navegación haya sido enseñada;
- formulario con datos inválidos → validaciones cuando formularios hayan sido enseñados;
- pérdida de datos al cerrar la app → persistencia cuando persistencia haya sido enseñada;
- datos remotos necesarios → REST cuando consumo de servicios haya sido enseñado.

---

## 5. No reescribir innecesariamente

PocketLog es longitudinal.

La regla es **refactorizar y extender**, no volver a crear el producto desde cero cada semana.

Cuando una capa anterior siga siendo válida debe preservarse. Por ejemplo:

```text
Registro (dominio)
    ↓ se conserva
Repository en memoria
    ↓ puede ser reemplazado/adaptado cuando llegue persistencia
ViewModel
    ↓ evoluciona con estado y eventos
Compose UI
    ↓ se divide en pantallas cuando navegación sea necesaria
```

Cada semana debe indicar explícitamente qué se mantiene, qué se modifica, qué se elimina y por qué.

---

## 6. Política de requerimientos

Los requerimientos se gestionan en `REQUERIMIENTOS.md`.

Una semana puede:

- completar un RF parcialmente implementado;
- mejorar la implementación de un RF existente;
- habilitar un RF que hasta entonces era técnicamente imposible;
- incorporar un RF nuevo sólo si surge naturalmente del producto y no es una excusa para usar una tecnología.

Todo cambio debe reflejarse en `TRAZABILIDAD.md`.

No se debe inventar una funcionalidad sin registrar qué necesidad del usuario resuelve.

---

## 7. Política de arquitectura

La arquitectura debe crecer proporcionalmente al contenido enseñado.

Evitar antes de tiempo:

- Clean Architecture completa;
- múltiples módulos Gradle;
- DI frameworks;
- abstracciones Repository/UseCase innecesarias;
- Flow/StateFlow si el curso todavía no los ha introducido y un estado simple es suficiente;
- Room antes de persistencia;
- Retrofit/Ktor antes de REST;
- Navigation Compose antes de navegación;
- testing sofisticado antes de la unidad de pruebas.

La arquitectura debe ser profesional, pero **didácticamente defendible por un estudiante de esa semana**.

---

# 8. Hoja de ruta orientativa desde Semana 7

Esta hoja de ruta es una **dirección**, no autorización automática para implementar contenido. Cada semana se reconcilia primero con el avance real.

## Semana 7 · Diseño visual, adaptabilidad y navegación

Estado de entrada esperado:

- Android ejecutable;
- Compose básico;
- `PocketLogViewModel`;
- `UiState`;
- repository en memoria;
- una pantalla funcional.

Evolución probable:

- mejorar jerarquía visual;
- extraer composables reutilizables;
- Material 3 de forma consciente;
- layouts adaptables básicos;
- introducir varias pantallas sólo cuando navegación haya sido enseñada;
- separar listado / creación / detalle si el avance real lo habilita.

Checkpoint esperado:

```text
PocketLog v0.7
Compose estructurado + diseño consistente + navegación enseñada
```

No incorporar todavía persistencia ni backend.

## Semana 8 · Formularios, validaciones e interacción entre pantallas

Evolución probable:

- formulario formal para crear/editar registro;
- campos controlados;
- mensajes de validación;
- habilitación/deshabilitación de acciones;
- paso de identificadores/datos entre pantallas;
- edición si los contenidos y tiempo real lo permiten.

Requerimientos candidatos:

- registrar mediante formulario completo;
- editar registro;
- visualizar detalle;
- validar título/categoría antes de guardar.

Checkpoint esperado:

```text
PocketLog v0.8
flujo CRUD parcial en memoria + formularios + validación
```

## Semana 9 · Estado, animaciones y recursos nativos

Sólo después de confirmar qué se enseñó realmente.

Evolución candidata:

- mejorar gestión del estado de pantalla;
- estados de vacío/error/carga si existe una necesidad real;
- animaciones pequeñas con propósito UX;
- cámara/recurso nativo sólo si el contenido realmente fue trabajado y existe un requerimiento justificable.

Ejemplo de RF futuro posible:

- adjuntar una fotografía opcional a un registro.

No debe implementarse cámara sólo para demostrar la API.

## Semana 10 · Persistencia local

Problema que debe hacerse visible antes de implementarla:

> Los registros desaparecen al cerrar la aplicación.

Evolución esperada:

```text
Repository en memoria
        ↓
contrato estable
        ↓
implementación persistente enseñada en clase
```

Según el contenido real, usar la tecnología efectivamente enseñada (por ejemplo SQLite/Room sólo si corresponde).

Debe preservarse el comportamiento funcional logrado previamente.

Checkpoint esperado:

```text
PocketLog v0.10
CRUD local persistente
```

## Semanas 11–12 · EP2

PocketLog queda congelado salvo recuperación pedagógica explícita.

No convertirlo en pauta indirecta de la evaluación.

## Semana 13 · Consumo REST

Antes de incorporar red debe existir una pregunta funcional real, por ejemplo:

- sincronizar catálogo de categorías;
- obtener datos externos complementarios;
- sincronizar registros si el dominio se amplía explícitamente.

Evolución esperada:

- cliente HTTP según lo enseñado;
- DTO sólo cuando sea necesario;
- manejo básico de éxito/error;
- separación entre datos remotos y UI;
- indicador de carga si corresponde.

No reemplazar innecesariamente toda la persistencia local por red.

## Semana 14 · Pruebas y calidad

La aplicación existente se convierte en objeto de prueba; no se inventa una aplicación paralela.

Priorizar:

- lógica de dominio;
- validaciones;
- ViewModel cuando sea testeable con las herramientas enseñadas;
- casos felices y casos límite;
- defectos reales encontrados durante la evolución.

Checkpoint debe incluir código + pruebas reproducibles.

## Semana 15 · Compilación segura y firma

PocketLog debe llegar a un estado distribuible.

Evolución esperada:

- limpieza de configuración de build;
- versionado;
- generación de APK/AAB según contenido;
- firma según práctica institucional;
- documentación reproducible del proceso.

No introducir funcionalidades nuevas importantes durante esta semana salvo correcciones necesarias.

## Semanas 16–17 · EP3

Proyecto congelado como soporte de aprendizaje, no como pauta.

## Semana 18 · Cierre longitudinal

PocketLog debe funcionar como evidencia de evolución del aprendizaje.

El cierre debería permitir comparar:

```text
Semana 1
variables + funciones
      ↓
Semana 3
colecciones + objetos
      ↓
Semana 4
aplicación consola completa
      ↓
Semana 6
Android + Compose
      ↓
semanas posteriores
navegación + formularios + persistencia + REST + pruebas
```

Debe existir una retrospectiva técnica que explique qué cambió y por qué.

---

## 9. Definition of Ready para implementar Semana X

Antes de comenzar una semana, deben poder responderse estas preguntas:

- [ ] ¿Cuál fue el último checkpoint confirmado?
- [ ] ¿Qué se enseñó realmente desde ese checkpoint?
- [ ] ¿Qué quedó pendiente?
- [ ] ¿Qué RF se trabajará?
- [ ] ¿Qué limitación actual justifica el cambio?
- [ ] ¿Qué técnicas están permitidas?
- [ ] ¿Qué técnicas posteriores están explícitamente prohibidas?
- [ ] ¿Cuál será el resultado ejecutable esperado?

Si no se puede responder alguna, primero se reconcilia la evidencia de aula.

---

## 10. Definition of Done para Semana X

Una semana está terminada sólo si:

- [ ] existe guía paso a paso;
- [ ] cada concepto aplicado fue enseñado;
- [ ] los RF afectados están identificados;
- [ ] `TRAZABILIDAD.md` está actualizado;
- [ ] existe checkpoint completo;
- [ ] el checkpoint compila/ejecuta o se ha verificado hasta el límite técnico disponible;
- [ ] se indican pruebas manuales o automatizadas reproducibles;
- [ ] se documentan decisiones y deuda pendiente;
- [ ] se define el estado exacto de entrada de la semana siguiente;
- [ ] no se adelantaron tecnologías posteriores.

---

## 11. Instrucción operativa para futuros trabajos

Cuando el docente solicite simplemente:

> «Haz PocketLog Semana X»

la ejecución debe interpretar automáticamente:

1. reconciliar avance real de DSY1105 hasta Semana X;
2. recuperar el checkpoint X-1;
3. identificar los conceptos nuevos realmente enseñados;
4. seleccionar los RF que naturalmente evolucionan;
5. actualizar requerimientos/trazabilidad si es necesario;
6. crear la guía detallada de Semana X;
7. implementar el proyecto completo del nuevo checkpoint;
8. verificarlo;
9. actualizar índices y enlaces relacionados;
10. cerrar el trabajo en Git sin dejar ramas o PR abandonados.

Este documento debe conservarse como contrato de continuidad del proyecto formativo durante el resto del semestre.
