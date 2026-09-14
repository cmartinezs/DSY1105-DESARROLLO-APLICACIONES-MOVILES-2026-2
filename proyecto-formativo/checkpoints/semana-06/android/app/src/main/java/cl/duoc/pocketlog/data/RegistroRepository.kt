package cl.duoc.pocketlog.data

import cl.duoc.pocketlog.domain.Registro

class RegistroRepository {
    private val registros = mutableListOf(
        Registro(1, "Revisar Kotlin", "estudio"),
        Registro(2, "Comprar alimento", "personal", completado = true),
        Registro(3, "Practicar Compose", "estudio")
    )
    private var siguienteId = 4

    fun obtenerTodos(): List<Registro> = registros.toList()

    fun agregar(titulo: String, categoria: String) {
        registros.add(
            Registro(
                id = siguienteId++,
                titulo = titulo.trim(),
                categoria = categoria.trim()
            )
        )
    }

    fun completar(id: Int): Boolean {
        val indice = registros.indexOfFirst { it.id == id }
        if (indice == -1) return false

        val actual = registros[indice]
        if (actual.completado) return false

        registros[indice] = actual.copy(completado = true)
        return true
    }
}
