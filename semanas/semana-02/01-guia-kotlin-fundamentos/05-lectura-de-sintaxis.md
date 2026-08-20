# Cómo leer Kotlin cuando la sintaxis se acorta

Uno de los problemas habituales al comenzar con Kotlin es que una construcción parece cambiar demasiado entre su forma explícita y su forma idiomática.

La estrategia de esta asignatura es leer siempre desde la forma más visible hacia la más compacta.

## Ejemplo · función

Forma explícita:

```kotlin
fun esMayor(edad: Int): Boolean {
    return edad >= 18
}
```

Forma compacta:

```kotlin
fun esMayor(edad: Int) = edad >= 18
```

Para leer la segunda, reconstruye mentalmente:

```text
fun            → función
esMayor        → nombre
edad: Int      → parámetro
=              → el cuerpo es una expresión
edad >= 18     → valor producido por la función
```

## Ejemplo · `if` como valor

```kotlin
val estado = if (nota >= 4.0) "Aprobado" else "Reprobado"
```

No lo leas como una sintaxis nueva desconectada del `if` tradicional. Léelo así:

1. se evalúa la condición;
2. una de las ramas produce un valor;
3. ese valor se asigna a `estado`.

## Método recomendado

Cuando una línea Kotlin parezca demasiado compacta:

1. identifica nombres y tipos;
2. busca la expresión principal;
3. reescríbela mentalmente o en código con llaves y `return`;
4. verifica que ambas formas expresen la misma lógica;
5. vuelve a la versión compacta.

La sintaxis corta deja de ser "magia" cuando puedes expandirla.
