# Guía paso a paso · De Java a Kotlin sin partir de cero

Esta guía acompaña el ejemplo práctico de la clase del **jueves 13 de agosto de 2026**.

← [Volver a Semana 01](./README.md)  
➡️ [Abrir ejemplo Java → Kotlin](./ejemplo-java-kotlin/README.md)  
➡️ [Ir al laboratorio de 15 minutos](./laboratorio-java-kotlin/README.md)

## ¿Qué vamos a aprender?

La idea central es simple: **los conceptos de programación que ya conoces no desaparecen al cambiar de Java a Kotlin**. Lo que cambia principalmente es la forma de escribirlos.

Durante la guía veremos el mismo problema en ambos lenguajes y explicaremos cada diferencia con ejemplos pequeños.

El programa representa información básica de una aplicación móvil:

- nombre;
- plataforma;
- cantidad de descargas;
- puntuación;
- sitio web opcional;
- estado de popularidad.

---

## 1. Una variable sigue siendo una variable

En Java estamos acostumbrados a escribir primero el tipo:

```java
String nombre = "MichiApp";
int descargas = 1500;
double puntuacion = 4.7;
```

En Kotlin podemos escribir:

```kotlin
val nombre = "MichiApp"
val descargas = 1500
val puntuacion = 4.7
```

### ¿Dónde quedaron `String`, `int` y `double`?

Kotlin puede mirar el valor asignado y deducir su tipo:

- `"MichiApp"` → `String`;
- `1500` → `Int`;
- `4.7` → `Double`.

A esto se le llama **inferencia de tipos**.

El tipo sigue existiendo. Si queremos escribirlo explícitamente, podemos hacerlo:

```kotlin
val nombre: String = "MichiApp"
val descargas: Int = 1500
val puntuacion: Double = 4.7
```

### Regla para recordar

En Java:

```text
TIPO nombre
```

En Kotlin:

```text
nombre: TIPO
```

---

## 2. `val` y `var`: ¿puede cambiar el valor?

Java permite reasignar una variable normalmente:

```java
int descargas = 1500;
descargas = 2000;
```

En Kotlin debemos decidir si queremos permitir esa reasignación.

### `val`

```kotlin
val nombre = "MichiApp"
```

Usamos `val` cuando la referencia **no será reasignada**.

Esto no compila:

```kotlin
val nombre = "MichiApp"
nombre = "OtraApp"
```

### `var`

```kotlin
var descargas = 1500
descargas = 2000
```

Usamos `var` cuando necesitamos cambiar posteriormente el valor.

### Recomendación inicial

Usa `val` por defecto y cambia a `var` solamente cuando realmente necesites reasignar la variable.

---

## 3. Mostrar datos por consola

Java:

```java
System.out.println("Aplicación: " + nombre);
System.out.println("Descargas: " + descargas);
```

Kotlin:

```kotlin
println("Aplicación: $nombre")
println("Descargas: $descargas")
```

Kotlin permite insertar una variable directamente dentro de un `String`. Esto se llama **String template**.

Si necesitamos ejecutar una expresión:

```kotlin
println("Después de una campaña: ${descargas + 500}")
```

Los `{ }` indican que dentro hay una expresión que debe evaluarse.

---

## 4. Los `if` son casi iguales

Java:

```java
if (descargas >= 1000) {
    System.out.println("Popular");
} else {
    System.out.println("En crecimiento");
}
```

Kotlin:

```kotlin
if (descargas >= 1000) {
    println("Popular")
} else {
    println("En crecimiento")
}
```

Aquí el concepto prácticamente no cambia:

1. evaluamos una condición;
2. si es verdadera ejecutamos un bloque;
3. si es falsa ejecutamos otro.

Lo importante es reconocer que **cambiar de lenguaje no significa volver a aprender qué es un condicional**.

---

## 5. De método Java a función Kotlin

En Java podemos crear:

```java
public static String obtenerEstado(int descargas) {
    if (descargas >= 1000) {
        return "Popular";
    }

    return "En crecimiento";
}
```

En Kotlin:

```kotlin
fun obtenerEstado(descargas: Int): String {
    if (descargas >= 1000) {
        return "Popular"
    }

    return "En crecimiento"
}
```

