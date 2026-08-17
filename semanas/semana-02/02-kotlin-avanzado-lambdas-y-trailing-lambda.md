# Kotlin avanzado · Lambdas, funciones de orden superior y trailing lambda

Este documento es una **profundización opcional** para complementar la guía de fundamentos de Kotlin.

No es necesario memorizar estas reglas durante la primera aproximación a colecciones. El objetivo es responder una pregunta que aparece naturalmente cuando comenzamos a usar `forEach`, `filter`, `map` o `count`:

> **¿Por qué en Java `filter` suele verse con paréntesis y en Kotlin aparece una llave después del nombre de la función?**

La respuesta corta es:

> Las llaves no reemplazan los paréntesis de `filter`. Las llaves representan una **lambda**. Kotlin permite escribir una lambda fuera de los paréntesis cuando esa lambda corresponde al último argumento de una función.

A esa regla se le conoce habitualmente como **trailing lambda**.

---

# 1. Antes de `filter`: una función puede recibir otra función

Hasta ahora hemos visto funciones que reciben datos:

```kotlin
fun saludar(nombre: String) {
    println("Hola $nombre")
}
```

Pero Kotlin también permite que un parámetro represente **una función que se ejecutará después**.

Ejemplo:

```kotlin
fun ejecutar(accion: () -> Unit) {
    accion()
}
```

El tipo:

```text
() -> Unit
```

se puede leer como:

```text
función que no recibe parámetros
         ↓
y no devuelve un valor útil
```

Podemos crear una lambda:

```kotlin
val miAccion = {
    println("Hola desde una lambda")
}
```

y entregarla a la función:

```kotlin
ejecutar(miAccion)
```

---

# 2. ¿Qué es una lambda?

Una lambda es una función que podemos escribir sin darle necesariamente un nombre.

Por ejemplo:

```kotlin
{ numero: Int ->
    numero > 10
}
```

Podemos leerla como:

```text
recibo un Int llamado numero
        ↓
evalúo numero > 10
        ↓
produzco true o false
```

Su tipo sería conceptualmente:

```text
(Int) -> Boolean
```

Eso significa:

```text
recibe Int
   ↓
devuelve Boolean
```

---

# 3. Una llamada completamente explícita

Supongamos esta función:

```kotlin
fun procesar(valor: Int, accion: (Int) -> Unit) {
    accion(valor)
}
```

La llamada puede escribirse de forma totalmente explícita:

```kotlin
procesar(10, { numero ->
    println(numero)
})
```

Observemos qué pertenece a cada cosa.

```text
procesar(
    10,
    { numero -> println(numero) }
)
```

Los **paréntesis** pertenecen a la llamada de `procesar`.

Las **llaves** pertenecen a la lambda.

La lambda completa es:

```kotlin
{ numero ->
    println(numero)
}
```

Por lo tanto, las llaves **no son una sintaxis especial de `filter` ni sustituyen directamente los paréntesis**.

---

# 4. La regla de trailing lambda

En Kotlin existe una regla sintáctica:

> Si el **último argumento** de una función es una lambda, esa lambda puede escribirse fuera de los paréntesis de la llamada.

Partimos desde:

```kotlin
procesar(10, { numero ->
    println(numero)
})
```

Como la lambda es el último argumento, podemos moverla fuera:

```kotlin
procesar(10) { numero ->
    println(numero)
}
```

Las dos llamadas expresan lo mismo.

La segunda suele ser más fácil de leer porque separa:

```text
datos/configuración
        ↓
procesar(10)

comportamiento
        ↓
{
    ...
}
```

---

# 5. ¿Y por qué desaparecen completamente los paréntesis?

Consideremos una función que recibe **solo una lambda**:

```kotlin
fun ejecutar(accion: () -> Unit) {
    accion()
}
```

Forma explícita:

```kotlin
ejecutar({
    println("Hola")
})
```

Aplicamos trailing lambda:

```kotlin
ejecutar() {
    println("Hola")
}
```

