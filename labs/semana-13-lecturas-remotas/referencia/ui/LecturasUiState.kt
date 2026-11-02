package cl.duoc.lecturasremotas.ui

import cl.duoc.lecturasremotas.data.PublicacionDto

sealed interface LecturasUiState {
    data object Cargando : LecturasUiState
    data class Datos(val publicaciones: List<PublicacionDto>) : LecturasUiState
    data object Vacio : LecturasUiState
    data class Error(val mensaje: String) : LecturasUiState
}
