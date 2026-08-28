# PocketLog · Roadmap semanal 2026-2

PocketLog es el proyecto longitudinal de DSY1105. **Nace en Semana 01 como aplicación Kotlin de consola** y evoluciona sobre el mismo problema de negocio durante todo el semestre.

## Regla principal

Los **requerimientos funcionales se conocen desde el inicio**, especialmente los necesarios para practicar las capacidades de la Unidad 1 / EV1. Lo que cambia semana a semana es la técnica permitida para implementarlos.

Ver: [REQUERIMIENTOS.md](./REQUERIMIENTOS.md).

```text
mismo requerimiento
      ↓
implementación inicial simple
      ↓
nuevo contenido curricular
      ↓
problema/deuda visible
      ↓
refactor del mismo producto
```

El cronograma institucional y el avance real de la sección siguen mandando. No se adelantan técnicas ni tecnologías sólo porque serían arquitectónicamente convenientes.

---

# Unidad 1 · Kotlin de consola

## Semana 01 · PocketLog v0.1 · datos y funciones sueltas

### Contenido disponible

- panorama del desarrollo móvil;
- puente inicial Java/Kotlin;
- variables y tipos al nivel introductorio trabajado;
- funciones simples y salida por consola cuando corresponda.

### PocketLog

PocketLog **ya existe y ejecuta**.

Representa un registro mediante datos independientes:

```text
idRegistro
tituloRegistro
categoriaRegistro
registroCompletado
```

y operaciones independientes mediante funciones top-level:

```text
mostrarRegistro(...)
cambiarEstado(...)
coincideCategoria(...)
```

### Intención pedagógica

La solución es deliberadamente rudimentaria. El estudiante reconoce desde el primer momento que esos datos representan una sola entidad conceptual, aunque todavía no dispone de POO para expresarla.

### Requerimientos ya conocidos

Desde esta semana se conocen, al menos:

- registrar;
- listar/mostrar;
- cambiar estado;
- buscar;
- filtrar;
- contar;
- validar/manejar errores.

No todos se implementan todavía.

### No adelantar

- clases/data classes;
- herencia/polimorfismo;
- corrutinas;
- Android/Compose;
- persistencia;
- REST.

---

## Semana 02 · PocketLog v0.2 · varios registros y colecciones

### Contenido disponible

- fundamentos Kotlin;
- operadores y control de flujo;
- funciones;
- ciclos;
- `List` / `MutableList`;
- `filter`, `map`, `count` cuando hayan sido trabajados.

### Problema de entrada

Un solo registro ya no alcanza. Repetir variables para cada registro no escala.

### Evolución

Los mismos requerimientos se implementan ahora con varios registros. Puede utilizarse deliberadamente una representación incómoda mediante listas paralelas:

```text
titulos
categorias
completados
```

Esto permite listar, filtrar, contar y transformar sin adelantar POO.

### Deuda que queda abierta

Un mismo registro sigue repartido en varias estructuras sincronizadas por índice.

---

## Semana 03 · PocketLog v0.3 · POO, errores y Kotlin avanzado

### Contenido disponible

- clases/objetos;
- encapsulamiento;
- herencia/polimorfismo cuando corresponda;
- manejo de errores;
- `data class` / `sealed class` según avance;
- corrutinas sólo después de su introducción formal.

### Problema de entrada

Las listas paralelas representan una sola cosa sin expresarla como unidad.

### Evolución

```text
listas paralelas
      ↓
Registro como objeto
      ↓
MutableList<Registro>
      ↓
operaciones sobre objetos
```

Los requerimientos ya conocidos —buscar, completar, filtrar, contar y validar— se conservan; cambia su implementación.

### Estado objetivo

PocketLog sigue siendo **Kotlin de consola**, ahora con un modelo de dominio reconocible y manejo explícito de errores.

---

## Semana 04 · PocketLog v0.4 · consolidación pre-EV1

PocketLog permanece como aplicación de consola y consolida el alcance técnico de la Unidad 1:

- funciones;
- colecciones;
- POO;
- validaciones/errores;
- sintaxis Kotlin avanzada ya estudiada;
- corrutinas sólo dentro del alcance institucional real.

La prioridad es que el estudiante pueda explicar y modificar el programa completo sin depender de una plantilla memorizada.

---

## Semana 05 · EV1 / evaluación de Unidad 1

PocketLog se pausa como proyecto guiado.

No debe utilizarse como plantilla ni replicar el dominio de la evaluación. Sirve como preparación longitudinal de las capacidades técnicas de Kotlin de consola y POO.

---

# Unidad 2 · Android / Compose

## Semana 06

Retomar el core Kotlin y comenzar la aplicación móvil según el contenido institucional de arquitectura, MVVM y Compose base.

## Semana 07

Diseño visual profesional, adaptabilidad y navegación.

## Semana 08

Formularios, validaciones, interacción y paso de información.

## Semana 09

Gestión de estado, animaciones y recursos nativos/cámara según el contenido efectivo.

## Semana 10

Persistencia SQLite conforme al enfoque institucional.

## Semanas 11–12

Evaluación Parcial 2: PocketLog se pausa.

---

# Unidad 3 · Integración y calidad

## Semana 13

Consumo REST y conexión interfaz/backend.

## Semana 14

Pruebas unitarias y aseguramiento de calidad.

## Semana 15

Compilación segura y firma de la aplicación.

## Semanas 16–17

Evaluación Parcial 3: PocketLog se pausa.

## Semana 18

PocketLog queda como evidencia longitudinal del aprendizaje; no sustituye la EFT.

---

# Regla de preparación semanal

Antes de cambiar PocketLog se responde:

1. ¿Qué requerimiento conocido estamos implementando o mejorando?
2. ¿Qué puede hacer la versión anterior?
3. ¿Qué deuda o limitación es visible?
4. ¿Qué contenido nuevo habilita una mejora?
5. ¿Cuál es el cambio mínimo que demuestra ese aprendizaje?
6. ¿Qué técnica posterior debemos evitar?
7. ¿Cuál será el checkpoint ejecutable de salida?

La evolución correcta no agrega tecnología buscando un problema: **mantiene el problema y mejora su solución a medida que el estudiante aprende nuevas herramientas**.
