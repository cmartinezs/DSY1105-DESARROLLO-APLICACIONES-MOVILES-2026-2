# Operadores y precedencia

Los operadores de Kotlin se parecen mucho a los de Java, pero conviene entender cómo se combinan.

## Aritméticos

```kotlin
+  -  *  /  %
```

Ejemplo:

```kotlin
val total = precio * cantidad
```

## Comparación

```kotlin
==  !=  >  <  >=  <=
```

```kotlin
val aprobado = nota >= 4.0
```

## Lógicos

```kotlin
&&  ||  !
```

```kotlin
val puedeIngresar = edad >= 18 && tieneEntrada
```

## Precedencia

Esta expresión:

```kotlin
val resultado = 2 + 3 * 4
```

produce `14`, porque `*` se evalúa antes que `+`.

Cuando la intención pueda resultar ambigua para quien lee, los paréntesis ayudan:

```kotlin
val resultado = (2 + 3) * 4
```

## Cortocircuito

En:

```kotlin
condicionA && condicionB
```

si `condicionA` es falsa, Kotlin no necesita evaluar `condicionB`.

En:

```kotlin
condicionA || condicionB
```

si `condicionA` es verdadera, tampoco necesita evaluar `condicionB`.

Esto importa cuando una segunda expresión depende de que la primera haya validado algo previamente.

## Recomendación

No memorices una tabla enorme de precedencia al inicio. Usa paréntesis cuando mejoren la lectura y aprende primero las combinaciones que aparecen realmente en tus programas.
