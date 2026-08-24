# Ejercicios básicos · Semana 1

**Propósito:** practicar de forma breve los conceptos introductorios de la semana antes del laboratorio.

> Estos ejercicios pertenecen a la vertical de contenido semanal. No forman parte de PocketLog ni del proyecto formativo transversal.

## Cómo trabajar

- Resuelve cada ejercicio en un archivo separado.
- Ejecuta después de cada cambio pequeño.
- No copies una solución completa antes de intentar resolverlo.
- Cuando el ejercicio pida Java y Kotlin, compara el comportamiento, no solo la cantidad de líneas.

---

## Ejercicio 1 · ¿Qué es cada cosa?

Clasifica cada elemento como **plataforma**, **lenguaje**, **framework/toolkit**, **IDE** o **tipo de aplicación**:

- Android
- Kotlin
- Flutter
- Android Studio
- PWA
- iOS
- Swift
- React Native

### Criterio de logro

Debes poder justificar verbalmente al menos cuatro clasificaciones.

---

## Ejercicio 2 · Primer programa equivalente

Crea un programa muy pequeño en Java y luego otro en Kotlin que muestre:

```text
Hola DSY1105
Estoy aprendiendo Kotlin
```

### Observa

- función de entrada;
- punto y coma;
- forma de imprimir;
- cantidad de sintaxis obligatoria.

---

## Ejercicio 3 · Variables básicas

Representa los siguientes datos primero en Java y luego en Kotlin:

- nombre de aplicación: `MiPrimeraApp`;
- versión: `1`;
- tamaño en MB: `42.5`;
- publicada: `false`.

Muestra todos los datos por consola.

En Kotlin:

- utiliza `val` cuando el dato no cambie;
- utiliza inferencia cuando el tipo resulte evidente;
- utiliza String templates para imprimir.

---

## Ejercicio 4 · `val` versus `var`

En Kotlin crea:

```text
nombreUsuario = "Ana"
puntos = 10
```

El nombre no debe cambiar. Los puntos deben aumentar a `15`.

### Pregunta

¿Cuál variable debe ser `val` y cuál debe ser `var`? Explica por qué.

---

## Ejercicio 5 · Decisión simple

Declara un porcentaje de batería con valor `35`.

Muestra:

- `Batería baja` si es menor a `20`;
- `Batería disponible` en caso contrario.

Resuélvelo primero en Java y luego en Kotlin.

---

## Ejercicio 6 · Función pequeña

Crea una función que reciba un nombre y retorne:

```text
Bienvenido/a, <nombre>
```

Haz una versión Java y una versión Kotlin.

### En Kotlin

Intenta usar una función con retorno explícito y luego una versión como expresión si ya comprendes la primera.

---

## Ejercicio 7 · Nullable y Elvis

Solo en Kotlin:

```kotlin
val alias: String? = null
```

Muestra el alias si existe. Si no existe, muestra:

```text
Sin alias
```

Debes utilizar `?:`.

Luego cambia el valor a `"coder01"` y vuelve a ejecutar.

---

## Desafío breve

Crea un programa Kotlin con los datos de una app ficticia y una función que indique si está lista para publicar según una variable booleana `pruebasSuperadas`.

No agregues colecciones, clases ni conceptos de semanas posteriores.

## Cierre

Antes de pasar al laboratorio deberías poder explicar:

1. diferencia entre `val` y `var`;
2. qué significa inferencia de tipos;
3. qué resuelve `String?`;
4. qué hace `?:`;
5. dos diferencias visibles entre una solución Java y su equivalente Kotlin.
