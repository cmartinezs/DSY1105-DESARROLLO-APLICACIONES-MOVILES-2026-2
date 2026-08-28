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

fun obtenerPendientes(registros: List<Registro>): List<Registro> =
    registros.filter { !it.completado }

fun completarPorId(registros: MutableList<Registro>, id: Int): ResultadoOperacion {
    val indice = registros.indexOfFirst { it.id == id }
    if (indice == -1) return ResultadoOperacion.Error("No existe un registro con id $id")
    registros[indice] = registros[indice].completar()
    return ResultadoOperacion.Exito("Registro $id marcado como completado")
}

suspend fun obtenerCantidadSimulada(registros: List<Registro>): Int = registros.size

fun main() {
    val registros = mutableListOf(
        Registro(1, "Revisar guía Kotlin", "estudio"),
        Registro(2, "Comprar alimento", "personal", true),
        Registro(3, "Practicar POO", "estudio")
    )

    registros.forEach { println(it.resumen()) }

    when (val resultado = completarPorId(registros, 3)) {
        is ResultadoOperacion.Exito -> println(resultado.mensaje)
        is ResultadoOperacion.Error -> println("Error: ${resultado.mensaje}")
    }

    println("Pendientes: ${obtenerPendientes(registros).count()}")
}
