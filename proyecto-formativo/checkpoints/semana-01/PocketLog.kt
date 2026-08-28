package pocketlog

fun mostrarRegistro(
    id: Int,
    titulo: String,
    categoria: String,
    completado: Boolean
) {
    val estado = if (completado) "COMPLETADO" else "PENDIENTE"
    println("$id. $titulo · $categoria · $estado")
}

fun cambiarEstado(actual: Boolean): Boolean = !actual

fun coincideCategoria(categoria: String, buscada: String): Boolean =
    categoria.equals(buscada, ignoreCase = true)

fun main() {
    val idRegistro = 1
    val tituloRegistro = "Revisar panorama móvil"
    val categoriaRegistro = "estudio"
    var registroCompletado = false

    println("=== PocketLog · Semana 01 ===")
    mostrarRegistro(idRegistro, tituloRegistro, categoriaRegistro, registroCompletado)

    println("\n¿Es de estudio? ${coincideCategoria(categoriaRegistro, "estudio")}")

    registroCompletado = cambiarEstado(registroCompletado)
    println("\nDespués de cambiar estado:")
    mostrarRegistro(idRegistro, tituloRegistro, categoriaRegistro, registroCompletado)

    println("\nProblema abierto:")
    println("¿Qué pasará cuando PocketLog necesite manejar muchos registros relacionados?")
}
