# Laboratorio · Testea tu App Móvil

**DSY1105 · Semana 14 · Pruebas unitarias en aplicaciones móviles**

> El periodo de ejecución queda pendiente de confirmación institucional. Este laboratorio es material formativo y no crea una evaluación sumativa ni un plazo de entrega.

## 1. Propósito

Construir una pequeña suite de pruebas para una aplicación Kotlin + Jetpack Compose. Aprenderás a verificar una regla de negocio, probar un ViewModel con una dependencia controlada y automatizar una interacción visible de Compose.

Trabajarás en parejas. Cada integrante debe poder explicar una prueba, justificar su alcance y ejecutar la suite.

## 2. Resultado esperado

Al finalizar tendrás:

- pruebas locales para una regla de negocio;
- una prueba de ViewModel con un repositorio fake o mock;
- una prueba instrumentada de UI Compose;
- evidencia de ejecución y una breve reflexión sobre los casos cubiertos.

## 3. Prerrequisitos

- Android Studio y JDK configurados.
- Kotlin y Jetpack Compose.
- Funciones, clases, interfaces y manejo de errores.
- Conceptos de ViewModel y estado UI.
- Un emulador Android configurado para la parte instrumentada.

No necesitas backend ni conexión de red.

## 4. Proyecto de práctica

Crea un proyecto Compose vacío llamado `TesteaTuApp`. Conserva la configuración de Kotlin, Compose BOM y Android Gradle Plugin generada por Android Studio. No actualices versiones del proyecto para realizar este laboratorio.

Estructura conceptual:

```text
app/src/
├── main/java/.../
│   ├── domain/CalculadoraDescuento.kt
│   ├── data/DescuentosRepository.kt
│   ├── ui/DescuentoViewModel.kt
│   └── ui/DescuentoScreen.kt
├── test/java/.../
│   ├── domain/CalculadoraDescuentoTest.kt
│   └── ui/DescuentoViewModelTest.kt
└── androidTest/java/.../
    └── ui/DescuentoScreenTest.kt
```

Ajusta el package a tu repositorio personal: `cl.duoc.<usuario-duoc-sin-puntos>`.

## 5. Dependencias de prueba

En el archivo `app/build.gradle.kts`, conserva las versiones y alias que ya tenga tu proyecto. Verifica también que el módulo declare `androidx.test.runner.AndroidJUnitRunner` como runner de instrumentación. Añade las dependencias equivalentes a:

```kotlin
dependencies {
    // Pruebas locales JVM
    testImplementation("junit:junit:<version-compatible>")
    testImplementation("io.mockk:mockk:<version-compatible>")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:<version-compatible>")

    // Pruebas instrumentadas Compose
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:<compose-version>")
    debugImplementation("androidx.compose.ui:ui-test-manifest:<compose-version>")
}
```

Los marcadores `<...>` no son versiones literales: reemplázalos por versiones compatibles con el proyecto o utiliza los alias del Version Catalog. Si Compose BOM ya administra la versión de Compose, evita fijar otra versión manualmente.

Sincroniza Gradle antes de continuar.

**Checkpoint 1:** el proyecto sincroniza y compila sin errores. Todavía no agregues bibliotecas que no utilices.

## 6. Paso 1 · Crear una regla de negocio

Archivo: `domain/CalculadoraDescuento.kt`.

```kotlin
package cl.duoc.usuario.domain

fun calcularTotal(precio: Int, descuentoPorcentaje: Int): Int {
    require(precio >= 0) { "El precio no puede ser negativo" }
    require(descuentoPorcentaje in 0..100) {
        "El descuento debe estar entre 0 y 100"
    }
    return precio - (precio * descuentoPorcentaje / 100)
}
```

Cambia `cl.duoc.usuario` por tu package real.

La función no depende de Android, por lo que puede probarse en la JVM local. No necesita Activity, Context ni emulador.

**Checkpoint 2:** ejecuta la app o compila el módulo y comprueba que la función está disponible.

## 7. Paso 2 · Escribir pruebas locales

Archivo: `src/test/java/.../domain/CalculadoraDescuentoTest.kt`.

```kotlin
package cl.duoc.usuario.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculadoraDescuentoTest {

    @Test
    fun sinDescuento_conservaPrecio() {
        assertEquals(10_000, calcularTotal(10_000, 0))
    }

    @Test
    fun descuentoParcial_calculaTotal() {
        assertEquals(9_000, calcularTotal(10_000, 10))
    }

    @Test
    fun descuentoCompleto_retornaCero() {
        assertEquals(0, calcularTotal(10_000, 100))
    }

    @Test
    fun porcentajeFueraDeRango_lanzaError() {
        assertThrows(IllegalArgumentException::class.java) {
            calcularTotal(10_000, 120)
        }
    }
}
```