Leamos la cabecera Kotlin por partes:

```kotlin
fun obtenerEstado(descargas: Int): String
```

- `fun` → estamos declarando una función;
- `obtenerEstado` → nombre de la función;
- `descargas: Int` → parámetro llamado `descargas` de tipo `Int`;
- `: String` → la función retorna un `String`.

### Un detalle interesante de Kotlin

En Kotlin un `if` puede producir un valor:

```kotlin
fun obtenerEstado(descargas: Int): String {
    return if (descargas >= 1000) {
        "Popular"
    } else {
        "En crecimiento"
    }
}
```

No necesitamos aprender esto de memoria todavía. Lo importante es entender **por qué funciona**: el `if` selecciona uno de dos valores y ese valor se retorna.

---

## 6. `null`: aquí sí aparece una diferencia importante

Supongamos que una aplicación puede no tener sitio web.

En Java podemos hacer:

```java
String sitioWeb = null;
```

El problema es que posteriormente podríamos intentar usarlo sin comprobar si es `null`.

Kotlin obliga a distinguir entre dos situaciones.

### Un `String` que NO acepta `null`

```kotlin
val sitioWeb: String = "https://michiapp.cl"
```

Esto no compila:

```kotlin
val sitioWeb: String = null
```

### Un `String` que SÍ puede contener `null`

```kotlin
val sitioWeb: String? = null
```

El signo `?` es importante:

```text
String   → debe contener un String
String?  → puede contener un String o null
```

---

## 7. ¿Qué hacemos con un valor nullable?

Podemos tratarlo con un `if`:

```kotlin
if (sitioWeb != null) {
    println("Sitio: $sitioWeb")
} else {
    println("Sitio: No disponible")
}
```

Pero Kotlin también ofrece herramientas específicas.

### Operador Elvis `?:`

```kotlin
val sitio = sitioWeb ?: "No disponible"
```

Se lee de forma práctica como:

> usa `sitioWeb`; si es `null`, usa `"No disponible"`.

Luego:

```kotlin
println("Sitio: $sitio")
```

---

## 8. Armemos el programa completo

Ahora podemos relacionar todo:

1. declaramos datos de la aplicación;
2. mostramos información;
3. enviamos las descargas a una función;
4. usamos un condicional para obtener el estado;
5. tratamos correctamente un sitio web opcional.

El resultado final está disponible en:

- [`AppJava.java`](./ejemplo-java-kotlin/src/main/java/cl/duoc/dsy1105/AppJava.java)
- [`AppKotlin.kt`](./ejemplo-java-kotlin/src/main/kotlin/cl/duoc/dsy1105/AppKotlin.kt)

La recomendación es **no copiar ambos archivos inmediatamente**. Construye primero Java y después escribe la equivalencia Kotlin al lado.

---

## 9. Tabla de traducción rápida

| Concepto | Java | Kotlin |
|---|---|---|
| Variable de texto | `String nombre = "App";` | `val nombre = "App"` |
| Entero | `int cantidad = 10;` | `val cantidad = 10` |
| Variable reasignable | `int cantidad = 10;` | `var cantidad = 10` |
| Imprimir | `System.out.println(...)` | `println(...)` |
| Concatenación | `"Hola " + nombre` | `"Hola $nombre"` |
| Función/método | `static String metodo(int x)` | `fun funcion(x: Int): String` |
| Nullable | `String sitio = null;` | `val sitio: String? = null` |
| Valor alternativo a null | `if (sitio != null)` | `sitio ?: "Sin sitio"` |

---

## 10. Antes de pasar al laboratorio

Deberías poder responder:

1. ¿Por qué Kotlin puede omitir algunos tipos al declarar variables?
2. ¿Cuándo usarías `val` y cuándo `var`?
3. ¿Qué reemplaza normalmente a una concatenación simple en Kotlin?
4. ¿Cómo se declara un parámetro de tipo `Int` en una función Kotlin?
5. ¿Qué diferencia existe entre `String` y `String?`?
6. ¿Qué hace el operador `?:`?

Si estas ideas están claras, continúa con el [laboratorio Java → Kotlin](./laboratorio-java-kotlin/README.md).
