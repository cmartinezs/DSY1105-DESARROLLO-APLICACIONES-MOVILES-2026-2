package cl.duoc.pocketlog.domain

data class Registro(
    val id: Int,
    val titulo: String,
    val categoria: String,
    val completado: Boolean = false
)
