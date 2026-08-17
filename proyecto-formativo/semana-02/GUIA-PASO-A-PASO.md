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
- operaciones sobre colecciones como `filter`, `map` y `count`.

> No usamos clases propias todavía. Esa decisión es intencional: POO corresponde a la Semana 03.

PocketLog seguirá además una segunda regla pedagógica:

> **Primero escribimos la solución de forma explícita. Cuando entendemos el mecanismo, evolucionamos hacia una forma más corta e idiomática de Kotlin.**

La dinámica será:

```text
problema
  ↓
solución explícita
  ↓
comprender el mecanismo
  ↓
alternativa Kotlin
  ↓
comparar
  ↓
decidir
  ↓
prueba / reflexión
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

# Paso 1 · Primer dato: declaración explícita

Comencemos indicando los tipos:

```kotlin
val titulo: String = "Revisar guía Kotlin"
val categoria: String = "estudio"
val completado: Boolean = false
```

Es importante reconocer cada parte:

```text
val titulo: String = "Revisar guía Kotlin"
↑   ↑       ↑        ↑
    nombre  tipo     valor
```

## Comparación con Java

Java:

```java
String titulo = "Revisar guía Kotlin";
String categoria = "estudio";
boolean completado = false;
```

Kotlin:

```kotlin
val titulo: String = "Revisar guía Kotlin"
val categoria: String = "estudio"
val completado: Boolean = false
```

El tipo cambia de posición y Kotlin no exige `;`.

## ¿Por qué `val`?

Podríamos escribir:

```kotlin
var titulo: String = "Revisar guía Kotlin"
```

pero si no existe una razón para reasignarlo, `val` comunica mejor nuestra intención.

### Ahora acortamos: inferencia

Como el valor hace evidente el tipo, Kotlin puede inferirlo:

```kotlin
val titulo = "Revisar guía Kotlin"
val categoria = "estudio"
val completado = false
```

No cambiamos el tipo de las variables. Solo dejamos que el compilador lo deduzca.

### Descubre tú

1. deja el cursor sobre cada variable en IntelliJ;
2. identifica el tipo inferido;
3. cambia `val titulo` a `var titulo`;
4. reasigna otro texto.

¿Qué permite ahora el compilador que antes no permitía?

---

# Paso 2 · Mostrar información: primero concatenación

Una forma familiar desde Java sería:

```kotlin
println(titulo + " · " + categoria)
```

Funciona correctamente.

Si agregamos estado:

```kotlin
println(titulo + " · " + categoria + " · " + completado)
```

El resultado funciona, pero comienza a tener bastante ruido sintáctico.

## Evolucionamos a String templates

Kotlin permite:

```kotlin
println("$titulo · $categoria · $completado")
```

Y para una expresión:

```kotlin
println("Estado: ${if (completado) "COMPLETADO" else "PENDIENTE"}")
```

### Decisión

Usaremos String templates porque expresan mejor la intención, pero primero debíamos reconocer que estamos construyendo exactamente el mismo texto.

---

# Paso 3 · Tomar una decisión con `if`: versión larga

Necesitamos presentar un estado legible.

Primero lo hacemos explícitamente:

```kotlin
var estado: String = ""

if (completado) {
    estado = "COMPLETADO"
} else {
    estado = "PENDIENTE"
}

println(estado)
```

Esta versión permite observar claramente:

```text
variable inicial
      ↓
condición
      ↓
asignación en una rama
      ↓
resultado
```

## Primera evolución: `if` como expresión

En Kotlin `if` puede devolver un resultado:

```kotlin
val estado: String = if (completado) {
    "COMPLETADO"
} else {
    "PENDIENTE"
}
```

Observa que ahora podemos utilizar `val`.

## Segunda evolución: forma corta

Como las dos ramas son simples:

```kotlin
val estado = if (completado) "COMPLETADO" else "PENDIENTE"
```

### Compara

Pregunta para discutir:

> ¿Qué versión enseña mejor cómo funciona un condicional? ¿Qué versión resulta cómoda cuando ya entendemos el mecanismo?

---

# Paso 4 · Más de un registro: aparece una colección

PocketLog deja de ser útil si solo puede representar una entrada.

Podríamos escribir:

```kotlin
val titulo1 = "Revisar guía Kotlin"
val titulo2 = "Comprar alimento"
val titulo3 = "Practicar colecciones"
```

Pero esta solución escala mal.

## Forma explícita

Declaramos una lista indicando su tipo:

```kotlin
val titulos: MutableList<String> = mutableListOf(
    "Revisar guía Kotlin",
    "Comprar alimento",
    "Practicar colecciones"
)
```

## Forma con inferencia

Una vez entendido el tipo:

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

Para esta primera versión queremos experimentar agregando registros, por eso usamos `MutableList`.

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
val titulos: MutableList<String> = mutableListOf(
    "Revisar guía Kotlin",
    "Comprar alimento",
    "Practicar colecciones"
)

val categorias: MutableList<String> = mutableListOf(
    "estudio",
    "personal",
    "estudio"
)

val completados: MutableList<Boolean> = mutableListOf(
    false,
    true,
    false
)
```

