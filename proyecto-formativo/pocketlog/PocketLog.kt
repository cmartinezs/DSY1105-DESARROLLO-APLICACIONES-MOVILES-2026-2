package pocketlog

data class Registro(
    val id: Int,
    val titulo: String,
    val categoria: String,
    val completado: Boolean = false
) {
    fun completar(): Registro = copy(completado = true)

    fun resumen(): String {
        val estado = if (completado) "COMPLETADO" else "PENDIENTE"
        return "$id. $titulo · $categoria · $estado"
    }
}

sealed class ResultadoOperacion {
    data class Exito(val mensaje: String) : ResultadoOperacion()
    data class Error(val mensaje: String) : ResultadoOperacion()
}

fun mostrarRegistros(registros: List<Registro>) {
    registros.forEach { println(it.resumen()) }
}

fun filtrarPorCategoria(
    registros: List<Registro>,
    categoriaBuscada: String
): List<Registro> =
    registros.filter { it.categoria.equals(categoriaBuscada, ignoreCase = true) }

fun obtenerPendientes(registros: List<Registro>): List<Registro> =
    registros.filter { !it.completado }

fun completarPorId(
    registros: MutableList<Registro>,
    id: Int
): ResultadoOperacion {
    val indice = registros.indexOfFirst { it.id == id }

    if (indice == -1) {
        return ResultadoOperacion.Error("No existe un registro con id $id")
    }

    registros[indice] = registros[indice].completar()
    return ResultadoOperacion.Exito("Registro $id marcado como completado")
}

fun buscarPorId(
    registros: List<Registro>,
    id: Int
): Registro? = registros.find { it.id == id }

// Semana 3 introduce el concepto de suspensión. Esta función es deliberadamente
// simple: permite discutir `suspend` sin adelantar Android, red ni persistencia.
suspend fun obtenerCantidadSimulada(registros: List<Registro>): Int = registros.size

fun main() {
    val registros = mutableListOf(
        Registro(1, "Revisar guía Kotlin", "estudio"),
        Registro(2, "Comprar alimento", "personal", completado = true),
        Registro(3, "Practicar POO", "estudio")
    )

    println("=== PocketLog · versión objetivo Semana 03 ===")

    println("\nTodos los registros:")
    mostrarRegistros(registros)

    println("\nRegistros de estudio:")
    filtrarPorCategoria(registros, "estudio")
        .forEach { println("- ${it.titulo}") }

    println("\nPendientes:")
    obtenerPendientes(registros)
        .forEach { println("- ${it.titulo}") }

    println("\nCompletar registro 3:")
    when (val resultado = completarPorId(registros, 3)) {
        is ResultadoOperacion.Exito -> println(resultado.mensaje)
        is ResultadoOperacion.Error -> println("Error: ${resultado.mensaje}")
    }

    println("\nIntentar completar registro inexistente:")
    when (val resultado = completarPorId(registros, 99)) {
        is ResultadoOperacion.Exito -> println(resultado.mensaje)
        is ResultadoOperacion.Error -> println("Error: ${resultado.mensaje}")
    }

    val encontrados = buscarPorId(registros, 2)
    println("\nBúsqueda por id 2: ${encontrados?.resumen() ?: "sin resultado"}")

    val pendientes = obtenerPendientes(registros).count()
    println("\nResumen: quedan $pendientes registros pendientes")
}
