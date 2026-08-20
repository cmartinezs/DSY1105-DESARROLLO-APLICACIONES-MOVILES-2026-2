# Paréntesis, llaves y trailing lambda

Esta es una de las dudas más comunes cuando se empieza a leer Kotlin:

```kotlin
numeros.filter({ numero -> numero > 0 })
```

frente a:

```kotlin
numeros.filter { numero -> numero > 0 }
```

Ambas expresiones representan la misma idea.

## Paso 1 · llamada tradicional

Si una función recibe una lambda como argumento, podemos pasarla dentro de los paréntesis:

```kotlin
filter({ numero -> numero > 0 })
```

## Paso 2 · trailing lambda

Cuando el **último argumento** de una función es una lambda, Kotlin permite escribirla fuera de los paréntesis:

```kotlin
filter() { numero -> numero > 0 }
```

## Paso 3 · si no quedan otros argumentos

Si los paréntesis quedan vacíos, pueden omitirse:

```kotlin
filter { numero -> numero > 0 }
```

Por eso:

```text
filter({ ... })
      ↓
filter() { ... }
      ↓
filter { ... }
```

No son tres operaciones distintas. Es una misma llamada escrita cada vez de manera más idiomática.

## Cuando hay otros parámetros

```kotlin
algo(parametro1, parametro2) { valor ->
    // lambda final
}
```

Los argumentos normales permanecen dentro de `(...)`; la lambda final puede desplazarse afuera.

## Regla para recordar

> Si el último parámetro esperado por una función es una lambda, Kotlin permite colocar esa lambda después de los paréntesis.

La finalidad es mejorar legibilidad, especialmente cuando la lambda contiene varias líneas.
