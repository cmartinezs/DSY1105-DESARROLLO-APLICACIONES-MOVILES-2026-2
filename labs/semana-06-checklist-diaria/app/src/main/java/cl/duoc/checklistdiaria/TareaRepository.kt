package cl.duoc.checklistdiaria

class TareaRepository {
    private val tareas = mutableListOf<Tarea>()
    private var siguienteId = 1

    fun listar(): List<Tarea> = tareas.toList()

    fun agregar(titulo: String) {
        tareas += Tarea(id = siguienteId++, titulo = titulo)
    }

    fun alternar(id: Int) {
        val indice = tareas.indexOfFirst { it.id == id }
        if (indice >= 0) {
            val actual = tareas[indice]
            tareas[indice] = actual.copy(completada = !actual.completada)
        }
    }
}
