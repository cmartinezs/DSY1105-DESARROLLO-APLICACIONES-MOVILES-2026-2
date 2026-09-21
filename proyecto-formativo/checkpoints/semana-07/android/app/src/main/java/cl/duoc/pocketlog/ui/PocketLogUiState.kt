package cl.duoc.pocketlog.ui

import cl.duoc.pocketlog.domain.Registro

enum class FiltroEstado {
    TODOS, PENDIENTES, COMPLETADOS
}

data class PocketLogUiState(
    val registros: List<Registro> = emptyList(),
    val titulo: String = "",
    val categoria: String = "",
    val filtro: FiltroEstado = FiltroEstado.TODOS,
    val mensaje: String? = null,
    val total: Int = 0,
    val pendientes: Int = 0,
    val completados: Int = 0
)