Luego podemos dejar actuar a la inferencia si todos comprenden ya los tipos:

```kotlin
val titulos = mutableListOf(
    "Revisar guía Kotlin",
    "Comprar alimento",
    "Practicar colecciones"
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

Porque resuelve el problema con las herramientas que conocemos **hoy** y nos permitirá observar una limitación real.

No necesitamos conocer todavía la solución de la semana siguiente.

---

# Paso 6 · Recorrer los registros: primero el ciclo

Una primera aproximación permite recorrer solo los títulos:

```kotlin
for (titulo in titulos) {
    println(titulo)
}
```

Pero necesitamos acceder también a categoría y estado.

## Recorrido por índices

```kotlin
for (indice in titulos.indices) {
    var estado = ""

    if (completados[indice]) {
        estado = "COMPLETADO"
    } else {
        estado = "PENDIENTE"
    }

    println(
        (indice + 1) + ". " +
        titulos[indice] + " · " +
        categorias[indice] + " · " +
        estado
    )
}
```

Esta versión es larga, pero permite ver cada paso.

## Primera mejora: `if` como expresión

```kotlin
for (indice in titulos.indices) {
    val estado = if (completados[indice]) {
        "COMPLETADO"
    } else {
        "PENDIENTE"
    }

    println(
        (indice + 1) + ". " +
        titulos[indice] + " · " +
        categorias[indice] + " · " +
        estado
    )
}
```

## Segunda mejora: String template

```kotlin
for (indice in titulos.indices) {
    val estado = if (completados[indice]) {
        "COMPLETADO"
    } else {
        "PENDIENTE"
    }

    println("${indice + 1}. ${titulos[indice]} · ${categorias[indice]} · $estado")
}
```

## Tercera mejora: condicional breve

Cuando ya entendemos las dos ramas:

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

Si necesitamos mostrar registros en distintos puntos, copiar el `for` duplicaría código.

## Versión explícita

```kotlin
fun mostrarRegistros(
    titulos: List<String>,
    categorias: List<String>,
    completados: List<Boolean>
): Unit {
    for (indice in titulos.indices) {
        val estado: String

        if (completados[indice]) {
            estado = "COMPLETADO"
        } else {
            estado = "PENDIENTE"
        }

        println("${indice + 1}. ${titulos[indice]} · ${categorias[indice]} · $estado")
    }
}
```

`Unit` indica que la función no devuelve un resultado útil para el llamador, equivalente conceptualmente al uso de `void` en Java.

## Kotlin permite omitir `: Unit`

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

### Decisión importante

La función recibe `List`, aunque desde `main()` tengamos `MutableList`.

¿Por qué?

Porque `mostrarRegistros` **solo necesita leer**.

```text
main posee MutableList
          ↓
mostrarRegistros necesita solo List
```

Reducimos así lo que la función tiene permitido hacer.

---

# Paso 8 · Filtrar por categoría: primero hacerlo manualmente

Queremos responder:

> “Muéstrame solamente los registros de estudio”.

## Versión 1 · Ciclo + condición

```kotlin
val resultado: MutableList<String> = mutableListOf()

