package pocketlog

class Registro(
    val id: Int,
    var titulo: String,
    var categoria: String,
    var completado: Boolean = false
) {
    fun completar() {
        completado = true
    }

    fun resumen(): String {
        val estado = if (completado) "COMPLETADO" else "PENDIENTE"
        return "$id · $titulo · $categoria · $estado"
    }
}

fun leerTextoNoVacio(etiqueta: String): String {
    while (true) {
        print("$etiqueta: ")
        val valor = readln().trim()
        if (valor.isNotEmpty()) return valor
        println("El valor no puede quedar vacío.")
    }
}

fun registrar(registros: MutableList<Registro>, siguienteId: Int): Int {
    val titulo = leerTextoNoVacio("Título")
    val categoria = leerTextoNoVacio("Categoría")
    registros.add(Registro(siguienteId, titulo, categoria))
    println("Registro $siguienteId creado.")
    return siguienteId + 1
}

fun listar(registros: List<Registro>) {
    if (registros.isEmpty()) {
        println("No hay registros.")
        return
    }
    for (registro in registros) println(registro.resumen())
}

fun buscarPorId(registros: List<Registro>, id: Int): Registro? = registros.find { it.id == id }

fun completarPorId(registros: List<Registro>, id: Int) {
    val registro = buscarPorId(registros, id)
    if (registro == null) {
        println("No existe un registro con id $id.")
        return
    }
    registro.completar()
    println("Registro $id completado.")
}

fun filtrarCategoria(registros: List<Registro>, categoria: String): List<Registro> =
    registros.filter { it.categoria.equals(categoria, ignoreCase = true) }

fun pendientes(registros: List<Registro>): List<Registro> = registros.filter { !it.completado }

fun registrarDemo(registros: MutableList<Registro>, id: Int, titulo: String, categoria: String): Int {
    registros.add(Registro(id, titulo, categoria))
    return id + 1
}

fun main() {
    val registros = mutableListOf<Registro>()
    var siguienteId = 1

    siguienteId = registrarDemo(registros, siguienteId, "Practicar colecciones", "estudio")
    siguienteId = registrarDemo(registros, siguienteId, "Comprar alimento", "personal")
    registrarDemo(registros, siguienteId, "Practicar POO", "estudio")

    println("=== PocketLog v0.3 ===")
    println("\nTodos:")
    listar(registros)

    println("\nEstudio:")
    listar(filtrarCategoria(registros, "estudio"))

    println("\nCompletar id 3:")
    completarPorId(registros, 3)

    println("\nPendientes:")
    listar(pendientes(registros))

    println("\nConteos:")
    println("Total: ${registros.size}")
    println("Pendientes: ${registros.count { !it.completado }}")
    println("Completados: ${registros.count { it.completado }}")

    println("\nBúsqueda id 2:")
    println(buscarPorId(registros, 2)?.resumen() ?: "Sin resultado")
}
