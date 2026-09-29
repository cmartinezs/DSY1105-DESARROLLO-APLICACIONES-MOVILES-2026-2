package cl.duoc.registrousuario.viewmodel

import androidx.lifecycle.ViewModel
import cl.duoc.registrousuario.model.UsuarioErrores
import cl.duoc.registrousuario.model.UsuarioUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UsuarioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UsuarioUiState())
    val uiState: StateFlow<UsuarioUiState> = _uiState.asStateFlow()

    fun onNombreChange(valor: String) {
        _uiState.update { estado ->
            estado.copy(
                nombre = valor,
                errores = estado.errores.copy(nombre = null)
            )
        }
    }

    fun onCorreoChange(valor: String) {
        _uiState.update { estado ->
            estado.copy(
                correo = valor,
                errores = estado.errores.copy(correo = null)
            )
        }
    }

    fun onClaveChange(valor: String) {
        _uiState.update { estado ->
            estado.copy(
                clave = valor,
                errores = estado.errores.copy(clave = null)
            )
        }
    }

    fun onDireccionChange(valor: String) {
        _uiState.update { estado ->
            estado.copy(
                direccion = valor,
                errores = estado.errores.copy(direccion = null)
            )
        }
    }

    fun onAceptaTerminosChange(valor: Boolean) {
        _uiState.update { estado ->
            estado.copy(
                aceptaTerminos = valor,
                errores = estado.errores.copy(terminos = null)
            )
        }
    }

    fun validarFormulario(): Boolean {
        val estado = _uiState.value

        val nombreError =
            if (estado.nombre.trim().length < 3)
                "El nombre debe tener al menos 3 caracteres"
            else null

        val correoError =
            if (
                !estado.correo.contains("@") ||
                !estado.correo.substringAfter("@", "").contains(".")
            )
                "Ingresa un correo válido"
            else null

        val claveError =
            if (estado.clave.length < 6)
                "La clave debe tener al menos 6 caracteres"
            else null

        val direccionError =
            if (estado.direccion.trim().length < 5)
                "Ingresa una dirección válida"
            else null

        val terminosError =
            if (!estado.aceptaTerminos)
                "Debes aceptar los términos"
            else null

        val errores = UsuarioErrores(
            nombre = nombreError,
            correo = correoError,
            clave = claveError,
            direccion = direccionError,
            terminos = terminosError
        )

        _uiState.update {
            it.copy(errores = errores)
        }

        return listOf(
            nombreError,
            correoError,
            claveError,
            direccionError,
            terminosError
        ).all { it == null }
    }
}
