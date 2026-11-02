package cl.duoc.lecturasremotas.data

class PublicacionesRepository(private val api: PublicacionesApi = Red.api) {
    suspend fun listar(usuario: Int): List<PublicacionDto> = api.listar(usuario)
}
