# Laboratorio Semana 8 · RegistroUsuario

## Propósito

Construir **desde cero y paso a paso** una aplicación Android pequeña con Jetpack Compose que implemente el flujo completo trabajado en la Guía 11:

```text
RegistroScreen
→ eventos de formulario
→ UsuarioViewModel
→ MutableStateFlow
→ validación
→ navegación
→ ResumenScreen
→ mismo UsuarioViewModel
```

Este laboratorio está diseñado para seguirse **de la mano**. No se espera que inventes toda la arquitectura antes de comenzar: cada paso agrega una pieza, la ejecuta y comprueba antes de continuar.

El laboratorio es independiente de PocketLog y del proyecto VcM.

---

## Resultado esperado

La aplicación permitirá:

- ingresar nombre;
- ingresar correo;
- ingresar una clave;
- ingresar dirección;
- aceptar términos mediante Checkbox;
- mostrar mensajes de validación específicos;
- impedir el avance cuando existen errores;
- navegar a una pantalla Resumen cuando el formulario es válido;
- mostrar en Resumen los mismos datos mantenidos por el ViewModel compartido;
- volver al formulario conservando el estado.

La clave **no se muestra en texto abierto** en la pantalla Resumen.

---

## Proyecto de referencia

Esta carpeta contiene un proyecto Android autónomo:

```text
semana-08-registro-usuario/
├── settings.gradle.kts
├── build.gradle.kts
├── gradle.properties
└── app/
    ├── build.gradle.kts
    └── src/main/
        ├── AndroidManifest.xml
        └── java/cl/duoc/registrousuario/
            ├── MainActivity.kt
            ├── model/
            │   └── UsuarioUiState.kt
            ├── viewmodel/
            │   └── UsuarioViewModel.kt
            ├── navigation/
            │   └── RegistroNavigation.kt
            └── ui/screen/
                ├── RegistroScreen.kt
                └── ResumenScreen.kt
```

La recomendación es construir primero siguiendo esta guía y usar el código de referencia sólo para comparar cuando un checkpoint no resulte como esperabas.

---

# Paso 0 · Crear y ejecutar el proyecto

En Android Studio:

1. **New Project**.
2. Selecciona **Empty Activity**.
3. Nombre: `RegistroUsuario`.
4. Package: `cl.duoc.registrousuario`.
5. Kotlin.
6. Min SDK 26 o superior.
7. Finaliza la creación.
8. Ejecuta inmediatamente el template.

Antes de agregar lógica, confirma que la aplicación abre.

**Checkpoint 0:** el proyecto base ejecuta sin errores.

---

# Paso 1 · Agregar dependencias necesarias

En `app/build.gradle.kts` necesitamos Compose, Navigation y Lifecycle/ViewModel.

El bloque relevante puede quedar así:

```kotlin
dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2026.08.00")

    implementation(composeBom)

    implementation("androidx.core:core-ktx:1.18.0")
    implementation("androidx.activity:activity-compose:1.13.0")

    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.ui:ui-tooling-preview")

    implementation("androidx.navigation:navigation-compose:2.10.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.10.0")

    debugImplementation("androidx.compose.ui:ui-tooling")
}
```

Sincroniza Gradle.

**Checkpoint 1:** el proyecto vuelve a compilar.

---

# Paso 2 · Crear la estructura de carpetas

Dentro de:

```text
app/src/main/java/cl/duoc/registrousuario/
```

crea:

```text
model/
viewmodel/
navigation/
ui/screen/
```

La intención es separar responsabilidades:

```text
model
→ describe el estado

viewmodel
→ modifica estado y valida

ui/screen
→ representa estado y emite eventos

navigation
→ decide qué pantalla mostrar
```

Todavía no escribas lógica en `MainActivity`.

---

# Paso 3 · Crear el modelo de errores

Crea:

```text
model/UsuarioUiState.kt
```

Primero define los errores:

```kotlin
package cl.duoc.registrousuario.model

data class UsuarioErrores(
    val nombre: String? = null,
    val correo: String? = null,
    val clave: String? = null,
    val direccion: String? = null,
    val terminos: String? = null
)
```

Cada propiedad puede contener:

