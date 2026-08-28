class Tarea(val titulo: String) {
    fun resumen() = "Tarea: $titulo"
}

fun main() {
    val tarea = Tarea("Repasar Kotlin")
    println(tarea.resumen())
}
