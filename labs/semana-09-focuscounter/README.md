# Laboratorio guiado · FocusCounter
## Propósito y resultado
Crear una app Android independiente que cuenta sesiones de estudio y permite modificar una **meta diaria persistente**. El contador es estado de UI; la meta usa Preferences DataStore. No es PocketLog ni solución del caso VcM.

## 0 · Proyecto
Android Studio → New Project → Empty Activity, Kotlin, package `cl.duoc.focuscounter`, minSdk 26. Ejecuta el template antes de editar. **Checkpoint 0:** abre sin errores.

## 1 · Dependencias
Conserva las dependencias Compose del template y añade `androidx.datastore:datastore-preferences` en una versión compatible revisada con Gradle. No agregues navegación, Room, Retrofit ni DI. Sincroniza. **Checkpoint 1:** build Gradle correcto.

## 2 · Estructura
```text
cl/duoc/focuscounter/
  MainActivity.kt
  data/MetaRepository.kt
  ui/FocusScreen.kt
  ui/FocusViewModel.kt
```

## 3 · Repositorio de preferencias
`data/MetaRepository.kt`:
```kotlin
package cl.duoc.focuscounter.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.metaStore by preferencesDataStore(name = "focus_settings")
private val META = intPreferencesKey("daily_goal")

class MetaRepository(private val context: Context) {
    val meta = context.metaStore.data.map { pref -> pref[META] ?: 5 }

    suspend fun guardarMeta(value: Int) {
        context.metaStore.edit { pref -> pref[META] = value.coerceIn(1, 20) }
    }
}
```
**Explica:** clave, valor por defecto, Flow, `edit` y validación 1..20. **Checkpoint 2:** compila el repositorio.

## 4 · ViewModel
`ui/FocusViewModel.kt`:
```kotlin
package cl.duoc.focuscounter.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import cl.duoc.focuscounter.data.MetaRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FocusViewModel(private val repository: MetaRepository) : ViewModel() {
    val meta = repository.meta.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), 5
    )

    fun cambiarMeta(value: Int) {
        viewModelScope.launch { repository.guardarMeta(value) }
    }
}

class FocusViewModelFactory(private val repo: MetaRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        FocusViewModel(repo) as T
}
```
Agrega dependencia Lifecycle ViewModel Compose si el template no la incluye. **Checkpoint 3:** ViewModel compila y no importa Composables.

## 5 · Interfaz
`ui/FocusScreen.kt`:
```kotlin
package cl.duoc.focuscounter.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun FocusScreen(vm: FocusViewModel) {
    val meta by vm.meta.collectAsStateWithLifecycle()
    var completadas by rememberSaveable { mutableIntStateOf(0) }
    Column {
        Text("Completadas: $completadas / Meta: $meta")
        Button(onClick = { completadas++ }) { Text("Completar sesión") }
        Button(onClick = { completadas = 0 }) { Text("Reiniciar contador") }
        Button(onClick = { vm.cambiarMeta(meta + 1) }) { Text("Meta +") }
        Button(onClick = { vm.cambiarMeta(meta - 1) }) { Text("Meta -") }
        if (completadas >= meta) Text("¡Meta alcanzada!")
    }
}
```
Verifica dependencia `lifecycle-runtime-compose` para `collectAsStateWithLifecycle`. **Checkpoint 4:** botón Completar actualiza UI.

## 6 · Integración
En `MainActivity.onCreate`, dentro de `setContent`:
```kotlin
val factory = remember {
    FocusViewModelFactory(MetaRepository(applicationContext))
}
val vm: FocusViewModel = viewModel(factory = factory)
FocusScreen(vm)
```
Usa imports de Compose, `androidx.lifecycle.viewmodel.compose.viewModel`, repositorio y pantalla. **Checkpoint 5:** app abre, cambia meta y actualiza UI.

## 7 · Pruebas manuales
1. Meta 5 → 6: la UI cambia.
2. Rotación: contador se restaura; meta se observa.
3. Cerrar/reabrir normalmente: meta 6 sigue; contador puede reiniciarse.
4. Pulsar Meta - repetidamente: valor nunca baja de 1.
5. Borrar almacenamiento en ajustes: meta vuelve a 5.

## Comprender el flujo
Botón → evento en ViewModel → corutina → MetaRepository → DataStore → Flow → ViewModel → Compose.
El contador no se guarda en DataStore. Datos estructurados esperan SQLite/Room en semana 10.

## DevLog y DoD
Commits graduales, evidencia de checkpoints, tabla de resultados de pruebas y explicación escrita de `rememberSaveable` vs DataStore. **Limitación:** material preparado; no se ha validado compilación Android en esta ejecución.
