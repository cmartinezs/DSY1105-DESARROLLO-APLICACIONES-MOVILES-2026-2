package cl.duoc.misnotasroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotaDao {
    @Insert
    suspend fun insertar(nota: Nota)

    @Query("SELECT * FROM notas ORDER BY id DESC")
    fun obtenerTodas(): Flow<List<Nota>>

    @Update
    suspend fun actualizar(nota: Nota)

    @Delete
    suspend fun eliminar(nota: Nota)
}