```text
null
→ no existe error

String
→ mensaje que debe ver el usuario
```

No uses un único `mensajeError` para todo el formulario. Queremos saber **qué campo** falló.

---

# Paso 4 · Crear UsuarioUiState

Debajo de `UsuarioErrores`, agrega:

```kotlin
data class UsuarioUiState(
    val nombre: String = "",
    val correo: String = "",
    val clave: String = "",
    val direccion: String = "",
    val aceptaTerminos: Boolean = false,
    val errores: UsuarioErrores = UsuarioErrores()
)
```

Ahora tenemos una fotografía completa de la pantalla:

```text
UsuarioUiState
├── datos escritos
├── Checkbox
└── errores visibles
```

**Checkpoint 2:** el proyecto compila con ambos `data class`.

---

# Paso 5 · Crear UsuarioViewModel con StateFlow

Crea:

```text
viewmodel/UsuarioViewModel.kt
```

Parte con:

```kotlin
package cl.duoc.registrousuario.viewmodel

import androidx.lifecycle.ViewModel
import cl.duoc.registrousuario.model.UsuarioUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UsuarioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UsuarioUiState())

    val uiState: StateFlow<UsuarioUiState> =
        _uiState.asStateFlow()
}
```

Observa la idea:

```text
MutableStateFlow
→ privado
→ sólo el ViewModel lo modifica

StateFlow
→ público
→ la UI lo observa
```

La pantalla no debe hacer:

```kotlin
_uiState.value = ...
```

porque ni siquiera tendrá acceso a `_uiState`.

---

# Paso 6 · Agregar eventos de cambio

Dentro de `UsuarioViewModel`, agrega:

```kotlin
fun onNombreChange(valor: String) {
    _uiState.update { estado ->
        estado.copy(
            nombre = valor,
            errores = estado.errores.copy(nombre = null)
        )
    }
}
```

Haz lo mismo para correo:

```kotlin
fun onCorreoChange(valor: String) {
    _uiState.update { estado ->
        estado.copy(
            correo = valor,
            errores = estado.errores.copy(correo = null)
        )
    }
}
```

Clave:

```kotlin
fun onClaveChange(valor: String) {
    _uiState.update { estado ->
        estado.copy(
            clave = valor,
            errores = estado.errores.copy(clave = null)
        )
    }
}
```

Dirección:

```kotlin
fun onDireccionChange(valor: String) {
    _uiState.update { estado ->
        estado.copy(
            direccion = valor,
            errores = estado.errores.copy(direccion = null)
        )
    }
}
```

Checkbox:

```kotlin
fun onAceptaTerminosChange(valor: Boolean) {
    _uiState.update { estado ->
        estado.copy(
            aceptaTerminos = valor,
            errores = estado.errores.copy(terminos = null)
        )
    }
}
```

¿Por qué limpiamos el error cuando el usuario vuelve a escribir?

Porque está intentando corregir la condición anterior. La siguiente validación determinará si sigue existiendo el problema.

**Checkpoint 3:** el ViewModel compila y todavía no conoce ningún Composable.

---

# Paso 7 · Implementar validarFormulario()

Ahora agregaremos la lógica central del laboratorio.

Importa:

```kotlin
import cl.duoc.registrousuario.model.UsuarioErrores
```

Dentro del ViewModel:

```kotlin
fun validarFormulario(): Boolean {

    val estado = _uiState.value

    val nombreError =
        if (estado.nombre.trim().length < 3)
            "El nombre debe tener al menos 3 caracteres"
        else
            null

    val correoError =
        if (
            !estado.correo.contains("@") ||
            !estado.correo.substringAfter("@", "").contains(".")
        )
            "Ingresa un correo válido"
        else
            null

    val claveError =
        if (estado.clave.length < 6)
            "La clave debe tener al menos 6 caracteres"
        else
            null

    val direccionError =
        if (estado.direccion.trim().length < 5)
            "Ingresa una dirección válida"
        else
            null

    val terminosError =
        if (!estado.aceptaTerminos)
            "Debes aceptar los términos"
        else
            null

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
```

La idea importante es:

```text
validarFormulario()
→ calcula TODOS los errores
→ actualiza UiState
→ devuelve true / false
```

