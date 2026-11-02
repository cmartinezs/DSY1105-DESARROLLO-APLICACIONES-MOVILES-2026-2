# Laboratorio Semana 13 · LecturasRemotas

## Propósito, alcance y resultado
Construir una aplicación pequeña e independiente que consulte publicaciones de una API REST y muestre carga, datos, vacío, error y reintento. Practica HTTP/JSON, Retrofit y MVVM; no resuelve PocketLog ni el proyecto VcM. No implementa login, backend propio, almacenamiento local ni escrituras remotas.

Flujo: evento de pantalla → ViewModel → repositorio → Retrofit → HTTP/JSON → DTO → estado → Compose.

Prerrequisitos: Kotlin, Compose, ViewModel y StateFlow. Android Studio con SDK instalado, emulador/dispositivo y acceso a internet. Partimos desde una plantilla ejecutable, sin exigir adivinar archivos de configuración.

## 1. Crear y comprobar la base
En Android Studio elige **New Project → Empty Activity** (Compose), nombre `LecturasRemotas`, package `cl.duoc.lecturasremotas`, lenguaje Kotlin y mínimo API 26. Conserva las versiones compatibles de Android/Gradle/Kotlin/Compose generadas por tu instalación. Ejecuta antes de cambiar nada.

**Checkpoint 1:** abre la pantalla inicial en emulador o dispositivo. Si falla aquí, resuelve la instalación/SDK antes de agregar red.

La referencia usa ese package docente. Para una entrega propia aplica la raíz personal establecida por el curso y ajusta todos los imports de forma consistente.

## 2. Dependencias y permiso
En `app/build.gradle.kts`, dentro de `dependencies`, agrega:

```kotlin
implementation("com.squareup.retrofit2:retrofit:3.0.0")
implementation("com.squareup.retrofit2:converter-gson:3.0.0")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.10.0")
implementation("androidx.lifecycle:lifecycle-runtime-compose:2.10.0")
```

Son versiones fijadas para la referencia, no una indicación de actualizar todas las dependencias del proyecto. Si la plantilla ya declara Lifecycle mediante catálogo, conserva una sola declaración por módulo y alinea las tres versiones. Mantén Material3, Foundation y Activity Compose de la plantilla. OkHttp es dependencia transitiva de Retrofit y permite configurar el timeout.

En `app/src/main/AndroidManifest.xml`, dentro de `<manifest>` y antes de `<application>`, agrega:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

No se pide este permiso en tiempo de ejecución. Sincroniza Gradle y ejecuta.

**Checkpoint 2:** sincronización y ejecución sin errores; aún no hay consulta de red.

## 3. Leer el contrato
Abre `https://jsonplaceholder.typicode.com/posts?userId=1`. Reconoce la lista y sus campos `userId`, `id`, `title` y `body`. El servicio es de demostración; no enviar datos personales. Crea los packages `data` y `ui` debajo de `app/src/main/java/cl/duoc/lecturasremotas/`.

## 4. Crear DTO, servicio y repositorio
Crea los siguientes archivos en ese orden, dentro de la raíz del package. Cada bloque corresponde al contenido completo de su archivo.

### data/PublicacionDto.kt

```kotlin
package cl.duoc.lecturasremotas.data

data class PublicacionDto(val userId: Int, val id: Int, val title: String, val body: String)
```

### data/PublicacionesApi.kt

```kotlin
package cl.duoc.lecturasremotas.data

import retrofit2.http.GET
import retrofit2.http.Query

interface PublicacionesApi {
    @GET("posts")
    suspend fun listar(@Query("userId") usuario: Int): List<PublicacionDto>
}
```

### data/Red.kt

```kotlin
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
```

### data/PublicacionesRepository.kt

```kotlin
package cl.duoc.lecturasremotas.data

class PublicacionesRepository(private val api: PublicacionesApi = Red.api) {
    suspend fun listar(usuario: Int): List<PublicacionDto> = api.listar(usuario)
}
```

El DTO representa el JSON. La interfaz declara la consulta. `Red` configura una sola instancia del cliente, URL HTTPS con `/` final, conversión Gson y límite total de 20 segundos por llamada. El repositorio aísla el acceso remoto del ViewModel.

**Checkpoint 3:** usa Build → Make Project. Si faltan imports revisa las dependencias; todavía no invoques la red desde Compose.

## 5. Representar estado y cargar desde el ViewModel

### ui/LecturasUiState.kt

```kotlin
package cl.duoc.lecturasremotas.ui

import cl.duoc.lecturasremotas.data.PublicacionDto

sealed interface LecturasUiState {
    data object Cargando : LecturasUiState
    data class Datos(val publicaciones: List<PublicacionDto>) : LecturasUiState
    data object Vacio : LecturasUiState
    data class Error(val mensaje: String) : LecturasUiState
}
```

### ui/LecturasViewModel.kt

```kotlin
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
```

`init` inicia una carga por instancia de ViewModel. `viewModelScope` controla su ciclo de vida; `asStateFlow` evita que la UI modifique el estado. La lista vacía tiene estado propio; los errores salen de carga y permiten reintentar. La cancelación se propaga y la guarda de `Job` evita cargas simultáneas.

