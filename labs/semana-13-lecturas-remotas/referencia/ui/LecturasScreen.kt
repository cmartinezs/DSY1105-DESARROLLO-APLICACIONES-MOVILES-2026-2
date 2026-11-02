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