No navegamos aquí.

El ViewModel sabe si el formulario es válido, pero **no sabe qué ruta abrir**.

**Checkpoint 4:** `UsuarioViewModel` compila completo.

---

# Paso 8 · Crear RegistroScreen

Crea:

```text
ui/screen/RegistroScreen.kt
```

Comienza con el contrato:

```kotlin
package cl.duoc.registrousuario.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import cl.duoc.registrousuario.model.UsuarioUiState

@Composable
fun RegistroScreen(
    state: UsuarioUiState,
    onNombreChange: (String) -> Unit,
    onCorreoChange: (String) -> Unit,
    onClaveChange: (String) -> Unit,
    onDireccionChange: (String) -> Unit,
    onAceptaTerminosChange: (Boolean) -> Unit,
    onContinuar: () -> Unit
) {
}
```

Fíjate en algo:

```text
RegistroScreen
NO recibe UsuarioViewModel
NO recibe NavController

recibe
→ estado
→ callbacks
```

Eso hace que la pantalla sea mucho más fácil de entender y probar.

---

# Paso 9 · Construir el formulario visual

Dentro de `RegistroScreen`:

```kotlin
Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp)
) {

    Text(
        text = "Crear cuenta",
        style = MaterialTheme.typography.headlineMedium
    )

    Text(
        text = "Completa tus datos para continuar.",
        style = MaterialTheme.typography.bodyLarge
    )
}
```

Ejecuta mentalmente:

```text
Column
→ título
→ descripción
→ campos
→ checkbox
→ botón
```

---

# Paso 10 · Campo Nombre

Dentro del `Column` agrega:

```kotlin
OutlinedTextField(
    value = state.nombre,
    onValueChange = onNombreChange,
    modifier = Modifier.fillMaxWidth(),
    label = {
        Text("Nombre")
    },
    isError = state.errores.nombre != null,
    supportingText = {
        state.errores.nombre?.let { mensaje ->
            Text(mensaje)
        }
    }
)
```

Aquí aparece el patrón completo:

```text
state.nombre
→ valor visible

onNombreChange
→ evento

state.errores.nombre
→ feedback
```

---

# Paso 11 · Campo Correo

Agrega:

```kotlin
OutlinedTextField(
    value = state.correo,
    onValueChange = onCorreoChange,
    modifier = Modifier.fillMaxWidth(),
    label = {
        Text("Correo")
    },
    isError = state.errores.correo != null,
    supportingText = {
        state.errores.correo?.let { mensaje ->
            Text(mensaje)
        }
    }
)
```

No valides el correo aquí.

La pantalla **muestra el error**; el ViewModel decide si existe.

---

# Paso 12 · Campo Clave

Agrega:

```kotlin
OutlinedTextField(
    value = state.clave,
    onValueChange = onClaveChange,
    modifier = Modifier.fillMaxWidth(),
    label = {
        Text("Clave")
    },
    visualTransformation = PasswordVisualTransformation(),
    isError = state.errores.clave != null,
    supportingText = {
        state.errores.clave?.let { mensaje ->
            Text(mensaje)
        }
    }
)
```

La clave se oculta visualmente.

Eso no es cifrado ni persistencia segura: sólo evita mostrarla en texto visible durante la entrada.

---

# Paso 13 · Campo Dirección

Agrega:

```kotlin
OutlinedTextField(
    value = state.direccion,
    onValueChange = onDireccionChange,
    modifier = Modifier.fillMaxWidth(),
    label = {
        Text("Dirección")
    },
    isError = state.errores.direccion != null,
    supportingText = {
        state.errores.direccion?.let { mensaje ->
            Text(mensaje)
        }
    }
)
```

---

# Paso 14 · Checkbox de términos

Agrega:

```kotlin
Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
) {

    Checkbox(
        checked = state.aceptaTerminos,
        onCheckedChange = onAceptaTerminosChange
    )

    Text("Acepto los términos")
}
```

Debajo:

```kotlin
state.errores.terminos?.let { mensaje ->
    Text(
        text = mensaje,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall
    )
}
```

---

# Paso 15 · Botón Continuar

Finalmente:

