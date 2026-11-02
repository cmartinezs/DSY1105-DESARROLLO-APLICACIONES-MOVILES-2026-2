package cl.duoc.lecturasremotas.data

import retrofit2.http.GET
import retrofit2.http.Query

interface PublicacionesApi {
    @GET("posts")
    suspend fun listar(@Query("userId") usuario: Int): List<PublicacionDto>
}
