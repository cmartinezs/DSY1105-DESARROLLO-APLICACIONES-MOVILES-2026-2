# Pruebas unitarias en aplicaciones móviles

## Objetivo y problema

Una aplicación puede compilar y abrirse correctamente y aun así calcular mal, presentar estados incorrectos o romper un flujo que antes funcionaba. Probar manualmente ayuda, pero repetir todos los escenarios después de cada cambio consume tiempo y facilita que se pasen por alto regresiones.

Las pruebas automatizadas ejecutan verificaciones repetibles sobre comportamientos concretos. Una prueba no demuestra que una aplicación esté libre de defectos: aporta evidencia sobre los casos que definimos y ejecutamos.

## ¿Qué es una prueba unitaria?

Es una verificación automatizada de una unidad pequeña de comportamiento: por ejemplo, una función, una clase o una regla de negocio. Se prepara un escenario, se ejecuta la operación y se compara el resultado observado con el esperado.

Una forma sencilla de organizarla es **Arrange – Act – Assert**:

1. **Arrange:** prepara datos y dependencias.
2. **Act:** ejecuta el comportamiento.
3. **Assert:** comprueba el resultado.

```kotlin
@Test
fun aplicarDescuento_aClienteFrecuente_calculaTotalEsperado() {
    // Arrange
    val precio = 10_000
    val porcentaje = 10

    // Act
    val total = calcularTotal(precio, porcentaje)

    // Assert
    assertEquals(9_000, total)
}
```

La prueba debe expresar una regla observable, no copiar la implementación ni depender de detalles internos que podrían cambiar sin alterar el comportamiento.

## No todas las pruebas tienen el mismo alcance

Android distingue pruebas por tamaño/alcance y por el entorno donde se ejecutan. Para comenzar, nos interesa especialmente dónde corren:

| Tipo | Dónde se ejecuta | Uso habitual |
|---|---|---|
| Local JVM | Máquina de desarrollo o CI, sin dispositivo | Funciones, reglas de negocio, ViewModels y clases desacopladas del framework Android |
| Instrumentada | Emulador o dispositivo Android | UI, integración con framework y comportamientos que necesitan el entorno real |

Ubicación convencional en un módulo Android:

```text
app/
└── src/
    ├── main/          # código de producción
    ├── test/          # pruebas locales JVM
    └── androidTest/   # pruebas instrumentadas
```

Una prueba unitaria no es sinónimo de prueba local en todos los casos; la clasificación por alcance y el lugar de ejecución son dimensiones diferentes. Para este curso comenzaremos con pruebas locales y usaremos instrumentadas para la interfaz.

## ¿Qué conviene probar en una aplicación Kotlin + Compose?

| Elemento | Qué verificar | Estrategia habitual |
|---|---|---|
| Función/regla de dominio | Entradas válidas, límites y resultados | Prueba local |
| ViewModel | Estado inicial, carga, éxito, vacío y error | Prueba local con fake/mock y corrutinas controladas |
| Repositorio | Transformación de datos y manejo de fallos | Prueba local con dependencias reemplazadas; integración cuando corresponda |
| Composable | Texto, acciones, visibilidad y semántica accesible | Compose UI Test instrumentado |
| Flujo completo | Integración de varias capas y navegación | Prueba de integración/UI, con menor cantidad y mayor intención |

## Herramientas y responsabilidades

No necesitamos utilizar todas las bibliotecas en cada prueba. Cada una resuelve un problema distinto:

- **JUnit:** estructura y ejecución de pruebas. En el material Android tradicional, Compose UI Test utiliza reglas JUnit 4.
- **Kotest:** assertions expresivas y, si se elige, estilos de especificación. Puede complementar una configuración JUnit o utilizar su propio motor; no es obligatorio mezclar motores.
- **MockK:** crea dobles de prueba para Kotlin cuando necesitamos controlar o verificar una dependencia.
- **kotlinx-coroutines-test:** permite ejecutar corrutinas en un entorno controlado y avanzar el tiempo virtual.
- **Compose UI Test:** consulta nodos semánticos, realiza acciones y verifica resultados visibles en Compose.

### Una decisión importante sobre JUnit 5 y Compose

JUnit 5 puede utilizarse en pruebas locales JVM si el proyecto configura el motor y el plugin de Gradle correspondientes. Sin embargo, la API clásica `createComposeRule()` / `createAndroidComposeRule()` de Compose UI Test está diseñada alrededor de reglas JUnit 4 y de la dependencia `ui-test-junit4`.

Por eso no debemos afirmar que basta con cambiar JUnit 4 por JUnit 5 para ejecutar pruebas Compose. En el laboratorio mantendremos JUnit 4 para Compose UI Test y mostraremos Kotest, MockK y coroutines-test como herramientas complementarias. La elección de JUnit 5 para pruebas locales se deja como configuración posterior, no como requisito para comenzar.

## Ejemplo: probar lógica sin Android