Cada prueba tiene un nombre que expresa escenario y resultado. Agrega un caso para precio negativo y otro para precio cero.

Ejecuta:

```bash
./gradlew test
```

En Windows:

```powershell
.\gradlew.bat test
```

**Checkpoint 3:** las pruebas locales aparecen ejecutadas y pasan. Si alguna falla, lee el mensaje de aserción antes de modificar la función.

## 8. Paso 3 · Preparar un contrato de repositorio

Archivo: `data/DescuentosRepository.kt`.

```kotlin
package cl.duoc.usuario.data

interface DescuentosRepository {
    suspend fun obtenerDescuento(): Int
}
```

El ViewModel no necesita conocer si el dato viene de una API, una base local o memoria. La interfaz representa el contrato que vamos a sustituir durante la prueba.

## 9. Paso 4 · Crear un ViewModel observable

Archivo: `ui/DescuentoViewModel.kt`.

```kotlin
package cl.duoc.usuario.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import cl.duoc.usuario.data.DescuentosRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed interface DescuentoUiState {
    data object Idle : DescuentoUiState
    data object Loading : DescuentoUiState
    data class Success(val porcentaje: Int) : DescuentoUiState
    data class Error(val mensaje: String) : DescuentoUiState
}

class DescuentoViewModel(
    private val repository: DescuentosRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<DescuentoUiState>(DescuentoUiState.Idle)
    val uiState: StateFlow<DescuentoUiState> = _uiState.asStateFlow()

    fun cargar() {
        viewModelScope.launch {
            _uiState.value = DescuentoUiState.Loading
            try {
                _uiState.value =
                    DescuentoUiState.Success(repository.obtenerDescuento())
            } catch (cancelled: CancellationException) {
                throw cancelled
            } catch (error: Exception) {
                _uiState.value =
                    DescuentoUiState.Error(error.message ?: "Error inesperado")
            }
        }
    }
}
```

En una aplicación real, no conviertas indiscriminadamente cualquier excepción en error de UI: la cancelación de una corrutina debe propagarse. En este ejemplo acotado, agrega luego el tratamiento específico de `CancellationException` antes de ampliar el caso.

**Checkpoint 4:** el módulo compila y el ViewModel expone un estado observable.

## 10. Paso 5 · Crear un fake para la prueba

En `src/test/java/.../ui/DescuentoViewModelTest.kt`:

```kotlin
private class FakeDescuentosRepository(
    private val resultado: Int = 15,
    private val error: Exception? = null
) : DescuentosRepository {

    override suspend fun obtenerDescuento(): Int {
        error?.let { throw it }
        return resultado
    }
}
```

Un fake es una implementación sencilla que devuelve datos controlados. Evita red, credenciales y servicios externos. Para esta primera prueba es suficiente y más simple que un mock.

**Checkpoint 5:** puedes crear el fake con un resultado exitoso y con un error simulado.

### Alternativa opcional · MockK

Si quieres observar una interacción con un mock, puedes reemplazar el fake por:

```kotlin
val repository = mockk<DescuentosRepository>()
coEvery { repository.obtenerDescuento() } returns 15

val viewModel = DescuentoViewModel(repository)
viewModel.cargar()
advanceUntilIdle()

coVerify(exactly = 1) { repository.obtenerDescuento() }
```

Este bloque debe ejecutarse dentro de `runTest` y requiere los imports de MockK. Usa fake o mock para esta prueba; no necesitas mantener ambas implementaciones en el mismo caso.

## 11. Paso 6 · Probar el ViewModel y las corrutinas

El ViewModel anterior usa `viewModelScope`, que necesita el dispatcher Main. Configura el dispatcher de prueba antes de construir el ViewModel y restáuralo al terminar.

Ejemplo de regla JUnit 4:

```kotlin
@OptIn(ExperimentalCoroutinesApi::class)
class MainDispatcherRule(
    val dispatcher: TestDispatcher = StandardTestDispatcher()
) : TestWatcher() {

    override fun starting(description: Description) {
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}
```

Imports necesarios: `kotlinx.coroutines.Dispatchers`, `kotlinx.coroutines.ExperimentalCoroutinesApi`, `kotlinx.coroutines.test.TestDispatcher`, `kotlinx.coroutines.test.StandardTestDispatcher`, `org.junit.rules.TestWatcher` y `org.junit.runner.Description`.

