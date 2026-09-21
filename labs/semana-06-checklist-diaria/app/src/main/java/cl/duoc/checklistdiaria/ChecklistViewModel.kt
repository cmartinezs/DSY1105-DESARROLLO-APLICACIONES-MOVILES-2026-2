package cl.duoc.checklistdiaria

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ChecklistUiState(
    val titulo: String = "",
    val tareas: List<Tarea> = emptyList(),
    val mensaje: String? = null,
    val total: Int = 0,
    val completadas: Int = 0
)

class ChecklistViewModel(
    private val repository: TareaRepository = TareaRepository()
) : ViewModel() {
    private val _uiState = MutableStateFlow(ChecklistUiState())
    val uiState: StateFlow<ChecklistUiState> = _uiState.asStateFlow()

    fun cambiarTitulo(valor: String) {
        _uiState.value = _uiState.value.copy(titulo = valor, mensaje = null)
    }

    fun agregar() {
        val titulo = _uiState.value.titulo.trim()
        if (titulo.isEmpty()) {
            _uiState.value = _uiState.value.copy(mensaje = "Escribe una tarea antes de agregar.")
            return
        }
        repository.agregar(titulo)
        _uiState.value = _uiState.value.copy(titulo = "", mensaje = null)
        refrescar()
    }

    fun alternar(id: Int) {
        repository.alternar(id)
        refrescar()
    }

    private fun refrescar() {
        val tareas = repository.listar()
        _uiState.value = _uiState.value.copy(
            tareas = tareas,
            total = tareas.size,
            completadas = tareas.count { it.completada }
        )
    }
}
