package pocketlog

fun mostrarRegistros(
    titulos: List<String>,
    categorias: List<String>,
    completados: List<Boolean>
) {
    for (indice in titulos.indices) {
        val estado = if (completados[indice]) "COMPLETADO" else "PENDIENTE"
        println("${indice + 1}. ${titulos[indice]} · ${categorias[indice]} · $estado")
    }
}

fun filtrarTitulosPorCategoria(
    titulos: List<String>,
    categorias: List<String>,
    categoriaBuscada: String
): List<String> =
    titulos.filterIndexed { indice, _ ->
        categorias[indice].equals(categoriaBuscada, ignoreCase = true)
    }

fun titulosPendientes(
    titulos: List<String>,
    completados: List<Boolean>
): List<String> =
    titulos.filterIndexed { indice, _ -> !completados[indice] }

fun main() {
    val titulos = mutableListOf(
        "Revisar guía Kotlin",
        "Comprar alimento",
        "Practicar colecciones"
    )

    val categorias = mutableListOf(
        "estudio",
        "personal",
        "estudio"
    )

    val completados = mutableListOf(
        false,
        true,
        false
    )

    println("=== PocketLog · checkpoint Semana 02 ===")

    println("\nTodos los registros:")
    mostrarRegistros(titulos, categorias, completados)

    println("\nRegistros de estudio:")
    filtrarTitulosPorCategoria(titulos, categorias, "estudio")
        .forEach { println("- $it") }

    println("\nTítulos pendientes:")
    titulosPendientes(titulos, completados)
        .forEach { println("- $it") }

    val pendientes = completados.count { !it }
    val mensaje = when {
        pendientes == 0 -> "No quedan pendientes"
        pendientes == 1 -> "Queda 1 pendiente"
        else -> "Quedan $pendientes pendientes"
    }

    println("\nResumen: $mensaje")

    println("\nPregunta para la próxima semana:")
    println("¿Qué problema aparece al mantener título, categoría y estado en listas separadas?")
}