**Checkpoint 4:** compila. Ubica dónde se transforma la lista en estado y explica por qué el repositorio no decide textos de la pantalla.

## 6. Dibujar estado y conectar eventos

### ui/LecturasScreen.kt

```kotlin
package cl.duoc.lecturasremotas.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LecturasScreen(estado: LecturasUiState, onCargar: (Int) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Lecturas remotas", style = MaterialTheme.typography.headlineSmall)
        Button(onClick = { onCargar(1) }, enabled = estado !is LecturasUiState.Cargando) {
            Text("Consultar / reintentar")
        }
        Button(onClick = { onCargar(999999) }, enabled = estado !is LecturasUiState.Cargando) {
            Text("Consultar usuario sin publicaciones")
        }
        when (estado) {
            LecturasUiState.Cargando -> {
                CircularProgressIndicator()
                Text("Cargando publicaciones…")
            }
            LecturasUiState.Vacio -> Text("No hay publicaciones para este usuario.")
            is LecturasUiState.Error -> Text(estado.mensaje)
            is LecturasUiState.Datos -> LazyColumn(
                contentPadding = PaddingValues(bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(estado.publicaciones, key = { it.id }) { publicacion ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(publicacion.title, style = MaterialTheme.typography.titleMedium)
                            Text(publicacion.body)
                        }
                    }
                }
            }
        }
    }
}
```

### MainActivity.kt

```kotlin
package cl.duoc.lecturasremotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cl.duoc.lecturasremotas.ui.LecturasScreen
import cl.duoc.lecturasremotas.ui.LecturasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm: LecturasViewModel = viewModel()
            val estado by vm.estado.collectAsStateWithLifecycle()
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
                    LecturasScreen(estado = estado, onCargar = { vm.cargar(it) })
                }
            }
        }
    }
}
```

Reemplaza el contenido de `MainActivity.kt` generado por la plantilla; elimina sus funciones de demostración si quedan sin uso. La UI solo recibe estado y callbacks. El ViewModel se obtiene con `viewModel()` para conservarlo ante rotación. La observación respeta el ciclo de vida y no vuelve a iniciar una consulta por cada recomposición.

**Checkpoint 5:** ejecuta. Se ve carga y luego publicaciones. El segundo botón consulta un usuario sin datos; el primero vuelve a usuario 1.

## 7. Pruebas manuales
| Caso | Acción | Resultado esperado |
|---|---|---|
| Éxito | Abrir con conexión | Lista con título y cuerpo |
| Vacío | Segundo botón | Mensaje sin publicaciones; no error |
| Red | Desactivar Wi-Fi/datos en el emulador/dispositivo y consultar | Error tras fallar la conexión o agotarse timeout; sin carga infinita |
| Recuperación | Restaurar conexión y pulsar reintentar | Lista visible |
| HTTP | Cambiar temporalmente `@GET("posts")` por una ruta inexistente y recompilar | Mensaje HTTP 404; restaurar ruta al terminar |
| Rotación | Rotar tras completar la consulta | Estado conservado por ViewModel |
| Pulsación rápida | Repetir consulta | Sin solicitudes superpuestas |

## 8. Explicar el flujo completo
Al abrir, el ViewModel consulta al repositorio. Retrofit construye GET, OkHttp realiza la comunicación y Gson convierte JSON a DTO. El ViewModel publica un estado y Compose lo representa. Los botones envían un nuevo evento; no contienen lógica HTTP.

## Dificultades frecuentes
- **No resuelve Retrofit/Lifecycle:** sincronizar Gradle, revisar repositorios y conexión de descarga; no mezclar versiones duplicadas del catálogo.
- **URL base inválida:** debe terminar en `/`.
- **Permiso denegado:** revisar INTERNET fuera de application y reinstalar/ejecutar.
- **No conecta:** verificar internet del emulador además del computador; no deshabilitar TLS para “solucionarlo”.
- **Vista previa no carga red:** la comprobación se hace en emulador/dispositivo; Preview no sustituye ejecución.

## DevLog y Definition of Done
- [ ] Base creada desde cero y app ejecutada.
- [ ] Consulta real y lectura del JSON explicables.
- [ ] Carga, lista, vacío, error y reintento comprobados.
- [ ] Red fuera de la pantalla; estado en ViewModel.
- [ ] Evidencia de éxito y error y explicación del recorrido del dato.
- [ ] Cambios de prueba restaurados y commit descriptivo publicado.

La carpeta [referencia](referencia/) contiene los mismos archivos Kotlin para comparar al terminar. Es un conjunto de fuentes para la plantilla configurada en pasos 1–2, **no un proyecto Gradle autónomo**. Esta entrega editorial no acredita que la app haya sido compilada en un SDK Android; ejecuta los checkpoints en el laboratorio.

Extensión opcional: mostrar el filtro elegido en pantalla. No agregues autenticación o CRUD antes de comprender este flujo.

Fuentes primarias: [Android y red](https://developer.android.com/develop/connectivity/network-ops/connecting), [Retrofit](https://lysine.dev/retrofit/), [JSONPlaceholder](https://jsonplaceholder.typicode.com/).