Ahora los paréntesis están vacíos.

Kotlin permite omitirlos:

```kotlin
ejecutar {
    println("Hola")
}
```

Por eso vemos expresiones como:

```kotlin
forEach { ... }
filter { ... }
map { ... }
count { ... }
```

La lambda sigue siendo **un argumento de la función**.

---

# 6. Llevándolo a `filter`

Supongamos:

```kotlin
val notas = listOf(5.5, 3.2, 6.1, 2.9)
```

`filter` necesita una función que, para cada elemento, responda:

```text
¿lo conservo?
true  → sí
false → no
```

Conceptualmente recibe algo del tipo:

```text
(Double) -> Boolean
```

Una forma muy explícita sería:

```kotlin
val aprobadas = notas.filter({ nota ->
    nota >= 4.0
})
```

La lambda es:

```kotlin
{ nota ->
    nota >= 4.0
}
```

Como esa lambda es el último argumento de `filter`, puede salir de los paréntesis:

```kotlin
val aprobadas = notas.filter() { nota ->
    nota >= 4.0
}
```

Como los paréntesis quedaron vacíos:

```kotlin
val aprobadas = notas.filter { nota ->
    nota >= 4.0
}
```

Finalmente, como existe un solo parámetro, Kotlin puede representarlo mediante `it`:

```kotlin
val aprobadas = notas.filter {
    it >= 4.0
}
```

Y si sigue siendo legible:

```kotlin
val aprobadas = notas.filter { it >= 4.0 }
```

La evolución completa es:

```text
filter({ nota -> nota >= 4.0 })
              ↓
filter() { nota -> nota >= 4.0 }
              ↓
filter { nota -> nota >= 4.0 }
              ↓
filter { it >= 4.0 }
```

---

# 7. Comparación con Java

En Java moderno podemos encontrar:

```java
List<Double> aprobadas = notas.stream()
        .filter(nota -> nota >= 4.0)
        .toList();
```

Aquí `filter(...)` también recibe una función: la lambda

```java
nota -> nota >= 4.0
```

Java mantiene la lambda dentro de los paréntesis de la llamada.

Kotlin podría escribir una forma muy similar conceptualmente:

```kotlin
val aprobadas = notas.filter({ nota ->
    nota >= 4.0
})
```

Pero el lenguaje ofrece trailing lambda:

```kotlin
val aprobadas = notas.filter { nota ->
    nota >= 4.0
}
```

Por lo tanto, la diferencia visual no significa que Java y Kotlin estén resolviendo problemas totalmente distintos.

En ambos casos ocurre:

```text
filter
  ↓
recibe comportamiento
  ↓
ese comportamiento decide true / false para cada elemento
```

---

# 8. ¿Por qué la regla se aplica al último argumento?

No es solamente una decisión estética.

Supongamos:

```kotlin
fun operar(
    antes: () -> Unit,
    valor: Int,
    despues: () -> Unit
) {
    antes()
    println(valor)
    despues()
}
```

La llamada explícita podría ser:

```kotlin
operar(
    { println("Antes") },
    10,
    { println("Después") }
)
```

Kotlin puede sacar de los paréntesis la **última** lambda:

```kotlin
operar(
    { println("Antes") },
    10
) {
    println("Después")
}
```

La lambda exterior corresponde inequívocamente a `despues`.

Permitir sacar arbitrariamente cualquier argumento funcional haría mucho más difícil determinar visualmente a qué parámetro pertenece.

La posición final ofrece una regla simple y predecible.

---

# 9. ¿Cuál es el fundamento de diseño?

La característica busca principalmente mejorar la **legibilidad de APIs que reciben comportamiento**.

En muchas funciones el último argumento representa algo como:

```text
qué hacer
cómo construir algo
qué ocurre para cada elemento
qué contenido ejecutar
```

Entonces una llamada como:

```kotlin
procesar(10) {
    println("Procesando")
    println("Terminando")
}
```

puede leerse aproximadamente como:

