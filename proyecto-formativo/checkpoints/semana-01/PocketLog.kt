package pocketlog

fun estadoTexto(completado: Boolean): String {
    return if (completado) "COMPLETADO" else "PENDIENTE"
}

fun mostrarRegistro(
    id: Int,
    titulo: String,
    categoria: String,
    completado: Boolean,
    nota: String?
) {
    val notaVisible = nota ?: "Sin nota"
    println("$id · $titulo · $categoria · ${estadoTexto(completado)} · $notaVisible")
}

fun completarRegistro(completadoActual: Boolean): Boolean {
    if (completadoActual) {
        println("El registro ya estaba completado.")
        return completadoActual
    }
    return true
}

fun main() {
    val idRegistro = 1
    val tituloRegistro = "Practicar Kotlin"
    val categoriaRegistro = "estudio"
    var registroCompletado = false
    val notaRegistro: String? = null

    println("=== PocketLog v0.1 ===")
    mostrarRegistro(idRegistro, tituloRegistro, categoriaRegistro, registroCompletado, notaRegistro)

    registroCompletado = completarRegistro(registroCompletado)

    println("\nDespués de completar:")
    mostrarRegistro(idRegistro, tituloRegistro, categoriaRegistro, registroCompletado, notaRegistro)
}
