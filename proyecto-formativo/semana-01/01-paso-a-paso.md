# Semana 01 · Paso a paso

## Datos
```kotlin
var idRegistro = 1
var tituloRegistro = "Practicar Kotlin"
var categoriaRegistro = "estudio"
var registroCompletado = false
```

## Estado
```kotlin
fun estadoTexto(completado: Boolean): String =
    if (completado) "COMPLETADO" else "PENDIENTE"
```

## Mostrar
```kotlin
fun mostrarRegistro(id: Int, titulo: String, categoria: String, completado: Boolean) {
    println("$id · $titulo · $categoria · ${estadoTexto(completado)}")
}
```

## Null safety
```kotlin
val notaIngresada: String? = null
val notaVisible = notaIngresada ?: "Sin nota"
```

## Completar
La función devuelve el nuevo `Boolean` porque todavía no existen objetos.

Verificar salida PENDIENTE → COMPLETADO y comparar con el checkpoint sólo al final.