La regla de negocio no necesita conocer una pantalla, un Context ni un dispositivo:

```kotlin
fun calcularTotal(precio: Int, descuentoPorcentaje: Int): Int {
    require(precio >= 0) { "El precio no puede ser negativo" }
    require(descuentoPorcentaje in 0..100) {
        "El descuento debe estar entre 0 y 100"
    }
    return precio - (precio * descuentoPorcentaje / 100)
}
```

Casos mínimos que deberíamos considerar:

- precio sin descuento;
- descuento parcial;
- descuento del 100 %;
- precio igual a cero;
- porcentaje fuera del rango permitido;
- precio negativo.

No basta con probar el camino feliz: los límites y entradas inválidas suelen revelar errores importantes.

## Dobles de prueba: fake y mock

Cuando una clase depende de un repositorio, servicio o reloj, no queremos que cada prueba dependa de una API real o de la red.

- **Fake:** implementación simple que funciona en memoria y entrega resultados controlados.
- **Mock:** objeto configurado para responder a llamadas y, si es necesario, verificar que una interacción ocurrió.

Preferencia práctica: utiliza un fake cuando represente naturalmente el contrato y sea fácil de mantener. Usa MockK cuando necesites controlar una interacción o simular un comportamiento específico. No reemplaces todo indiscriminadamente.

## Probar corrutinas

Una prueba asíncrona debe controlar el scheduler y esperar el trabajo de forma determinista. `runTest` proporciona un entorno de prueba; `advanceUntilIdle()` ejecuta el trabajo pendiente del scheduler hasta quedar sin tareas programadas.

Evita `Thread.sleep()`: ralentiza las pruebas y no garantiza sincronización correcta. Si el código usa dispatchers inyectables, reemplázalos por dispatchers de prueba; no asumas que `runTest` controla automáticamente cualquier dispatcher global.

## Probar la interfaz Compose

Las pruebas UI interactúan con la semántica expuesta por los componentes, no con coordenadas de pantalla. Para localizar elementos de manera estable:

```kotlin
Modifier.testTag("guardar")
```

Luego la prueba puede consultar el nodo por etiqueta, ejecutar una acción y verificar el resultado:

```kotlin
composeTestRule
    .onNodeWithTag("guardar")
    .performClick()

composeTestRule
    .onNodeWithText("Guardado")
    .assertIsDisplayed()
```

Usa etiquetas cuando aporten estabilidad o cuando el texto visible no sea un identificador adecuado. No agregues `testTag` a todos los elementos por costumbre.

## Buenas prácticas

- Una prueba debe verificar un comportamiento principal y tener un nombre descriptivo.
- Mantén pruebas rápidas, aisladas, deterministas y fáciles de leer.
- Verifica resultados observables; evita probar detalles privados.
- No dependas de servicios externos, red o datos reales en una prueba unitaria.
- Prefiere fakes simples; utiliza mocks con intención.
- No uses `Thread.sleep()` para esperar corrutinas o animaciones.
- En Compose, consulta semántica y sincronización de pruebas; evita pausas arbitrarias.
- Separa `src/test/` de `src/androidTest/`.
- Ejecuta las pruebas después de cada cambio relevante y antes de integrar.

## Comandos básicos

Desde la raíz del proyecto Android:

```bash
./gradlew test
./gradlew connectedAndroidTest
```

En Windows:

```powershell
.\gradlew.bat test
.\gradlew.bat connectedAndroidTest
```

El primer comando ejecuta las pruebas locales configuradas. El segundo requiere un dispositivo o emulador disponible y ejecuta las instrumentadas.

## Comprueba lo aprendido

1. ¿Por qué una regla de negocio debería probarse sin iniciar Android?
2. ¿Qué diferencia existe entre una prueba local JVM y una instrumentada?
3. ¿Cuándo preferirías un fake frente a un mock?
4. ¿Por qué `Thread.sleep()` hace frágil una prueba asíncrona?
5. ¿Qué debe comprobar una prueba Compose: la estructura interna del Composable o el comportamiento observable?
6. ¿Por qué la regla JUnit 4 de Compose UI Test no debe confundirse con la configuración JUnit 5 de pruebas locales?

Continúa con la [profundización técnica](./01-pruebas-unitarias-android/README.md) y luego desarrolla el [laboratorio guiado](../../labs/semana-14-pruebas-unitarias/README.md).

## Fuentes primarias

- [Android Developers · Fundamentos de las pruebas](https://developer.android.com/training/testing/fundamentals?hl=es-419).
- [Android Developers · Pruebas locales](https://developer.android.com/training/testing/local-tests).
- [Android Developers · Pruebas instrumentadas](https://developer.android.com/training/testing/instrumented-tests).
- [Android Developers · Pruebas de UI en Compose](https://developer.android.com/develop/ui/compose/testing).
- [Android Developers · Pruebas en Android Studio](https://developer.android.com/studio/test/test-in-android-studio).