for (indice in titulos.indices) {
    if (categorias[indice].equals("estudio", ignoreCase = true)) {
        resultado.add(titulos[indice])
    }
}
```

Antes de continuar, debemos poder explicar:

1. por qué necesitamos una lista de resultado;
2. qué recorre el `for`;
3. qué evalúa el `if`;
4. cuándo se ejecuta `add`.

## Versión 2 · `filterIndexed` con parámetros nombrados

Kotlin ya posee una operación que expresa la intención de filtrar:

```kotlin
val resultado = titulos.filterIndexed { indice, titulo ->
    categorias[indice].equals("estudio", ignoreCase = true)
}
```

Aquí `titulo` existe aunque en este caso no necesitamos usarlo.

Podemos señalarlo explícitamente como parámetro ignorado:

```kotlin
val resultado = titulos.filterIndexed { indice, _ ->
    categorias[indice].equals("estudio", ignoreCase = true)
}
```

## Versión 3 · expresión compacta

Si la lectura sigue siendo clara:

```kotlin
val resultado = titulos.filterIndexed { indice, _ ->
    categorias[indice].equals("estudio", ignoreCase = true)
}
```

### Decisión

Estudiaremos **ambas estrategias**.

No usamos `filterIndexed` para evitar aprender ciclos. Lo usamos después de comprender el ciclo porque expresa directamente la intención de **filtrar**.

---

# Paso 9 · Convertir el filtro en función reutilizable

## Forma completa

```kotlin
fun filtrarTitulosPorCategoria(
    titulos: List<String>,
    categorias: List<String>,
    categoriaBuscada: String
): List<String> {
    val resultado: MutableList<String> = mutableListOf()

    for (indice in titulos.indices) {
        if (categorias[indice].equals(categoriaBuscada, ignoreCase = true)) {
            resultado.add(titulos[indice])
        }
    }

    return resultado
}
```

Esta versión deja muy visible el proceso.

## Refactor con `filterIndexed`

```kotlin
fun filtrarTitulosPorCategoria(
    titulos: List<String>,
    categorias: List<String>,
    categoriaBuscada: String
): List<String> {
    return titulos.filterIndexed { indice, _ ->
        categorias[indice].equals(categoriaBuscada, ignoreCase = true)
    }
}
```

## Expression body

Cuando ya comprendemos que la función solo devuelve esa expresión:

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

### Descubre tú

¿Qué ocurre si buscas `ESTUDIO` en mayúsculas?

Luego elimina `ignoreCase = true` y vuelve a probar.

Explica la diferencia.

---

# Paso 10 · Obtener pendientes: la misma evolución

## Versión explícita

```kotlin
fun titulosPendientes(
    titulos: List<String>,
    completados: List<Boolean>
): List<String> {
    val pendientes: MutableList<String> = mutableListOf()

    for (indice in titulos.indices) {
        if (!completados[indice]) {
            pendientes.add(titulos[indice])
        }
    }

    return pendientes
}
```

Aquí combinamos:

```text
funciones
listas
Boolean
negación !
for
if
return
```

## Después usamos `filterIndexed`

```kotlin
fun titulosPendientes(
    titulos: List<String>,
    completados: List<Boolean>
): List<String> {
    return titulos.filterIndexed { indice, _ ->
        !completados[indice]
    }
}
```

## Finalmente, expression body

```kotlin
fun titulosPendientes(
    titulos: List<String>,
    completados: List<Boolean>
): List<String> =
    titulos.filterIndexed { indice, _ -> !completados[indice] }
```

No es una solución diferente: es la misma intención expresada con una abstracción más compacta.

---

# Paso 11 · Contar pendientes: no saltamos directamente a `count`

Queremos saber cuántos registros están pendientes.

## Versión 1 · contador manual

```kotlin
var pendientes = 0

for (completado in completados) {
    if (!completado) {
        pendientes = pendientes + 1
    }
}
```

Podemos simplificar el incremento:

```kotlin
var pendientes = 0

for (completado in completados) {
    if (!completado) {
        pendientes++
    }
}
```

## Versión 2 · `count` con parámetro nombrado

Kotlin puede contar directamente los elementos que cumplen una condición:

```kotlin
val pendientes = completados.count { completado ->
    !completado
}
```

## Versión 3 · parámetro implícito `it`

Cuando ya sabemos que la lambda recibe un único elemento:

```kotlin
val pendientes = completados.count {
    !it
}
```

Finalmente:

```kotlin
val pendientes = completados.count { !it }
```

### ¿Qué representa `it`?

En esta expresión:

```kotlin
completados.count { !it }
```

`it` representa **cada Boolean de la lista durante la evaluación**.

No deberíamos utilizar `it` si no somos capaces de decir qué objeto representa.

---

# Paso 12 · Decidir el mensaje: `if` vs `when`

Podríamos resolver tres casos mediante `if`:

```kotlin
var mensaje = ""

