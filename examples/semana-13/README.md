# Ejemplo focalizado · Leer un contrato Retrofit

Objetivo: relacionar una URL con la declaración Kotlin. Es un fragmento didáctico, no un proyecto ejecutable independiente.

```kotlin
import retrofit2.http.GET
import retrofit2.http.Query

data class PublicacionDto(val userId: Int, val id: Int, val title: String, val body: String)

interface PublicacionesApi {
    @GET("posts")
    suspend fun listar(@Query("userId") usuario: Int): List<PublicacionDto>
}
```

Con URL base `https://jsonplaceholder.typicode.com/`, `listar(1)` solicita `/posts?userId=1`. El convertidor Gson interpreta el JSON. La función se invoca desde una corrutina; no desde el cuerpo de un Composable.

Predice: ¿qué parte cambia si el filtro pasa de 1 a 2? ¿Qué representa `List<PublicacionDto>`? Comprueba con la [lectura base](../../semanas/semana-13/01-http-rest-json.md) y construye la aplicación en el [laboratorio guiado](../../labs/semana-13-lecturas-remotas/README.md).
