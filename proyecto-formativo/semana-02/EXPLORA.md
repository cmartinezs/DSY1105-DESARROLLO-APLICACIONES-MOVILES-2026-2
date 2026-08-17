# PocketLog · Semana 02 · Explora un poco más

Este material es **complementario y opcional**. No agrega contenidos obligatorios al checkpoint de Semana 02.

Su objetivo es investigar herramientas de Kotlin que están **muy cerca de lo que ya estamos trabajando** y comparar soluciones, sin adelantar POO, Android ni arquitectura de semanas posteriores.

La regla es simple:

> Investiga, prueba y explica. No basta con pegar una solución encontrada.

---

## Exploración 1 · `any`, `all` y `none`

Ya conocemos operaciones sobre colecciones como `filter`, `map` y `count`.

Investiga qué hacen:

```kotlin
any
all
none
```

### Problema

Usando la lista `completados` de PocketLog, intenta responder sin crear una nueva lista:

1. ¿Existe al menos un registro pendiente?
2. ¿Están todos los registros completados?
3. ¿No existe ningún registro completado?

### Compara

Primero piensa cómo lo resolverías utilizando un `for` y una variable Boolean.

Después prueba la operación de colección correspondiente.

En tu README explica:

- cuál versión te resulta más fácil de leer;
- qué pregunta responde `any`;
- qué diferencia conceptual observas entre `all` y `none`.

> No es necesario reemplazar el código del checkpoint. El objetivo es comparar.

---

## Exploración 2 · Ordenar sin modificar la lista original

Investiga:

```kotlin
sorted()
sortedDescending()
```

Usa una lista pequeña de categorías o títulos y comprueba qué ocurre.

### Preguntas

- ¿la colección original cambia?
- ¿qué devuelve `sorted()`?
- ¿cómo comprobarías que tienes una nueva colección?

### Desafío PocketLog

Muestra los títulos de PocketLog ordenados alfabéticamente **sin modificar el orden original de `titulos`**.

Después imprime nuevamente la lista original para comprobarlo.

---

## Exploración 3 · ¿Qué ocurre si las listas dejan de estar sincronizadas?

Actualmente PocketLog mantiene:

```text
titulos
categorias
completados
```

Todas deberían tener la misma cantidad de elementos.

Haz deliberadamente esta prueba:

1. agrega un título nuevo;
2. **no** agregues su categoría ni su estado;
3. ejecuta `mostrarRegistros`.

### Antes de ejecutar

Predice qué crees que ocurrirá.

Después registra:

- qué ocurrió realmente;
- qué línea o acceso provoca el problema;
- por qué depender del mismo índice en varias listas es frágil.

### Importante

No busques todavía “la arquitectura correcta” ni rehagas PocketLog con conceptos de la semana siguiente.

Solo responde:

> ¿Qué característica te gustaría que tuviera Kotlin para mantener juntos los datos que pertenecen a un mismo registro?

Guarda esa respuesta. La retomaremos más adelante.

---

## Exploración 4 · Una función más general

Tenemos operaciones que trabajan sobre categorías concretas.

Investiga si puedes crear:

```kotlin
fun contarPorCategoria(
    categorias: List<String>,
    categoriaBuscada: String
): Int
```

La función debe funcionar para cualquier categoría recibida como parámetro.

Prueba al menos:

```text
estudio
personal
una categoría que no exista
```

### Pregunta

¿Por qué recibir `categoriaBuscada` como parámetro es mejor que crear funciones separadas como:

```text
contarEstudio()
contarPersonal()
```

Relaciona tu respuesta con reutilización de código.

---

# Evidencia opcional

Si realizas estas exploraciones, puedes agregar al README del proyecto una sección:

```markdown
## Exploraciones Semana 02

### any / all / none
...

### sorted
...

### listas desincronizadas
...

### función general
...
```

No se evalúa por cantidad de código. Interesa que puedas explicar qué descubriste.

---

# Límite de la exploración

Esta semana **sí** puedes investigar más operaciones de colecciones o maneras alternativas de resolver con funciones, ciclos y condicionales.

Esta semana **no necesitas** adelantarte a:

- clases propias;
- `data class`;
- herencia;
- corrutinas;
- Android;
- Compose;
- MVVM;
- bases de datos.

Cuando alguno de esos conceptos corresponda al plan, PocketLog creará una necesidad concreta para estudiarlo.