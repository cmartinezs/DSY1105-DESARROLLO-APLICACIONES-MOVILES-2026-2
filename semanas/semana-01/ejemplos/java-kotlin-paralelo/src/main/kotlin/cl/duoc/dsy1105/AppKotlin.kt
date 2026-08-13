package cl.duoc.dsy1105

fun main() {

    val nombre = "MichiApp"
    val plataforma = "Android"
    val descargas = 1500
    val puntuacion = 4.7
    val sitioWeb: String? = null

    println("=== INFORMACIÓN DE LA APP ===")
    println("Nombre: $nombre")
    println("Plataforma: $plataforma")
    println("Descargas: $descargas")
    println("Puntuación: $puntuacion")

    val estado = obtenerEstado(descargas)
    println("Estado: $estado")

    val sitio = sitioWeb ?: "No disponible"
    println("Sitio web: $sitio")
}

fun obtenerEstado(descargas: Int): String =
    if (descargas >= 1000) {
        "Popular"
    } else {
        "En crecimiento"
    }
