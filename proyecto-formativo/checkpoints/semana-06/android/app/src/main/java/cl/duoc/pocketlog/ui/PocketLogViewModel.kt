package cl.duoc.pocketlog.ui

import androidx.lifecycle.ViewModel
import cl.duoc.pocketlog.data.RegistroRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PocketLogViewModel(
    private val repository: RegistroRepository = RegistroRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(PocketLogUiState())
    val uiState: StateFlow<PocketLogUiState> = _uiState.asStateFlow()

    init {
        refrescar()
    }

    fun cambiarTitulo(valor: String) {
        _uiState.update { it.copy(titulo = valor, mensaje = null) }
    }

    fun cambiarCategoria(valor: String) {
        _uiState.update { it.copy(categoria = valor, mensaje = null) }
    }

    fun cambiarFiltro(filtro: FiltroEstado) {
        _uiState.update { it.copy(filtro = filtro) }
        refrescar()
    }

    fun agregarRegistro() {
        val estado = _uiState.value
        val titulo = estado.titulo.trim()
        val categoria = estado.categoria.trim()

        if (titulo.isEmpty() || categoria.isEmpty()) {
            _uiState.update { it.copy(mensaje = "Título y categoría son obligatorios.") }
            return
        }

        repository.agregar(titulo, categoria)
        _uiState.update { it.copy(titulo = "", categoria = "", mensaje = "Registro agregado.") }
        refrescar(conservarMensaje = true)
    }

    fun completarRegistro(id: Int) {
        val cambiado = repository.completar(id)
        _uiState.update {
            it.copy(
                mensaje = if (cambiado) "Registro $id completado."
                else "No fue posible completar el registro $id."
            )
        }
        refrescar(conservarMensaje = true)
    }

    private fun refrescar(conservarMensaje: Boolean = false) {
        val todos = repository.obtenerTodos()
        val filtro = _uiState.value.filtro

        val visibles = when (filtro) {
            FiltroEstado.TODOS -> todos
            FiltroEstado.PENDIENTES -> todos.filter { !it.completado }
            FiltroEstado.COMPLETADOS -> todos.filter { it.completado }
        }

        val completados = todos.count { it.completado }

        _uiState.update {
            it.copy(
                registros = visibles,
                total = todos.size,
                pendientes = todos.size - completados,
                completados = completados,
                mensaje = if (conservarMensaje) it.mensaje else null
            )
        }
    }
}
