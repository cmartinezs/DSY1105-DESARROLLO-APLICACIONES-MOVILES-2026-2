# Profundización · Pruebas unitarias en Android

Esta carpeta amplía el tema base sin reemplazarlo. Primero estudia [Pruebas unitarias en aplicaciones móviles](../01-pruebas-unitarias-android.md).

## Mapa de profundización

1. **JUnit y configuración de pruebas:** diferencia entre dependencias locales e instrumentadas, motores y reglas.
2. **Kotest:** assertions y estilos alternativos para expresar escenarios.
3. **MockK:** mocks, stubs, verificación de llamadas y aislamiento.
4. **Coroutines Test:** `runTest`, scheduler virtual, dispatchers y StateFlow.
5. **Compose UI Test:** reglas, nodos semánticos, acciones, aserciones y etiquetas.

## Configuración: separar responsabilidades

En un módulo Android, las dependencias se declaran según el source set donde se ejecutarán:

```kotlin
dependencies {
    // Pruebas locales JVM
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)

    // Pruebas instrumentadas
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
```

Los alias son ilustrativos: deben existir en el `libs.versions.toml` del proyecto. Si no se utiliza Version Catalog, declara las coordenadas y versiones compatibles con el proyecto. No copies versiones aisladas sin revisar Kotlin, Compose BOM y Android Gradle Plugin.

## JUnit 4 y JUnit 5 no son intercambiables automáticamente

- JUnit 4 utiliza `org.junit.Test` y reglas como `@get:Rule`.
- JUnit 5 separa API, engine y plataforma de ejecución.
- La API `androidx.compose.ui.test.junit4` utiliza reglas JUnit 4.
- Kotest puede integrarse con JUnit Platform o utilizar su propio runner, según el estilo de configuración elegido.

En esta asignatura, el objetivo es aprender a diseñar pruebas, no invertir la sesión en migrar el sistema de ejecución. Mantén la configuración que el proyecto ya utiliza y no mezcles motores sin una razón clara.

## Kotest: assertions legibles

Kotest permite expresar expectativas de forma idiomática:

```kotlin
import io.kotest.matchers.shouldBe

@Test
fun descuentoParcial() {
    calcularTotal(10_000, 10) shouldBe 9_000
}
```

Este fragmento muestra una assertion; la anotación y el runner deben corresponder al motor configurado en el proyecto.

## MockK: aislar una dependencia

```kotlin
val repository = mockk<LecturasRepository>()
coEvery { repository.listar() } returns listOf(lecturaFake)

val viewModel = LecturasViewModel(repository)
viewModel.cargar()

coVerify(exactly = 1) { repository.listar() }
```

Este ejemplo supone que `listar` es suspendida y que el ViewModel permite inyectar el repositorio. Adapta nombres y tipos al contrato real. No uses mocks para reemplazar la lógica que precisamente deseas probar.

## Corrutinas: controlar el tiempo

```kotlin
@Test
fun cargaActualizaEstado() = runTest {
    val repository = FakeLecturasRepository(
        resultado = listOf(lecturaFake)
    )
    val viewModel = LecturasViewModel(repository)

    viewModel.cargar()
    advanceUntilIdle()

    viewModel.uiState.value shouldBe LecturasUiState.Success(
        listOf(lecturaFake)
    )
}
```

El ejemplo requiere que el ViewModel use un dispatcher/scheduler compatible con el entorno de prueba. Para código que lanza trabajo en `Dispatchers.IO` o `Dispatchers.Main` globales, inyecta dispatchers o configura el Main dispatcher de prueba correctamente. Un fake de repositorio suele hacer la prueba más simple y legible.

## Compose UI Test: verificar comportamiento visible

```kotlin
@get:Rule
val composeTestRule = createComposeRule()

@Test
fun botonGuardar_muestraConfirmacion() {
    composeTestRule.setContent {
        PantallaGuardar(onGuardar = {})
    }

    composeTestRule.onNodeWithTag("guardar").performClick()
    composeTestRule.onNodeWithText("Guardado").assertIsDisplayed()
}
```

El ejemplo es esquemático: la pantalla debe producir realmente el estado de confirmación para que la aserción tenga sentido. Para probar un ViewModel y la UI juntos, inyecta el estado o un fake controlable.

## Referencias de herramientas

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/).
- [Kotest Documentation](https://kotest.io/docs/).
- [MockK](https://mockk.io/).
- [kotlinx.coroutines · Testing coroutines](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-test/).
- [Compose UI Testing](https://developer.android.com/develop/ui/compose/testing).