```kotlin
Button(
    onClick = onContinuar,
    modifier = Modifier.fillMaxWidth()
) {
    Text("Continuar")
}
```

No navegamos desde esta pantalla directamente.

Sólo emitimos:

```text
onContinuar
```

**Checkpoint 5:** `RegistroScreen` compila y sólo depende de `UsuarioUiState` + callbacks.

---

# Paso 16 · Crear ResumenScreen

Crea:

```text
ui/screen/ResumenScreen.kt
```

Código:

```kotlin
package cl.duoc.registrousuario.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.duoc.registrousuario.model.UsuarioUiState

@Composable
fun ResumenScreen(
    state: UsuarioUiState,
    onVolver: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Resumen",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Nombre: " + state.nombre)
        Text("Correo: " + state.correo)
        Text("Dirección: " + state.direccion)

        Text(
            if (state.aceptaTerminos)
                "Términos aceptados"
            else
                "Términos no aceptados"
        )

        Button(onClick = onVolver) {
            Text("Volver")
        }
    }
}
```

No mostramos:

```text
state.clave
```

aunque siga existiendo en el estado.

**Checkpoint 6:** ambas pantallas compilan sin Navigation.

---

# Paso 17 · Crear navegación

Crea:

```text
navigation/RegistroNavigation.kt
```

Código inicial:

```kotlin
package cl.duoc.registrousuario.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.duoc.registrousuario.ui.screen.RegistroScreen
import cl.duoc.registrousuario.ui.screen.ResumenScreen
import cl.duoc.registrousuario.viewmodel.UsuarioViewModel
```

Ahora crea:

```kotlin
@Composable
fun RegistroNavigation(
    viewModel: UsuarioViewModel
) {

    val navController = rememberNavController()

    val state by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = "registro"
    ) {

        composable("registro") {
            RegistroScreen(
                state = state,
                onNombreChange = viewModel::onNombreChange,
                onCorreoChange = viewModel::onCorreoChange,
                onClaveChange = viewModel::onClaveChange,
                onDireccionChange = viewModel::onDireccionChange,
                onAceptaTerminosChange =
                    viewModel::onAceptaTerminosChange,
                onContinuar = {
                    if (viewModel.validarFormulario()) {
                        navController.navigate("resumen")
                    }
                }
            )
        }

        composable("resumen") {
            ResumenScreen(
                state = state,
                onVolver = {
                    navController.popBackStack()
                }
            )
        }
    }
}
```

Este punto contiene la idea principal de la semana:

```text
RegistroScreen
       ↓
UsuarioViewModel
       ↓
StateFlow
       ↓
RegistroNavigation
       ↓
ResumenScreen
```

Ambas pantallas reciben **el mismo estado proveniente del mismo ViewModel**.

No estamos creando otro ViewModel al entrar a Resumen.

---

# Paso 18 · Conectar MainActivity

Abre:

```text
MainActivity.kt
```

Déjalo conceptualmente así:

```kotlin
package cl.duoc.registrousuario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import cl.duoc.registrousuario.navigation.RegistroNavigation
import cl.duoc.registrousuario.viewmodel.UsuarioViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val usuarioViewModel: UsuarioViewModel = viewModel()

            RegistroNavigation(
                viewModel = usuarioViewModel
            )
        }
    }
}
```

La Activity crea **una única instancia** del ViewModel y la entrega al grafo de navegación.

Por eso Registro y Resumen trabajan con el mismo estado.

**Checkpoint 7:** la aplicación completa ejecuta.

---

# Paso 19 · Probar formulario inválido

Ejecuta y pulsa **Continuar** sin ingresar datos.

Debes ver errores en:

- nombre;
- correo;
- clave;
- dirección;
- términos.

Y debes permanecer en:

```text
registro
```

Si navega a Resumen, revisa:

```kotlin
if (viewModel.validarFormulario()) {
    navController.navigate("resumen")
}
```

---

# Paso 20 · Corregir un error

Escribe un nombre válido.

El mensaje asociado al nombre debería desaparecer porque:

```kotlin
errores = estado.errores.copy(
    nombre = null
)
```

Luego vuelve a pulsar Continuar.

Los otros errores siguen existiendo.

