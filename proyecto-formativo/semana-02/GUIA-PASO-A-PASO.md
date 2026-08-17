# PocketLog · Semana 02 · Guía paso a paso

## Propósito

Esta guía construye la **primera versión funcional de PocketLog** usando solamente los contenidos de la Semana 02:

- `val` y `var`;
- tipos básicos;
- `println` y String templates;
- operadores;
- `if` y `when`;
- ciclos;
- funciones;
- `List` y `MutableList`;
- `filter`, `map`, `count` y recorridos.

> No usamos clases propias todavía. Esa decisión es intencional: POO corresponde a la Semana 03.

La dinámica será siempre:

```text
problema → alternativas → decisión → código → prueba → reflexión
```

Al final de la semana queda una versión ejecutable en:

[`../checkpoint-semana-02/PocketLog.kt`](../checkpoint-semana-02/PocketLog.kt)

---

# Paso 0 · ¿Qué vamos a construir?

PocketLog será una bitácora personal simple.

Cada registro necesita por ahora:

```text
título
categoría
estado: pendiente/completado
```

Ejemplo:

```text
Revisar guía Kotlin · estudio · PENDIENTE
Comprar alimento · personal · COMPLETADO
```

### Decisión

No construiremos menú, base de datos, Android ni clases todavía. Primero necesitamos dominar Kotlin básico sobre un problema que pueda evolucionar después.

---

# Paso 1 · Primer dato

Comencemos con una sola entrada:

```kotlin
val titulo = "Revisar guía Kotlin"
val categoria = "estudio"
val completado = false
```

## ¿Por qué `val`?

Podríamos escribir:

```kotlin
var titulo = "Revisar guía Kotlin"
```

pero si no existe todavía una razón para reasignarlo, `val` comunica mejor nuestra intención.

### Comparación

```text
val → la referencia no será reasignada
var → la referencia puede cambiar
```

### Descubre tú

Cambia `val titulo` por `var titulo` y luego reasigna otro texto.

¿Qué permite ahora el compilador que antes no permitía?

---

# Paso 2 · Mostrar información

Podríamos concatenar:

```kotlin
println(titulo + " · " + categoria)
```

pero Kotlin posee String templates:

```kotlin
println("$titulo · $categoria")
```

### Decisión

Usaremos String templates porque expresan mejor la intención y reducen ruido.

Cuando hay una expresión:

```kotlin
println("Estado: ${if (completado) "COMPLETADO" else "PENDIENTE"}")
```

---

# Paso 3 · Tomar una decisión con `if`

Necesitamos presentar el estado del registro.

```kotlin
val estado = if (completado) {
    "COMPLETADO"
} else {
    "PENDIENTE"
}
```

En Kotlin `if` puede producir un valor.

### Alternativa

Podríamos imprimir directamente dentro del `if`:

```kotlin
if (completado) {
    println("COMPLETADO")
} else {
    println("PENDIENTE")
}
```

### Decisión

Preferimos calcular primero `estado` y luego mostrarlo. Así la decisión y la presentación quedan más separadas.

---

# Paso 4 · Más de un registro: aparece una colección

PocketLog deja de ser útil si solo puede representar una entrada.

Podríamos crear:

```kotlin
val titulo1 = "Revisar guía Kotlin"
val titulo2 = "Comprar alimento"
val titulo3 = "Practicar colecciones"
```

Pero esta solución escala mal.

### Decisión

Usaremos una colección:

```kotlin
val titulos = mutableListOf(
    "Revisar guía Kotlin",
    "Comprar alimento",
    "Practicar colecciones"
)
```

### `List` vs `MutableList`

```text
List        → colección de lectura
MutableList → permite agregar/quitar/modificar elementos
```

Para esta primera versión queremos poder experimentar agregando registros, por eso usamos `MutableList`.

### Descubre tú

Cambia `mutableListOf` por `listOf` e intenta ejecutar:

```kotlin
titulos.add("Nuevo registro")
```

¿Qué ocurre y por qué?

---

# Paso 5 · ¿Y la categoría y el estado?

Como todavía no hemos estudiado clases propias, mantendremos tres listas coordinadas:

```kotlin
val titulos = mutableListOf(
    "Revisar guía Kotlin",
    "Comprar alimento",
    "Practicar colecciones"
)

val categorias = mutableListOf(
    "estudio",
    "personal",
    "estudio"
)

val completados = mutableListOf(
    false,
    true,
    false
)
```

El índice representa el mismo registro:

```text
índice 0
 título      = Revisar guía Kotlin
 categoría   = estudio
 completado  = false
```

## ¿Es una solución perfecta?

No.

Podríamos equivocarnos y dejar las listas con tamaños distintos. También es fácil perder la relación entre los datos.

### ¿Entonces por qué la usamos?

Porque resuelve el problema con las herramientas que conocemos **hoy** y nos dejará descubrir una necesidad real de POO la próxima semana.

> Una buena solución depende también del conocimiento y de los requisitos disponibles en ese momento. Luego se puede refactorizar.

---

# Paso 6 · Recorrer los registros

Necesitamos mostrar todos los registros.

Una alternativa es recorrer directamente los títulos:

```kotlin
for (titulo in titulos) {
    println(titulo)
}
```

Pero necesitamos acceder también a categoría y estado.

### Decisión

Recorreremos índices:

```kotlin
for (indice in titulos.indices) {
    val estado = if (completados[indice]) "COMPLETADO" else "PENDIENTE"
    println("${indice + 1}. ${titulos[indice]} · ${categorias[indice]} · $estado")
}
```