```text
procesar 10
usando este comportamiento:
    ...
```

La lambda pasa visualmente a parecer un **bloque asociado a la operación**.

Esto permite crear APIs expresivas sin agregar nuevas palabras reservadas al lenguaje.

---

# 10. `repeat`: parece una estructura del lenguaje, pero es una función

Por ejemplo:

```kotlin
repeat(3) {
    println("Hola")
}
```

A primera vista podría parecer algo comparable a `for` o `while`.

Pero `repeat` es una función que recibe una lambda.

Una forma simplificada de imaginar su firma es:

```kotlin
fun repeat(times: Int, action: (Int) -> Unit)
```

La llamada:

```kotlin
repeat(3) {
    println("Hola")
}
```

aprovecha exactamente la misma regla de trailing lambda.

---

# 11. Esto explica parte de la apariencia de Kotlin moderno

La misma idea aparece en:

```kotlin
lista.forEach {
    println(it)
}
```

```kotlin
lista.filter {
    it >= 4.0
}
```

```kotlin
lista.map {
    "Nota: $it"
}
```

```kotlin
lista.count {
    it >= 4.0
}
```

Y más adelante aparecerá en muchas APIs de Kotlin.

Por ejemplo, una estructura como:

```kotlin
algo {
    otraCosa {
        ...
    }
}
```

no necesariamente representa una nueva estructura del lenguaje.

Puede ser simplemente una composición de **funciones que reciben lambdas**.

---

# 12. Relación futura con DSLs y Jetpack Compose

Esta característica es una de las razones por las que Kotlin puede construir APIs con aspecto declarativo.

Más adelante, al trabajar con Android y Jetpack Compose, aparecerán construcciones como:

```kotlin
Column {
    Text("Hola")
}
```

No necesitamos estudiar Compose ahora.

Lo importante es guardar una idea:

> Cuando más adelante veas una función seguida por `{ ... }`, no asumas inmediatamente que es una estructura especial del lenguaje. Pregúntate si esa función está recibiendo una lambda como último argumento.

Eso permitirá que la sintaxis de Compose resulte mucho menos misteriosa cuando corresponda estudiarla.

---

# 13. Entonces, ¿por qué `filter` tiene llaves en Kotlin?

Respuesta completa:

1. `filter` es una función.
2. recibe como argumento otra función que decide qué elementos conservar;
3. esa función se expresa como una lambda `{ ... }`;
4. la lambda es el último argumento de `filter`;
5. Kotlin permite mover el último argumento lambda fuera de los paréntesis;
6. al quedar los paréntesis vacíos, pueden omitirse.

Por eso:

```kotlin
notas.filter({ nota -> nota >= 4.0 })
```

puede escribirse:

```kotlin
notas.filter { nota -> nota >= 4.0 }
```

Y después:

```kotlin
notas.filter { it >= 4.0 }
```

---

# 14. Micropráctica

Dada esta función:

```kotlin
fun anunciar(mensaje: String, accion: () -> Unit) {
    println(mensaje)
    accion()
}
```

## Parte A

Ejecuta:

```kotlin
anunciar("Inicio", {
    println("Ejecutando acción")
})
```

## Parte B

Transforma la llamada usando trailing lambda:

```kotlin
anunciar("Inicio") {
    println("Ejecutando acción")
}
```

## Parte C

Responde:

- ¿qué pertenece a `anunciar(...)`?;
- ¿qué parte es la lambda?;
- ¿por qué la lambda puede quedar fuera?;
- ¿podríamos hacer lo mismo si no fuera el último argumento?

---

# 15. Idea para conservar

No memorices:

```text
filter usa llaves
```

Comprende:

```text
filter recibe una lambda
        ↓
la lambda se escribe con { }
        ↓
es el último argumento
        ↓
Kotlin permite trailing lambda
        ↓
los paréntesis vacíos pueden omitirse
```

Esa explicación sirve no solo para `filter`, sino también para una gran cantidad de código Kotlin que aparecerá durante el curso.