# Ejemplo 03 · DataStore
Agrega en `app/build.gradle.kts` la dependencia de Preferences DataStore, usando una versión compatible verificada con el catálogo del proyecto.

```kotlin
val Context.settingsDataStore by preferencesDataStore(name = "settings")
val META = intPreferencesKey("meta_diaria")
val metaFlow: Flow<Int> = context.settingsDataStore.data.map { it[META] ?: 5 }
suspend fun guardarMeta(context: Context, value: Int) {
    context.settingsDataStore.edit { it[META] = value.coerceAtLeast(1) }
}
```

Imports: `android.content.Context`, `androidx.datastore.preferences.preferencesDataStore`, `androidx.datastore.preferences.core.intPreferencesKey`, `androidx.datastore.preferences.core.edit`, `kotlinx.coroutines.flow.Flow`, `kotlinx.coroutines.flow.map`.

**Checkpoint:** usa una corutina para guardar una meta y observa Flow. Cierra y reabre de forma normal; la meta permanece. En una app real concentra estas operaciones en un repositorio, no dentro de Composables.
