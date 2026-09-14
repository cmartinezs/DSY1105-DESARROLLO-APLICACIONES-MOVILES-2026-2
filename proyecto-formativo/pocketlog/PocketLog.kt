package pocketlog

class Registro(
    val id: Int,
    var titulo: String,
    var categoria: String,
    private var completado: Boolean = false
) {
    fun completar(): Boolean {
        if (completado) return false
        completado = true
        return true
    }
    fun estaCompletado(): Boolean = completado
    fun resumen(): String {
        val estado = if (completado) "COMPLETADO" else "PENDIENTE"
        return "$id · $titulo · $categoria · $estado"
    }
}

fun mostrarMenu() {
    println("1. Registrar\n2. Listar\n3. Buscar\n4. Completar\n5. Filtrar categoría\n6. Pendientes\n7. Completados\n8. Estadísticas\n0. Salir")
}

fun leerTextoNoVacio(etiqueta: String): String {
    while (true) {
        print("$etiqueta: ")
        val valor = readln().trim()
        if (valor.isNotEmpty()) return valor
        println("El valor no puede quedar vacío.")
    }
}

fun leerEntero(etiqueta: String): Int? { print("$etiqueta: "); return readln().trim().toIntOrNull() }
fun listar(registros: List<Registro>) { if (registros.isEmpty()) println("No hay registros.") else registros.forEach { println(it.resumen()) } }
fun buscar(registros: List<Registro>, id: Int): Registro? = registros.find { it.id == id }

fun main() {
    val registros = mutableListOf<Registro>()
    var siguienteId = 1
    var ejecutando = true
    while (ejecutando) {
        mostrarMenu()
        when (leerEntero("Opción")) {
            1 -> { registros.add(Registro(siguienteId, leerTextoNoVacio("Título"), leerTextoNoVacio("Categoría"))); siguienteId++ }
            2 -> listar(registros)
            3 -> leerEntero("ID")?.let { println(buscar(registros, it)?.resumen() ?: "No existe") }
            4 -> leerEntero("ID")?.let { id -> println(if (buscar(registros, id)?.completar() == true) "Completado" else "No fue posible") }
            5 -> listar(registros.filter { it.categoria.equals(leerTextoNoVacio("Categoría"), true) })
            6 -> listar(registros.filter { !it.estaCompletado() })
            7 -> listar(registros.filter { it.estaCompletado() })
            8 -> { val c = registros.count { it.estaCompletado() }; println("Total ${registros.size} · Pendientes ${registros.size-c} · Completados $c") }
            0 -> ejecutando = false
            else -> println("Opción inválida")
        }
    }
}