if (pendientes == 0) {
    mensaje = "No quedan pendientes"
} else if (pendientes == 1) {
    mensaje = "Queda 1 pendiente"
} else {
    mensaje = "Quedan $pendientes pendientes"
}
```

## Primera evolución: eliminar la mutabilidad

```kotlin
val mensaje = if (pendientes == 0) {
    "No quedan pendientes"
} else if (pendientes == 1) {
    "Queda 1 pendiente"
} else {
    "Quedan $pendientes pendientes"
}
```

## Otra alternativa: `when`

Como tenemos varias ramas:

```kotlin
val mensaje = when {
    pendientes == 0 -> "No quedan pendientes"
    pendientes == 1 -> "Queda 1 pendiente"
    else -> "Quedan $pendientes pendientes"
}
```

### ¿Cuál es correcta?

Ambas.

La discusión es de legibilidad y adecuación al problema, no de “Kotlin obliga a usar `when`”.

---

# Paso 13 · Mostrar una lista devuelta por una función

Supongamos:

```kotlin
val pendientes = titulosPendientes(titulos, completados)
```

## Primero con `for`

```kotlin
for (titulo in pendientes) {
    println("- $titulo")
}
```

## Después con `forEach` y parámetro nombrado

```kotlin
pendientes.forEach { titulo ->
    println("- $titulo")
}
```

## Finalmente con `it`

```kotlin
pendientes.forEach {
    println("- $it")
}
```

Y, si sigue siendo perfectamente legible:

```kotlin
pendientes.forEach { println("- $it") }
```

La progresión vuelve a ser:

```text
for
↓
forEach { titulo -> ... }
↓
forEach { it ... }
```

---

# Paso 14 · Integramos la versión semanal

El checkpoint completo está en:

[`../checkpoint-semana-02/PocketLog.kt`](../checkpoint-semana-02/PocketLog.kt)

Durante la clase no es necesario escribir inmediatamente la versión más compacta del checkpoint.

La idea es llegar a ella mediante refactorizaciones pequeñas y comprobar después de cada cambio que el comportamiento sigue siendo el mismo.

Comprueba:

1. se muestran todos los registros;
2. se muestran solo los de categoría `estudio`;
3. se muestran los pendientes;
4. se calcula correctamente el resumen.

---

# Desafío corto · Ahora tú

Sin copiar una solución completa, agrega **una** de estas capacidades.

## Opción A

Crear una función que devuelva los títulos completados.

Primero resuélvela con `for` + `if`.

Después investiga si puedes expresarla con una operación de colección.

## Opción B

Crear una función que cuente registros de una categoría recibida por parámetro.

Primero usa un contador manual.

Después compara con `count`.

## Opción C

Agregar un cuarto registro manteniendo correctamente sincronizadas las tres listas.

Debes poder explicar:

- qué estructuras utilizaste;
- qué recibe cada función;
- qué devuelve;
- cuál fue tu primera solución;
- qué versión más idiomática encontraste después;
- por qué ambas producen el mismo resultado.

---

# La incomodidad que dejamos intencionalmente

Observa esta llamada:

```kotlin
mostrarRegistros(titulos, categorias, completados)
```

Tenemos tres listas que siempre deben permanecer sincronizadas.

Imagina que PocketLog crece y cada registro agrega más información.

¿Seguiríamos creando una colección diferente por cada dato?

No resolvemos esa pregunta todavía.

La dejamos abierta para la próxima etapa del curso.

> El objetivo no es adivinar la sintaxis futura, sino reconocer que la solución actual comienza a ser difícil de mantener.

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
- evolución desde sintaxis explícita hacia sintaxis idiomática
- sin clases propias
- sin Android
```

Y debes poder tomar una expresión compacta como:

```kotlin
val pendientes = completados.count { !it }
```

y explicar la versión larga equivalente.

Ese es el criterio de aprendizaje:

> **si puedo escribir la versión corta pero no puedo explicar la versión larga, todavía no entendí la abstracción.**

Este archivo **no se reemplaza** la próxima semana. Se conserva como versión histórica y se crea un nuevo checkpoint.
