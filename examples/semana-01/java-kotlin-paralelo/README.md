# Ejemplo práctico · Java ↔ Kotlin en paralelo

Este ejemplo está diseñado para trabajarse en la clase del **jueves 13 de agosto de 2026** como puente inicial entre Java y Kotlin.

La idea no es aprender programación nuevamente, sino reconocer cómo Kotlin expresa conceptos que ya conocemos desde Java.

## Objetivos

Al finalizar el ejemplo deberías poder reconocer equivalencias básicas entre Java y Kotlin en:

- declaración de variables;
- inferencia de tipos;
- `val` y `var`;
- salida por consola;
- interpolación de Strings;
- estructuras `if`;
- funciones con parámetros y retorno;
- manejo básico de valores nulos.

## Estructura

```text
java-kotlin-paralelo/
├── build.gradle.kts
├── settings.gradle.kts
└── src/
    └── main/
        ├── java/
        │   └── cl/duoc/dsy1105/
        │       └── AppJava.java
        └── kotlin/
            └── cl/duoc/dsy1105/
                └── AppKotlin.kt
```

Los dos programas pertenecen al mismo proyecto y resuelven el mismo problema.

## Abrir en IntelliJ IDEA

1. Abre IntelliJ IDEA.
2. Selecciona **Open**.
3. Abre la carpeta `java-kotlin-paralelo`.
4. Espera a que Gradle sincronice el proyecto.
5. Abre simultáneamente:
   - `AppJava.java`
   - `AppKotlin.kt`
6. Utiliza **Split Right** o **Split Down** para visualizar ambos archivos en paralelo.

Cada archivo tiene su propio `main`, por lo que puedes ejecutar ambas versiones de manera independiente.

## Problema

Tenemos una aplicación móvil llamada **MichiApp**. Del producto conocemos:

- nombre;
- plataforma;
- número de descargas;
- puntuación;
- sitio web opcional.

El programa muestra estos datos y determina si la aplicación se encuentra **En crecimiento** o es **Popular**.

## Comparación guiada

### 1. Variables

Java:

```java
String nombre = "MichiApp";
int descargas = 1500;
double puntuacion = 4.7;
```

Kotlin:

```kotlin
val nombre = "MichiApp"
val descargas = 1500
val puntuacion = 4.7
```

Kotlin puede inferir el tipo a partir del valor asignado.

También podemos declararlo explícitamente:

```kotlin
val nombre: String = "MichiApp"
val descargas: Int = 1500
val puntuacion: Double = 4.7
```

### 2. `val` y `var`

```kotlin
val nombre = "MichiApp"
var descargas = 1500
```

- `val`: la referencia no se reasigna.
- `var`: el valor puede cambiar durante la ejecución.

Ejemplo:

```kotlin
var descargas = 1500
descargas = descargas + 500
```

### 3. Strings

Java:

```java
System.out.println("Aplicación: " + nombre);
```

Kotlin:

```kotlin
println("Aplicación: $nombre")
```

Kotlin permite interpolar variables dentro de un String.

### 4. Condicionales

Java y Kotlin mantienen una estructura muy similar:

```java
if (descargas >= 1000) {
    System.out.println("Popular");
} else {
    System.out.println("En crecimiento");
}
```

```kotlin
if (descargas >= 1000) {
    println("Popular")
} else {
    println("En crecimiento")
}
```

En Kotlin, además, `if` puede producir un valor.

```kotlin
val estado = if (descargas >= 1000) {
    "Popular"
} else {
    "En crecimiento"
}
```

### 5. Funciones

Java:

```java
public static String obtenerEstado(int descargas) {
    if (descargas >= 1000) {
        return "Popular";
    }

    return "En crecimiento";
}
```

Kotlin:

```kotlin
fun obtenerEstado(descargas: Int): String =
    if (descargas >= 1000) {
        "Popular"
    } else {
        "En crecimiento"
    }
```

Observa especialmente el orden del parámetro:

```text
Java    → String nombre
Kotlin  → nombre: String
```

### 6. Null safety

En Java una referencia puede contener `null`:

```java
String sitioWeb = null;
```

En Kotlin esto no es válido:

```kotlin
val sitioWeb: String = null
```

Si queremos permitir `null`, debemos expresarlo en el tipo:

```kotlin
val sitioWeb: String? = null
```

Podemos proporcionar un valor alternativo utilizando el operador Elvis `?:`:

```kotlin
val sitio = sitioWeb ?: "No disponible"
```

También existe el operador de llamada segura `?.`:

```kotlin
println(sitioWeb?.uppercase())
```

## Orden sugerido para desarrollarlo en clase

No partir desde el código final. Construir las dos versiones progresivamente:

1. variables y tipos;
2. impresión por consola;
3. concatenación versus String templates;
4. `val` versus `var`;
5. `if`;
6. función `obtenerEstado`;
7. `null` en Java;
8. `String?`, `?.` y `?:` en Kotlin.

## Actividad breve

Modifica **ambos programas** agregando:

- `desarrollador`;
- `version`;
- `categoria`.

Luego modifica `obtenerEstado()` para utilizar tres estados:

| Descargas | Estado |
|---:|---|
| menos de 500 | Nueva |
| 500 a 999 | En crecimiento |
| 1000 o más | Popular |

### Restricción

La solución debe realizarse tanto en `AppJava.java` como en `AppKotlin.kt`, manteniendo el mismo comportamiento en ambos programas.

## Para esta primera clase no necesitamos todavía

No es necesario introducir todavía:

- clases Kotlin;
- `data class`;
- colecciones funcionales;
- lambdas;
- extension functions;
- corrutinas;
- APIs Android.

El objetivo es construir un puente claro entre Java y Kotlin antes de avanzar hacia desarrollo Android.
