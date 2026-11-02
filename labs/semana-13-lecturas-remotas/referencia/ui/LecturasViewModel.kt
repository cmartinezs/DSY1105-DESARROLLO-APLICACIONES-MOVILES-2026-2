package cl.duoc.lecturasremotas.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.duoc.lecturasremotas.data.PublicacionesRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class LecturasViewModel : ViewModel() {
    private val repositorio = PublicacionesRepository()
    private val _estado = MutableStateFlow<LecturasUiState>(LecturasUiState.Cargando)
    val estado = _estado.asStateFlow()
    private var carga: Job? = null

    init { cargar() }

    fun cargar(usuario: Int = 1) {
        if (carga?.isActive == true) return
        carga = viewModelScope.launch {
            _estado.value = LecturasUiState.Cargando
            try {
                val datos = repositorio.listar(usuario)
                _estado.value = if (datos.isEmpty()) LecturasUiState.Vacio
                    else LecturasUiState.Datos(datos)
            } catch (e: CancellationException) {
                throw e
            } catch (e: HttpException) {
                _estado.value = LecturasUiState.Error("El servicio respondió HTTP ${e.code()}.")
            } catch (e: IOException) {
                _estado.value = LecturasUiState.Error("No pudimos conectarnos. Revisa la conexión e intenta otra vez.")
            } catch (e: Exception) {
                _estado.value = LecturasUiState.Error("No pudimos interpretar la respuesta del servicio.")
            }
        }
    }
}
