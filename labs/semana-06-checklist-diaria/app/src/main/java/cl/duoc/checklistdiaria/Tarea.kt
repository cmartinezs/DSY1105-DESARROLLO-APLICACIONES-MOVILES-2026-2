package cl.duoc.checklistdiaria

data class Tarea(
    val id: Int,
    val titulo: String,
    val completada: Boolean = false
)
