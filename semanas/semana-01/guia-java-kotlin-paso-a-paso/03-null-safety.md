# Null-safety · por qué Kotlin distingue tipos nullable

En Java, una referencia puede contener `null` y muchas veces el compilador no puede impedir que luego intentemos usarla.

Kotlin hace explícita esa posibilidad en el tipo.

```kotlin
val sitioWeb: String = "https://ejemplo.cl"
val sitioWebOpcional: String? = null
```

`String` y `String?` no significan lo mismo.

## Acceso seguro

```kotlin
println(sitioWebOpcional?.length)
```

El operador `?.` indica: ejecuta la operación solo si el valor no es `null`.

## Valor por defecto

```kotlin
val longitud = sitioWebOpcional?.length ?: 0
```

El operador Elvis `?:` permite definir un valor alternativo.

## Evitar `!!` como reflejo

```kotlin
val longitud = sitioWebOpcional!!.length
```

`!!` fuerza a Kotlin a tratar el valor como no nulo. Si realmente es `null`, se producirá una excepción. Por eso no debe usarse simplemente para “hacer callar al compilador”.

## Idea para recordar

```text
String  → este valor no debería ser null
String? → este valor puede ser null
?.      → acceso seguro
?:      → alternativa si es null
!!      → afirmación riesgosa de no-null
```

La ventaja principal no es una sintaxis nueva: es convertir muchos errores potenciales de ejecución en decisiones visibles durante el desarrollo.
