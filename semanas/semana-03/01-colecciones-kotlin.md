# 1 · Colecciones Kotlin · cierre pendiente

## De un dato a muchos datos

```kotlin
val categoria = "Estudio"
val categorias = listOf("Estudio", "Personal", "Trabajo")
```

`List` representa una colección ordenada de elementos. `listOf` crea una lista de solo lectura desde esa referencia.

```kotlin
val tareas = mutableListOf("Leer", "Practicar")
tareas.add("Registrar DevLog")
tareas.remove("Leer")
```

`MutableList` permite operaciones de modificación.

## Recorrer antes de abstraer

```kotlin
for (tarea in tareas) {
    println(tarea)
}

tareas.forEach { tarea ->
    println(tarea)
}
```

Primero se comprende el recorrido explícito; después se compara con operaciones declarativas.

## Filtrar, transformar y contar

```kotlin
val pendientes = listOf("POO", "Kotlin", "Android", "Git")

val largos = pendientes.filter { it.length > 4 }
val mayusculas = pendientes.map { it.uppercase() }
val cantidad = pendientes.count { it.startsWith("K") }
```

- `filter` conserva elementos que cumplen una condición.
- `map` transforma cada elemento y produce otra colección.
- `count` cuenta los que cumplen el predicado.

Estas operaciones no son tres trucos aislados: expresan **seleccionar, transformar y resumir** datos.

## Mini práctica

Con una lista de precios: muestra todos, filtra los mayores a 10.000, crea otra lista con IVA incorporado y cuenta cuántos son menores a 5.000. Primero resuelve al menos una operación con `for`; luego compárala con `filter/map/count`.

## Transferencia a PocketLog

Antes de POO, PocketLog puede representar múltiples registros mediante colecciones. Pero si título, categoría y completado quedan en tres listas separadas, aparece una fragilidad: el índice pasa a ser la única relación entre datos que conceptualmente pertenecen a una misma entrada. Ese problema será el puente natural hacia clases.

## Checkpoint

Debes poder explicar la diferencia entre `List` y `MutableList`, recorrer sin `forEach`, describir qué retorna `filter`, describir qué retorna `map` y justificar cuándo una colección sustituye múltiples variables individuales.