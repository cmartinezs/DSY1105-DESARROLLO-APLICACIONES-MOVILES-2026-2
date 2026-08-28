# PocketLog · Semana 02 · Punto de partida

## ¿Qué es PocketLog?

PocketLog será una bitácora personal sencilla que irá creciendo durante el semestre.

No buscamos construir una aplicación compleja esta semana. Buscamos tener un problema suficientemente estable como para aplicar sobre él lo que vayamos aprendiendo.

Por ahora un registro necesita solamente:

```text
título
categoría
estado: pendiente o completado
```

Ejemplos:

```text
Revisar guía Kotlin · estudio · PENDIENTE
Comprar alimento · personal · COMPLETADO
Practicar colecciones · estudio · PENDIENTE
```

---

# ¿Qué sabemos al comenzar?

Venimos de una introducción a Kotlin y una comparación inicial con Java.

Esta semana trabajaremos únicamente con herramientas que corresponden al contenido planificado:

- variables;
- tipos;
- operadores;
- condicionales;
- ciclos;
- funciones;
- colecciones.

## Qué NO usaremos todavía

Aunque sabemos que más adelante PocketLog será una aplicación móvil, **hoy no necesitamos**:

```text
clases propias
Android
Compose
MVVM
SQLite
REST
```

No evitamos esas herramientas porque sean malas. Simplemente todavía no corresponde utilizarlas.

> Una solución correcta también debe ser apropiada para el conocimiento y requisitos disponibles en ese momento.

---

# Primera decisión

Podríamos comenzar diseñando todo el sistema futuro.

No lo haremos.

Comenzaremos con una pregunta mucho más pequeña:

> **¿Cómo represento y muestro un registro usando solamente Kotlin básico?**

Cuando eso funcione, agregaremos una segunda necesidad.

Luego una tercera.

El proyecto crecerá junto con el contenido del curso.

---

# Regla de trabajo

Durante PocketLog aparecerán dos tipos de decisiones:

### Decisión necesaria ahora

Ejemplo:

> Tenemos varios títulos. ¿Conviene crear `titulo1`, `titulo2`, `titulo3` o usar una colección?

Eso sí lo resolvemos en esta semana.

### Decisión futura

Ejemplo:

> Tenemos varios datos relacionados y mantenerlos separados comienza a ser incómodo.

Podemos reconocer el problema, pero **no estamos obligados a resolverlo todavía**.

Esa incomodidad puede convertirse en la pregunta de entrada de una clase posterior.

---

# Cómo usar estas guías

No leas PocketLog como si fuera documentación de una aplicación terminada.

Úsalo como un cuaderno de construcción:

1. escribe la primera versión;
2. ejecútala;
3. comprueba qué hace;
4. identifica una limitación;
5. aprende una herramienta nueva;
6. modifica el mismo código;
7. vuelve a ejecutar;
8. compara antes y después.

Al terminar cada clase debe quedar una versión que **funcione con lo aprendido hasta ese momento**.

➡️ Continúa con [Clase 01 · Fundamentos Kotlin](./01-clase-01-fundamentos.md).
