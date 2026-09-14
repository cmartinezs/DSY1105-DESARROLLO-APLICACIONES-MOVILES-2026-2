package pocketlog

fun estadoTexto(completado: Boolean): String =
    if (completado) "COMPLETADO" else "PENDIENTE"

fun mostrarMenu() {
    println(
        """
        |=== PocketLog v0.2 ===
        |1. Registrar/reemplazar registro
        |2. Mostrar registro
        |3. Completar registro
        |4. Consultar estado
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

fun mostrarRegistro(id: Int, titulo: String, categoria: String, completado: Boolean) {
    println("$id · $titulo · $categoria · ${estadoTexto(completado)}")
}

fun main() {
    var idRegistro = 0
    var tituloRegistro = ""
    var categoriaRegistro = ""
    var registroCompletado = false
    var existeRegistro = false
    var siguienteId = 1
    var ejecutando = true

    while (ejecutando) {
        mostrarMenu()
        print("Opción: ")

        when (readln().toIntOrNull()) {
            1 -> {
                tituloRegistro = leerTextoNoVacio("Título")
                categoriaRegistro = leerTextoNoVacio("Categoría")
                idRegistro = siguienteId
                siguienteId++
                registroCompletado = false
                existeRegistro = true
                println("Registro creado con id $idRegistro.")
            }
            2 -> if (existeRegistro) {
                mostrarRegistro(idRegistro, tituloRegistro, categoriaRegistro, registroCompletado)
            } else println("Aún no existe un registro.")
            3 -> {
                if (!existeRegistro) println("No hay un registro para completar.")
                else if (registroCompletado) println("El registro ya está completado.")
                else {
                    registroCompletado = true
                    println("Registro completado.")
                }
            }
            4 -> if (existeRegistro) println("Estado: ${estadoTexto(registroCompletado)}") else println("Aún no existe un registro.")
            0 -> ejecutando = false
            else -> println("Opción inválida.")
        }
        println()
    }

    println("PocketLog finalizado.")
}