### Pregunta

¿Por qué `indice + 1` se utiliza solo para mostrar y no para acceder a las listas?

---

# Paso 7 · La lógica se repite: aparece una función

Si necesitamos mostrar registros en distintos puntos, copiar el `for` sería duplicar código.

Extraemos una función:

```kotlin
fun mostrarRegistros(
    titulos: List<String>,
    categorias: List<String>,
    completados: List<Boolean>
) {
    for (indice in titulos.indices) {
        val estado = if (completados[indice]) "COMPLETADO" else "PENDIENTE"
        println("${indice + 1}. ${titulos[indice]} · ${categorias[indice]} · $estado")
    }
}
```

## Decisión importante

La función recibe `List`, aunque desde `main()` tengamos `MutableList`.

¿Por qué?

Porque `mostrarRegistros` **solo necesita leer**.

No tiene motivo para modificar las colecciones.

```text
main posee MutableList
          ↓
mostrarRegistros necesita solo List
```

Esto reduce las capacidades que entregamos a una función.

---

# Paso 8 · Filtrar por categoría

Queremos responder:

> “Muéstrame solamente los registros de estudio”.

Una forma imperativa sería:

```kotlin
val resultado = mutableListOf<String>()

for (indice in titulos.indices) {
    if (categorias[indice] == "estudio") {
        resultado.add(titulos[indice])
    }
}
```

Es válida.

Kotlin también permite expresarlo mediante operaciones sobre colecciones:

```kotlin
val resultado = titulos.filterIndexed { indice, _ ->
    categorias[indice].equals("estudio", ignoreCase = true)
}
```

### Decisión

Estudiaremos **ambas formas**.

Primero debemos ser capaces de explicar el `for`. Después usamos `filterIndexed` para expresar la intención de “filtrar”.

> No usamos funciones de colección para evitar comprender ciclos; las usamos después de comprender qué problema resuelven.

---

# Paso 9 · Convertirlo en una función reutilizable

```kotlin
fun filtrarTitulosPorCategoria(
    titulos: List<String>,
    categorias: List<String>,
    categoriaBuscada: String
): List<String> =
    titulos.filterIndexed { indice, _ ->
        categorias[indice].equals(categoriaBuscada, ignoreCase = true)
    }
```

Ahora podemos hacer:

```kotlin
filtrarTitulosPorCategoria(titulos, categorias, "estudio")
    .forEach { println("- $it") }
```

### Descubre tú

¿Qué ocurre si buscas `ESTUDIO` en mayúsculas?

Luego elimina `ignoreCase = true` y vuelve a probar.

Explica la diferencia.

---

# Paso 10 · Obtener pendientes

La idea es similar:

```kotlin
fun titulosPendientes(
    titulos: List<String>,
    completados: List<Boolean>
): List<String> =
    titulos.filterIndexed { indice, _ -> !completados[indice] }
```

Aquí estamos combinando:

```text
funciones
colecciones
Boolean
negación !
filterIndexed
```

---

# Paso 11 · Contar y decidir con `when`

Podemos calcular cuántos registros siguen pendientes:

```kotlin
val pendientes = completados.count { !it }
```

Y producir un mensaje:

```kotlin
val mensaje = when {
    pendientes == 0 -> "No quedan pendientes"
    pendientes == 1 -> "Queda 1 pendiente"
    else -> "Quedan $pendientes pendientes"
}
```

### ¿Podríamos usar `if`?

Sí.

`when` no es obligatorio.

### Decisión

Aquí lo usamos porque hay tres ramas y resulta legible. La elección entre `if` y `when` depende del problema, no de una regla de “siempre usar X”.

---

# Paso 12 · Integramos la versión semanal

El checkpoint completo está en:

[`../checkpoint-semana-02/PocketLog.kt`](../checkpoint-semana-02/PocketLog.kt)

Ejecuta la aplicación y comprueba:

1. se muestran todos los registros;
2. se muestran solo los de categoría `estudio`;
3. se muestran los pendientes;
4. se calcula correctamente el resumen.

---

# Desafío corto · Ahora tú

Sin copiar una solución completa, agrega **una** de estas capacidades:

### Opción A

Crear una función que devuelva los títulos completados.

### Opción B

Crear una función que cuente registros de una categoría recibida por parámetro.

### Opción C

Agregar un cuarto registro manteniendo correctamente sincronizadas las tres listas.

Debes poder explicar:

- qué función/colección utilizaste;
- qué recibe;
- qué devuelve;
- por qué elegiste esa solución.

---

# La incomodidad que dejamos intencionalmente

Observa esta llamada:

```kotlin
mostrarRegistros(titulos, categorias, completados)
```

Tenemos tres listas que siempre deben permanecer sincronizadas.

Imagina que PocketLog crece y cada registro agrega:

```text
descripción
fecha
tags
prioridad
foto
```

¿Crearíamos ocho listas separadas?

Ese será el problema de entrada de la Semana 03.

No lo resolvemos todavía.

La próxima semana podremos preguntar:

> **¿Existe una forma de representar todos los datos y comportamientos de un registro como una sola unidad?**

Ahí aparecerá POO por necesidad, no porque el cronograma diga “ahora toca una clase”.

---

# Checkpoint Semana 02

Al terminar debes conservar:

```text
PocketLog v0.2
- Kotlin consola
- datos en memoria
- listas
- condicionales
- ciclos
- funciones
- filtros
- conteos
- sin clases propias
- sin Android
```

Este archivo **no se reemplaza** la próxima semana. Se conserva como versión histórica y se crea un nuevo checkpoint.