Prueba:

```kotlin
@get:Rule
val mainDispatcherRule = MainDispatcherRule()

@Test
fun cargar_conRepositorioExitoso_exponeDescuento() = runTest {
    val repository = FakeDescuentosRepository(resultado = 15)
    val viewModel = DescuentoViewModel(repository)

    viewModel.cargar()
    advanceUntilIdle()

    assertEquals(
        DescuentoUiState.Success(15),
        viewModel.uiState.value
    )
}
```

Agrega otra prueba para el error simulado. Comprueba el estado final y explica por qué el test no espera segundos reales.

**Checkpoint 6:** las pruebas del ViewModel terminan de forma determinista sin `Thread.sleep()`.

## 12. Paso 7 · Crear una pantalla mínima

Archivo: `ui/DescuentoScreen.kt`.

```kotlin
@Composable
fun DescuentoScreen(
    porcentaje: Int,
    onCargar: () -> Unit
) {
    Column {
        Text("Descuento disponible: $porcentaje %")
        Button(
            modifier = Modifier.testTag("cargar-descuento"),
            onClick = onCargar
        ) {
            Text("Cargar descuento")
        }
    }
}
```

Agrega los imports de Compose necesarios. El `testTag` permite identificar el botón por semántica sin depender de coordenadas ni de su posición visual.

## 13. Paso 8 · Probar la interacción Compose

Archivo: `src/androidTest/java/.../ui/DescuentoScreenTest.kt`.

```kotlin
@RunWith(AndroidJUnit4::class)
class DescuentoScreenTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun botonCargar_alPresionarlo_invocaCallback() {
        var fueInvocado = false

        composeRule.setContent {
            DescuentoScreen(
                porcentaje = 15,
                onCargar = { fueInvocado = true }
            )
        }

        composeRule
            .onNodeWithTag("cargar-descuento")
            .assertIsDisplayed()
            .performClick()

        assertTrue(fueInvocado)
    }
}
```

Este ejemplo comprueba que el botón está visible y comunica el evento. Agrega imports de `AndroidJUnit4`, `RunWith`, `createComposeRule`, `onNodeWithTag`, `assertIsDisplayed`, `performClick` y `assertTrue`.

Ejecuta con un emulador iniciado:

```bash
./gradlew connectedAndroidTest
```

**Checkpoint 8:** la prueba instrumentada encuentra el botón, lo presiona y verifica el callback.

## 14. Paso 9 · Revisar la suite completa

Ejecuta por separado:

```bash
./gradlew test
./gradlew connectedAndroidTest
```

Revisa los reportes HTML que Gradle deja bajo `app/build/reports/tests/` y los resultados instrumentados bajo `app/build/reports/androidTests/` cuando estén disponibles.

Responde:

- ¿Qué pruebas corrieron sin dispositivo?
- ¿Cuál necesitó emulador?
- ¿Qué parte quedó aislada mediante el fake?
- ¿Qué regresión podría detectar cada prueba?
- ¿Qué escenario importante todavía no está cubierto?

## 15. Definition of Done

- [ ] La función de negocio tiene pruebas para casos normales y límites.
- [ ] Las pruebas locales se ejecutan con `./gradlew test`.
- [ ] El ViewModel se prueba sin red ni backend real.
- [ ] Las corrutinas se controlan con el scheduler de prueba.
- [ ] No se utiliza `Thread.sleep()`.
- [ ] La UI tiene al menos una prueba instrumentada Compose.
- [ ] Se distingue `src/test/` de `src/androidTest/`.
- [ ] Ambos integrantes pueden explicar una prueba y su aserción.
- [ ] DevLog registra objetivo, avance, bloqueo, aprendizaje y siguiente paso.

## 16. Entrega y evidencia

Comparte con tu docente y compañeros:

1. captura o salida de las pruebas locales;
2. captura o salida de la prueba instrumentada;
3. breve explicación de una prueba y del comportamiento que protege;
4. DevLog actualizado en `docs/devlog/semana-14.md`.

No subas contraseñas, tokens, archivos `local.properties`, carpetas `build/` ni datos personales.

## 17. Fuera de alcance

Este laboratorio no exige cobertura porcentual, pipeline CI, pruebas de screenshot, Robolectric, pruebas end-to-end completas ni migración de JUnit 4 a JUnit 5. Son extensiones posibles, no requisitos de esta práctica.
