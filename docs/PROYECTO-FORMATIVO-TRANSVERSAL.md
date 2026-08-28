# Proyecto formativo transversal · PocketLog

## Propósito

**PocketLog** es el proyecto longitudinal de DSY1105. El mismo producto evoluciona desde una aplicación Kotlin de consola muy simple hasta una aplicación móvil completa, siguiendo el avance real de la asignatura.

La regla curricular es:

> **Los requerimientos se conocen desde Semana 01; las técnicas de implementación sólo se incorporan cuando el contenido de la asignatura las habilita.**

Esto permite enseñar refactorización y evolución real: el estudiante no cambia de problema cada semana, sino que mejora la solución del mismo problema.

---

# Fuente de verdad

Antes de preparar un incremento se revisa:

1. cronograma institucional;
2. material oficial de la semana;
3. avance real de la sección;
4. [requerimientos de PocketLog](../proyecto-formativo/REQUERIMIENTOS.md);
5. checkpoint anterior.

```text
requerimiento conocido
      +
avance real
      +
contenido nuevo
      ↓
problema visible en la versión actual
      ↓
refactor/incremento
      ↓
checkpoint ejecutable
```

---

# Dominio estable

PocketLog es una bitácora personal de registros.

Desde el inicio se conoce que un registro necesita al menos:

- identificador;
- título;
- categoría;
- estado pendiente/completado.

También se conocen las capacidades base de la Unidad 1:

- registrar;
- mostrar/listar;
- cambiar estado;
- buscar;
- filtrar;
- contar;
- validar y manejar errores.

No todas se implementan en Semana 01. El punto pedagógico es precisamente ver cómo el mismo requerimiento se resuelve mejor a medida que aparece nuevo conocimiento.

---

# Evolución de Unidad 1

## Semana 01 · v0.1

PocketLog **ya existe y ejecuta en Kotlin de consola**.

Representación:

```text
idRegistro
tituloRegistro
categoriaRegistro
registroCompletado
```

Operaciones:

```text
funciones top-level independientes
```

No hay clases. La deuda técnica es deliberada.

## Semana 02 · v0.2

El producto necesita varios registros. Los fundamentos Kotlin y colecciones permiten evolucionar a:

```text
List / MutableList
funciones
ciclos
filter / map / count
```

Puede existir deuda deliberada mediante listas paralelas.

## Semana 03 · v0.3

POO permite resolver la fragmentación de datos:

```text
listas paralelas
      ↓
Registro como clase/data class
      ↓
MutableList<Registro>
```

Se incorporan control de errores, sintaxis avanzada y corrutinas sólo al nivel realmente trabajado.

## Semana 04 · v0.4

Consolidación de Kotlin de consola antes de EV1.

PocketLog debe permitir practicar las capacidades técnicas de la unidad sin convertirse en plantilla ni copiar el dominio de la evaluación.

## Semana 05 · EV1

PocketLog se pausa.

---

# Evolución posterior

- Semana 06: Android/Compose/MVVM según contenido institucional.
- Semana 07: diseño y navegación.
- Semana 08: formularios y validaciones.
- Semana 09: estado y recursos nativos.
- Semana 10: SQLite.
- Semanas 11–12: evaluación, PocketLog se pausa.
- Semana 13: REST.
- Semana 14: pruebas unitarias.
- Semana 15: compilación y firma.
- Semanas 16–17: evaluación, PocketLog se pausa.
- Semana 18: evidencia longitudinal; no sustituye EFT.

---

# Regla de arquitectura

La arquitectura se descubre progresivamente.

No se agrega una abstracción porque “será útil después”. Primero debe existir un problema observable y contenido curricular que permita resolverlo.

Ejemplo:

```text
Semana 01: datos sueltos
Semana 02: colecciones
Semana 03: objetos
Semanas móviles: UI sobre lógica reutilizable
Persistencia/REST: sólo cuando el programa los introduce
```

---

# Regla para cada guía semanal

Cada guía debe contener:

1. **RECIBE** · estado anterior;
2. **REQUERIMIENTO** · qué capacidad conocida se trabaja;
3. **APRENDEMOS** · contenido habilitante;
4. **PROBLEMA** · deuda visible;
5. **DECISIÓN** · mejora elegida;
6. **PASO A PASO** · implementación incremental;
7. **DESCUBRE TÚ** · parte que resuelve el estudiante;
8. **COMPRUEBA** · evidencia;
9. **CHECKPOINT** · versión ejecutable;
10. **DEJA ABIERTO** · siguiente deuda.

La pregunta central siempre es:

> ¿Cómo mejora esta semana la implementación de un requerimiento que PocketLog ya tenía?
