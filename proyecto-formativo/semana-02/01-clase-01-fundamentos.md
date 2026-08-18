# PocketLog · Semana 02 · Clase 01

**Sesión:** Lunes 17 de agosto  
**Foco:** Fundamentos de Kotlin  
**Duración docente disponible:** 3 bloques  
**Punto de partida:** [00-punto-de-partida.md](./00-punto-de-partida.md)

## Objetivo de la clase

Construir una primera versión de PocketLog usando solamente Kotlin básico y dejar una base funcional que pueda continuar en la siguiente clase.

Hoy nos interesa que el alumno pueda explicar cada línea antes de acortarla.

La progresión será:

```text
forma explícita
→ ejecutar
→ comprender
→ comparar
→ simplificar
```

---

# Ruta de la clase

| Etapa | Contenido | Qué cambia en PocketLog |
|---|---|---|
| 1 | variables y tipos | representamos un registro |
| 2 | `val` y `var` | decidimos qué puede cambiar |
| 3 | salida y String templates | mostramos el registro |
| 4 | `if` | traducimos Boolean a estado legible |
| 5 | más datos | aparece la necesidad de colección |
| 6 | `for` e índices | mostramos varios registros |
| 7 | función | dejamos de repetir lógica |

---

# Etapa 1 · Un solo registro

Escribe primero la forma explícita:

```kotlin
fun main() {
    val titulo: String = "Revisar guía Kotlin"
    val categoria: String = "estudio"
    val completado: Boolean = false

    println(titulo)
    println(categoria)
    println(completado)
}
```

## Antes de ejecutar

Predice:

1. ¿qué tres líneas aparecerán?;
2. ¿qué tipo tiene cada variable?;
3. ¿qué cambiaría si `completado` fuese `true`?

Ejecuta y comprueba.

## Ahora simplificamos

Kotlin puede inferir los tipos:

```kotlin
val titulo = "Revisar guía Kotlin"
val categoria = "estudio"
val completado = false
```

### Decisión

Durante la explicación inicial usaremos tipos explícitos cuando aporten claridad. Después permitiremos inferencia cuando el tipo sea evidente.

---

# Etapa 2 · `val` o `var`

Prueba:

```kotlin
val titulo = "Revisar guía Kotlin"
// titulo = "Otro título"
```

Luego cambia a:

```kotlin
var titulo = "Revisar guía Kotlin"
titulo = "Otro título"
```

## Pregunta

¿PocketLog necesita que `titulo` cambie ahora mismo?

Si no existe esa necesidad, preferimos `val`.

No porque `var` esté prohibido, sino porque `val` comunica una restricción útil.

---

# Etapa 3 · Mostrar un registro

Primero, concatenación:

```kotlin
println(titulo + " · " + categoria + " · " + completado)
```

Funciona, pero el Boolean no se lee muy bien para una persona.

Antes de resolver eso, cambia la concatenación por String template:

```kotlin
println("$titulo · $categoria · $completado")
```

## Compara

Ambas construyen texto.

La segunda reduce ruido, pero solo es útil si entiendes qué estaba haciendo la primera.

---

# Etapa 4 · Estado legible con `if`

Primero escribimos la versión larga:

```kotlin
var estado: String = ""

if (completado) {
    estado = "COMPLETADO"
} else {
    estado = "PENDIENTE"
}
```

Después imprimimos:

```kotlin
println("$titulo · $categoria · $estado")
```

## Refactor Kotlin

Cuando ya entendemos ambas ramas:

```kotlin
val estado: String = if (completado) {
    "COMPLETADO"
} else {
    "PENDIENTE"
}
```

Y finalmente, si sigue siendo legible:

```kotlin
val estado = if (completado) "COMPLETADO" else "PENDIENTE"
```

### Comprueba

Cambia `completado` entre `true` y `false` y verifica que las tres versiones puedan representar el mismo comportamiento.

---

# Etapa 5 · PocketLog necesita más de un registro

Podríamos hacer:

```kotlin
val titulo1 = "Revisar guía Kotlin"
val titulo2 = "Comprar alimento"
val titulo3 = "Practicar colecciones"
```

## Detente aquí

