# Qué es realmente una lambda

Una lambda es una función que puede tratarse como un valor y pasarse a otra función.

## Desde una función normal

```kotlin
fun esPositivo(numero: Int): Boolean {
    return numero > 0
}
```

Podemos representar una lógica equivalente como lambda:

```kotlin
val esPositivo = { numero: Int -> numero > 0 }
```

La estructura general es:

```text
{ parámetros -> expresión o bloque }
```

## Cuando una función recibe otra función

Operaciones como `filter` reciben comportamiento.

```kotlin
val positivos = numeros.filter({ numero -> numero > 0 })
```

La lambda responde la pregunta que `filter` necesita hacer para cada elemento:

> ¿Este elemento debe permanecer en la colección?

Por eso la lambda retorna `true` o `false`.

## No confundir llaves con un bloque cualquiera

En este contexto:

```kotlin
{ numero -> numero > 0 }
```

las llaves delimitan una **lambda**, no simplemente un bloque `if` o el cuerpo tradicional de una función.

## Idea para recordar

```text
función normal → tiene nombre declarado
lambda         → comportamiento que podemos escribir y pasar como valor
```

Esta idea será especialmente importante más adelante en APIs de Kotlin y Android/Compose, donde muchas funciones reciben lambdas.
