package pocketlog

data class RegistroBasico(
    val id: Int,
    val titulo: String,
    val categoria: String,
    val completado: Boolean
)

fun filtrarPorCategoria(registros: List<RegistroBasico>, categoria: String): List<RegistroBasico> =
    registros.filter { it.categoria.equals(categoria, ignoreCase = true) }

fun titulosPendientes(registros: List<RegistroBasico>): List<String> =
    registros
        .filter { !it.completado }
        .map { it.titulo }

fun main() {
    val registros = mutableListOf(
        RegistroBasico(1, "Revisar guía Kotlin", "estudio", false),
        RegistroBasico(2, "Comprar alimento", "personal", true),
        RegistroBasico(3, "Practicar colecciones", "estudio", false)
    )

    println("=== PocketLog · checkpoint Semana 02 ===")

    println("\nTodos los registros:")
    for (registro in registros) {
        val estado = if (registro.completado) "COMPLETADO" else "PENDIENTE"
        println("${registro.id}. ${registro.titulo} · ${registro.categoria} · $estado")
    }

    println("\nRegistros de estudio:")
    filtrarPorCategoria(registros, "estudio")
        .forEach { println("- ${it.titulo}") }

    println("\nTítulos pendientes:")
    titulosPendientes(registros)
        .forEach { println("- $it") }

    val pendientes = registros.count { !it.completado }
    val mensaje = when {
        pendientes == 0 -> "No quedan pendientes"
        pendientes == 1 -> "Queda 1 pendiente"
        else -> "Quedan $pendientes pendientes"
    }

    println("\nResumen: $mensaje")
}
