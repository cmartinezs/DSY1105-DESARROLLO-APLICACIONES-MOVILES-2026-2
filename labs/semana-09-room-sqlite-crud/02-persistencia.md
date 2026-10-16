# 02 · Construir una tabla y su CRUD con Room

[← Preparación](01-preparacion.md) · [Siguiente → Interfaz](03-interfaz.md)

## Paso 4 · Entidad: una tabla

Crea `data/Nota.kt`. [Ver archivo Kotlin completo](referencia/app/src/main/java/cl/duoc/misnotasroom/data/Nota.kt).

```kotlin
@Entity(tableName = "notas")
data class Nota(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val texto: String
)
```

`@Entity` representa la tabla; `@PrimaryKey` identifica cada fila; `autoGenerate` permite que Room asigne el ID. Una nota nueva puede construirse como `Nota(texto = "Estudiar Kotlin")`.

🔔 **Checkpoint 2:** `Nota.kt` compila. Explica por qué dos notas podrían tener el mismo texto pero diferente `id`.

## Paso 5 · DAO: operaciones de datos

Crea `data/NotaDao.kt`. [Ver archivo Kotlin completo](referencia/app/src/main/java/cl/duoc/misnotasroom/data/NotaDao.kt).

```kotlin
@Insert suspend fun insertar(nota: Nota)

@Query("SELECT * FROM notas ORDER BY id DESC")
fun obtenerTodas(): Flow<List<Nota>>

@Update suspend fun actualizar(nota: Nota)

@Delete suspend fun eliminar(nota: Nota)
```

Añade las anotaciones de clase e imports del archivo completo. **CRUD:** `@Insert` crea, `@Query` lee, `@Update` modifica por clave primaria, `@Delete` borra.

- `suspend`: las escrituras se ejecutan desde corrutinas; evitamos bloquear el hilo principal.
- `Flow<List<Nota>>`: cuando se modifica la tabla, Room puede emitir la nueva lista.

🔔 **Checkpoint 3:** identifica qué operación contiene SQL explícito. Justifica por qué editar no debería insertar otra fila.

## Paso 6 · Instancia de la base

Crea `data/AppDatabase.kt`. [Ver archivo Kotlin completo](referencia/app/src/main/java/cl/duoc/misnotasroom/data/AppDatabase.kt).

```kotlin
@Database(entities = [Nota::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notaDao(): NotaDao
    // La implementación completa incluye getDatabase(context).
}
```

Usamos un **singleton** con `context.applicationContext`: Room abre `mis_notas.db` una sola vez en este proceso.

🔔 **Checkpoint 4:** compila. Si sale «Cannot find implementation for AppDatabase», revisa KSP, la anotación `@Database` y el error de compilación anterior; **no** crees manualmente `AppDatabase_Impl`.

## Observación

```text
Nota (estructura) → NotaDao (consultas) → AppDatabase (acceso)
```

Por ahora no hay pantalla conectada. En el siguiente scope añadiremos el estado y los botones.
