package cl.duoc.misnotasroom.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.duoc.misnotasroom.data.AppDatabase
import cl.duoc.misnotasroom.data.Nota
import kotlinx.coroutines.launch

class NotasViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).notaDao()

    val notas = dao.obtenerTodas()

    fun guardar(texto: String) {
        if (texto.isBlank()) return
        viewModelScope.launch {
            dao.insertar(Nota(texto = texto.trim()))
        }
    }

    fun modificar(nota: Nota, nuevoTexto: String) {
        if (nuevoTexto.isBlank()) return
        viewModelScope.launch {
            dao.actualizar(nota.copy(texto = nuevoTexto.trim()))
        }
    }

    fun borrar(nota: Nota) {
        viewModelScope.launch {
            dao.eliminar(nota)
        }
    }
}