Esto demuestra que los errores también son parte del estado.

---

# Paso 21 · Completar correctamente

Usa por ejemplo:

```text
Nombre:
Valentina Soto

Correo:
valentina@ejemplo.cl

Clave:
secreto123

Dirección:
Av. Siempre Viva 123

Términos:
✓
```

Pulsa Continuar.

Resultado:

```text
Registro
→ validarFormulario() = true
→ navController.navigate("resumen")
→ Resumen
```

La pantalla debe mostrar nombre, correo y dirección.

---

# Paso 22 · Volver y comprobar estado compartido

Desde Resumen pulsa **Volver**.

Deberías regresar al formulario y los campos seguirán completos.

¿Por qué?

Porque no creamos un estado nuevo.

```text
RegistroScreen
      ↘
   mismo UsuarioViewModel
      ↗
ResumenScreen
```

---

# Paso 23 · ¿Qué ocurriría si pasáramos los datos por la ruta?

Podríamos intentar algo como:

```text
resumen/Valentina/valentina@ejemplo.cl/...
```

Pero eso sería una mala idea:

- rutas gigantes;
- encoding;
- datos sensibles;
- duplicación;
- más acoplamiento.

En este flujo, el ViewModel compartido representa mejor el estado temporal del proceso.

Eso **no significa** que el patrón:

```text
detalle/{id}
```

aprendido en Semana 7 sea incorrecto.

Son problemas distintos.

---

# Paso 24 · Casos manuales

Prueba todos:

| Caso | Resultado esperado |
|---|---|
| abrir app | muestra Registro |
| continuar vacío | muestra todos los errores |
| nombre corto | error de nombre |
| correo inválido | error de correo |
| clave corta | error de clave |
| dirección corta | error de dirección |
| términos sin aceptar | error de términos |
| corregir campo | su error desaparece |
| datos válidos | navega a Resumen |
| Resumen | muestra mismos datos |
| Resumen | no muestra clave |
| volver | conserva formulario |

---

# Paso 25 · Explica el flujo completo

Sin mirar el código, intenta explicar:

```text
usuario escribe nombre
→ RegistroScreen emite onNombreChange
→ UsuarioViewModel actualiza MutableStateFlow
→ collectAsState observa el cambio
→ Compose recompone RegistroScreen

usuario pulsa Continuar
→ onContinuar
→ validarFormulario()
→ ViewModel actualiza errores
→ si existen errores, Compose los muestra
→ si no existen errores, Navigation abre Resumen

ResumenScreen
→ recibe el mismo UiState
→ muestra los datos del mismo ViewModel
```

Si puedes explicar esto, ya entendiste mucho más que simplemente copiar el código.

---

# Paso 26 · DevLog

Registra:

- captura del formulario;
- captura con errores;
- captura de Resumen;
- estructura de paquetes;
- para qué usamos `MutableStateFlow`;
- para qué usamos `collectAsState`;
- diferencia entre `UiState` y `UsuarioErrores`;
- por qué el ViewModel no conoce `NavController`;
- por qué Registro y Resumen comparten el mismo ViewModel;
- un error que hayas encontrado;
- commit final.

---

## Límites de Semana 8

No incorporar todavía:

- Room;
- DataStore;
- Retrofit;
- cámara;
- GPS;
- lector QR;
- sensores;
- DI;
- autenticación real;
- almacenamiento real de claves.

La app es una práctica académica de estado, validación y navegación.

---

# Definition of Done

El laboratorio termina cuando:

- la aplicación ejecuta;
- todos los campos actualizan el estado;
- los errores aparecen correctamente;
- corregir un campo actualiza su feedback;
- `MutableStateFlow` vive en el ViewModel;
- Compose observa el estado;
- un formulario inválido no navega;
- un formulario válido abre Resumen;
- Resumen observa los mismos datos;
- volver conserva el estado;
- la clave no se muestra;
- puedes explicar el flujo completo.

```text
UI
→ callback
→ ViewModel
→ MutableStateFlow
→ collectAsState
→ UI

Continuar
→ validar
→ navegar
→ Resumen
→ mismo estado
```

→ Código de referencia: `app/src/main/java/cl/duoc/registrousuario/`
