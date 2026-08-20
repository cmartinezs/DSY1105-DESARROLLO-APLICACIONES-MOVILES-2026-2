# Errores frecuentes al leer lambdas

## 1. Pensar que `{ ... }` siempre es un bloque tradicional

En una llamada como:

```kotlin
numeros.filter { it > 0 }
```

las llaves contienen una lambda que se pasa como argumento a `filter`.

## 2. Creer que `filter { ... }` es una sintaxis completamente distinta

Es una forma idiomática de una llamada equivalente a:

```kotlin
filter({ ... })
```

La trailing lambda no cambia qué función se invoca.

## 3. No saber de dónde viene `it`

`it` es el nombre implícito del único parámetro de una lambda cuando no declaramos un nombre explícito.

## 4. Usar `it` incluso cuando empeora la lectura

```kotlin
usuarios.filter { usuario -> usuario.activo && usuario.edad >= 18 }
```

puede comunicar mejor intención que una expresión larga basada únicamente en `it`.

## 5. Memorizar la forma corta sin poder expandirla

Si no entiendes:

```kotlin
numeros.filter { it % 2 == 0 }
```

expándela:

```kotlin
numeros.filter({ numero: Int ->
    numero % 2 == 0
})
```

Poder pasar de una forma a otra es una buena comprobación de comprensión.

## 6. Confundir `filter` con la lambda

`filter` es la función de colección. La lambda es el criterio que le entregamos. Son dos piezas distintas que colaboran.