¿Qué ocurriría con veinte registros?

Esta es la necesidad que justifica introducir una colección.

Comencemos explícitamente:

```kotlin
val titulos: MutableList<String> = mutableListOf(
    "Revisar guía Kotlin",
    "Comprar alimento",
    "Practicar colecciones"
)
```

Por ahora necesitamos también categoría y estado:

```kotlin
val categorias: MutableList<String> = mutableListOf(
    "estudio",
    "personal",
    "estudio"
)

val completados: MutableList<Boolean> = mutableListOf(
    false,
    true,
    false
)
```

El índice conecta los datos:

```text
0 → Revisar guía Kotlin / estudio / false
1 → Comprar alimento / personal / true
2 → Practicar colecciones / estudio / false
```

> No declaramos que esta sea la mejor estructura posible. Es una estructura que podemos comprender y usar con el contenido disponible hoy.

---

# Etapa 6 · Mostrar todos los registros

Primero recorremos índices:

```kotlin
for (indice in titulos.indices) {
    var estado = ""

    if (completados[indice]) {
        estado = "COMPLETADO"
    } else {
        estado = "PENDIENTE"
    }

    println(
        (indice + 1) + ". " +
        titulos[indice] + " · " +
        categorias[indice] + " · " +
        estado
    )
}
```

No lo acortes todavía.

Antes debes explicar:

- qué contiene `indice`;
- por qué las tres listas usan el mismo índice;
- por qué mostramos `indice + 1`;
- por qué no accedemos con `indice + 1`.

## Refactor progresivo

Primero `if` como expresión:

```kotlin
val estado = if (completados[indice]) {
    "COMPLETADO"
} else {
    "PENDIENTE"
}
```

Después String template:

```kotlin
println("${indice + 1}. ${titulos[indice]} · ${categorias[indice]} · $estado")
```

El comportamiento debe seguir siendo el mismo.

---

# Etapa 7 · Extraer una función

Si queremos mostrar registros más de una vez, copiar el ciclo sería duplicar lógica.

Extraemos:

```kotlin
fun mostrarRegistros(
    titulos: List<String>,
    categorias: List<String>,
    completados: List<Boolean>
): Unit {
    for (indice in titulos.indices) {
        val estado = if (completados[indice]) {
            "COMPLETADO"
        } else {
            "PENDIENTE"
        }

        println("${indice + 1}. ${titulos[indice]} · ${categorias[indice]} · $estado")
    }
}
```

Luego mostramos que Kotlin permite omitir `: Unit`:

```kotlin
fun mostrarRegistros(
    titulos: List<String>,
    categorias: List<String>,
    completados: List<Boolean>
) {
    // ...
}
```

## Pregunta de diseño

¿Por qué la función recibe `List` y no `MutableList`?

Porque solo necesita leer.

Eso nos permite expresar mejor qué puede y qué no puede hacer esa función.

---

# Prueba tú · 10 minutos

Agrega un cuarto registro.

Debes modificar correctamente:

```text
titulos
categorias
completados
```

Luego ejecuta `mostrarRegistros(...)`.

### Antes de pedir ayuda

Comprueba:

- que las tres listas tengan el mismo tamaño;
- que el cuarto registro muestre su categoría correcta;
- que el estado coincida con el Boolean almacenado.

---

# Checkpoint de salida de la Clase 01

Al terminar hoy deberías tener algo capaz de:

```text
✓ almacenar varios títulos
✓ asociar categoría y estado por índice
✓ recorrerlos
✓ convertir Boolean a texto legible
✓ mostrar todos los registros
✓ encapsular el listado en una función
```

No importa si tu código todavía utiliza la versión más explícita.

**Primero debe ser comprensible y funcionar.**

---

# Qué dejamos para la siguiente clase

Todavía no sabemos responder elegantemente preguntas como:

```text
¿Cuántos están pendientes?
¿Cuáles son de estudio?
¿Cómo obtengo solo ciertos registros?
¿Cómo transformo una colección en otra información?
```

Eso será el punto de partida de la Clase 02.

➡️ Continúa después con [Clase 02 · Colecciones y funciones](./02-clase-02-colecciones.md).
