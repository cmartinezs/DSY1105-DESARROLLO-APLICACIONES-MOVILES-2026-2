# 03 · Conectar ViewModel y pantalla Compose

[← Persistencia](02-persistencia.md) · [Siguiente → Verificación](04-verificacion.md)

## Paso 7 · ViewModel que coordina CRUD

Crea `ui/NotasViewModel.kt`. [Ver archivo Kotlin completo](referencia/app/src/main/java/cl/duoc/misnotasroom/ui/NotasViewModel.kt).

Partimos del DAO obtenido desde la base de datos:

```kotlin
private val dao = AppDatabase.getDatabase(application).notaDao()
val notas = dao.obtenerTodas()
```

Para **crear**, validar y ejecutar en una corrutina:

```kotlin
fun guardar(texto: String) {
    if (texto.isBlank()) return
    viewModelScope.launch {
        dao.insertar(Nota(texto = texto.trim()))
    }
}
```

Para **modificar**, conserva el ID de la nota seleccionada:

```kotlin
dao.actualizar(nota.copy(texto = nuevoTexto.trim()))
```

Para **eliminar**:

```kotlin
dao.eliminar(nota)
```

Las dos últimas operaciones también van en `viewModelScope.launch`; revisa el archivo completo para los métodos y sus validaciones.

🔔 **Checkpoint 5:** compila y confirma que el ViewModel no importa componentes de Material 3.

## Paso 8 · Pantalla Compose

Edita `MainActivity.kt`. [Ver archivo Kotlin completo](referencia/app/src/main/java/cl/duoc/misnotasroom/MainActivity.kt).

El estado de la lista es **reactivo**:

```kotlin
val notas by vm.notas.collectAsStateWithLifecycle(
    initialValue = emptyList()
)
```

Mantén dos estados locales de formulario:

```kotlin
var texto by remember { mutableStateOf("") }
var notaEnEdicion by remember { mutableStateOf<Nota?>(null) }
```

Construye en orden:

1. Un `Column` con título «Mis Notas».
2. Un `OutlinedTextField` controlado por `texto`.
3. Un botón Guardar/Actualizar, deshabilitado si `texto.isBlank()`.
4. Un botón «Cancelar edición» visible solo cuando corresponde.
5. Una `LazyColumn` que muestre una `Card` por nota.
6. Dos acciones por `Card`: Editar y Eliminar.

El botón principal decide la operación sin realizar SQL:

```kotlin
val seleccionada = notaEnEdicion
if (seleccionada == null) vm.guardar(texto)
else vm.modificar(seleccionada, texto)
texto = ""
notaEnEdicion = null
```

Para editar, carga la nota en el campo:

```kotlin
notaEnEdicion = nota
texto = nota.texto
```

Para borrar, `vm.borrar(nota)`. Si la nota estaba seleccionada para edición, limpia el formulario. El código de referencia resuelve este detalle.

🔔 **Checkpoint 6:** la aplicación abre con contador 0; guardar un texto lo muestra en pantalla. La lista debe cambiar sin reiniciar la Activity.

## Flujo de extremo a extremo

```text
campo → botón → ViewModel → DAO → SQLite
                                    ↓
Compose ← Flow observado ← SELECT reactivo
```

El Composable **no** abre la base de datos ni ejecuta SQL. El ViewModel **no** dibuja botones.
