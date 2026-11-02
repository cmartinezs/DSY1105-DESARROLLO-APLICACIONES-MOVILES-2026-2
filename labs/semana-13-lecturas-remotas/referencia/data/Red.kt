package cl.duoc.lecturasremotas.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Red {
    private val cliente = OkHttpClient.Builder()
        .callTimeout(20, TimeUnit.SECONDS)
        .build()
    val api: PublicacionesApi = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .client(cliente)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PublicacionesApi::class.java)
}
