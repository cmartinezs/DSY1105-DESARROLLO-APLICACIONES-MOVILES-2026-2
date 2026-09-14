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
    println(
        """
        |=== PocketLog v0.4 ===
        |1. Registrar
        |2. Listar todos
        |3. Buscar por id
        |4. Completar por id
        |5. Filtrar por categoría
        |6. Mostrar pendientes
        |7. Mostrar completados
        |8. Estadísticas
        |0. Salir
        """.trimMargin()
    )
}

fun leerTextoNoVacio(etiqueta: String): String {
    while (true) {
        print("$etiqueta: ")
        val valor = readln().trim()
        if (valor.isNotEmpty()) return valor
        println("El valor no puede quedar vacío.")
    }
}

fun leerEntero(etiqueta: String): Int? {
    print("$etiqueta: ")
    return readln().trim().toIntOrNull()
}

fun listar(registros: List<Registro>) {
    if (registros.isEmpty()) println("No hay registros para mostrar.")
    else registros.forEach { println(it.resumen()) }
}

fun buscar(registros: List<Registro>, id: Int): Registro? = registros.find { it.id == id }

fun main() {
    val registros = mutableListOf<Registro>()
    var siguienteId = 1
    var ejecutando = true

    while (ejecutando) {
        mostrarMenu()
        when (leerEntero("Opción")) {
            1 -> {
                val titulo = leerTextoNoVacio("Título")
                val categoria = leerTextoNoVacio("Categoría")
                registros.add(Registro(siguienteId, titulo, categoria))
                println("Registro $siguienteId creado.")
                siguienteId++
            }
            2 -> listar(registros)
            3 -> {
                val id = leerEntero("ID")
                if (id == null) println("ID inválido.")
                else println(buscar(registros, id)?.resumen() ?: "No existe el registro $id.")
            }
            4 -> {
                val id = leerEntero("ID")
                if (id == null) println("ID inválido.")
                else {
                    val registro = buscar(registros, id)
                    when {
                        registro == null -> println("No existe el registro $id.")
                        registro.completar() -> println("Registro $id completado.")
                        else -> println("El registro $id ya estaba completado.")
                    }
                }
            }
            5 -> {
                val categoria = leerTextoNoVacio("Categoría")
                listar(registros.filter { it.categoria.equals(categoria, ignoreCase = true) })
            }
            6 -> listar(registros.filter { !it.estaCompletado() })
            7 -> listar(registros.filter { it.estaCompletado() })
            8 -> {
                val completados = registros.count { it.estaCompletado() }
                val pendientes = registros.size - completados
                println("Total: ${registros.size}")
                println("Pendientes: $pendientes")
                println("Completados: $completados")
            }
            0 -> ejecutando = false
            null -> println("Ingrese una opción numérica.")
            else -> println("Opción fuera de rango.")
        }
        println()
    }

    println("PocketLog finalizado.")
}
