# Ejemplo práctico · Java → Kotlin

Este ejemplo corresponde a la clase del **jueves 13 de agosto de 2026** y permite comparar Java y Kotlin escribiendo el mismo programa en paralelo dentro de un único proyecto de IntelliJ IDEA.

← [Volver a Semana 01](../README.md)  
📘 [Leer primero la guía paso a paso](../guia-java-kotlin-paso-a-paso.md)  
🧪 [Después del ejemplo: laboratorio autónomo](../laboratorio-java-kotlin/README.md)

## Objetivo

Reconocer en Kotlin conceptos que ya son familiares desde Java, concentrándose en diferencias de sintaxis y en algunas características iniciales del lenguaje:

- declaración de variables;
- `val` y `var`;
- inferencia de tipos;
- String templates;
- condicionales;
- funciones;
- retorno de valores;
- introducción a null safety con `String?` y el operador Elvis `?:`.

> La finalidad no es aprender nuevamente a programar, sino reconocer cómo Kotlin expresa conceptos ya conocidos.

## Proyecto

El proyecto contiene ambos lenguajes dentro del mismo módulo Gradle:

```text
ejemplo-java-kotlin/
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

Los dos archivos implementan el mismo problema: mostrar información básica de una aplicación móvil y determinar su estado de acuerdo con su cantidad de descargas.

## Abrir en IntelliJ IDEA

1. Clona o actualiza el repositorio del curso.
2. En IntelliJ IDEA selecciona **File → Open**.
3. Abre la carpeta `semanas/semana-01/ejemplo-java-kotlin`.
4. IntelliJ detectará `build.gradle.kts` e importará el proyecto Gradle.
5. Espera que finalice la sincronización.
6. Abre simultáneamente:
   - `AppJava.java`;
   - `AppKotlin.kt`.
7. Utiliza **Split Right** en el editor para mantener Java a la izquierda y Kotlin a la derecha.

Ambos programas tienen su propio punto de entrada y pueden ejecutarse independientemente desde IntelliJ.

## Cómo usar este ejemplo en clase

No se recomienda comenzar mostrando el código terminado. La secuencia sugerida es:

1. escribir una pequeña parte en Java;
2. preguntar qué concepto se está utilizando;
3. implementar inmediatamente el equivalente en Kotlin;
4. ejecutar ambos;
5. identificar qué cambió en la sintaxis y qué concepto se mantuvo igual.

La explicación detallada de cada paso se encuentra en la [guía Java → Kotlin](../guia-java-kotlin-paso-a-paso.md).

## 1. Variables

### Java

```java
String nombre = "MichiApp";
String plataforma = "Android";
int descargas = 1500;
double puntuacion = 4.7;
```

### Kotlin

```kotlin
val nombre = "MichiApp"
val plataforma = "Android"
val descargas = 1500
val puntuacion = 4.7
```

Kotlin puede inferir el tipo a partir del valor asignado. También se puede declarar explícitamente:

```kotlin
val nombre: String = "MichiApp"
val descargas: Int = 1500
val puntuacion: Double = 4.7
```

## 2. `val` y `var`

```kotlin
val nombre = "MichiApp"
var descargas = 1500

descargas = descargas + 500
```

- `val`: la referencia no se reasigna.
- `var`: la variable puede recibir un nuevo valor.

Prueba modificar un `val` y observa el error que muestra IntelliJ.

## 3. Salida por consola

### Java

```java
System.out.println("Aplicación: " + nombre);
```

### Kotlin

```kotlin
println("Aplicación: $nombre")
```

Kotlin utiliza **String templates**, evitando concatenaciones simples.

## 4. Condicionales

Java y Kotlin mantienen una estructura muy similar:

### Java

```java
if (descargas >= 1000) {
    System.out.println("La aplicación es popular");
} else {
    System.out.println("La aplicación todavía está creciendo");
}
```

### Kotlin

```kotlin
if (descargas >= 1000) {
    println("La aplicación es popular")
} else {
    println("La aplicación todavía está creciendo")
}
```

## 5. Métodos y funciones

### Java

```java
public static String obtenerEstado(int descargas) {
    if (descargas >= 1000) {
        return "Popular";
    }
    return "En crecimiento";
}
```

### Kotlin

```kotlin
fun obtenerEstado(descargas: Int): String {
    return if (descargas >= 1000) {
        "Popular"
    } else {
        "En crecimiento"
    }
}
```

Observa el orden del parámetro:

```text
Java:   String nombre
Kotlin: nombre: String
```

Además, en Kotlin un `if` puede producir un valor.

## 6. Introducción a null safety

En Java una referencia puede contener `null`:

```java
String sitioWeb = null;
```

En Kotlin esto no es válido:

```kotlin
val sitioWeb: String = null // no compila
```

Si realmente necesitamos permitir `null`, debemos declararlo explícitamente:

```kotlin
val sitioWeb: String? = null
```

Luego podemos proporcionar un valor alternativo usando `?:`:

```kotlin
val sitio = sitioWeb ?: "No disponible"
println("Sitio web: $sitio")
```

El compilador conoce qué variables pueden contener `null` y obliga a tratar ese caso explícitamente.

## Secuencia sugerida durante la demostración

| Paso | Java | Kotlin |
|---|---|---|
| 1 | variables y tipos | `val`, tipos e inferencia |
| 2 | concatenación | String templates |
| 3 | variable modificable | `var` |
| 4 | `if/else` | `if/else` |
| 5 | método | función |
| 6 | referencia nullable | `String?` y `?:` |

## Preguntas de comprobación

1. ¿Qué elementos de Java desaparecen o se simplifican en Kotlin?
2. ¿Qué diferencia existe entre `val` y `var`?
3. ¿Qué ventaja tiene que el compilador distinga entre `String` y `String?`?
4. ¿Qué conceptos siguen siendo exactamente los mismos aunque cambie la sintaxis?

## Siguiente paso

Cuando el ejemplo esté claro, no continúes modificándolo como ejercicio. Pasa a un problema nuevo para comprobar que puedes aplicar los conceptos sin copiar la solución:

🧪 [**Laboratorio · Control de batería Java → Kotlin**](../laboratorio-java-kotlin/README.md)

El laboratorio está diseñado para tomar aproximadamente **15 minutos** y debe resolverse primero en Java y después en Kotlin.
