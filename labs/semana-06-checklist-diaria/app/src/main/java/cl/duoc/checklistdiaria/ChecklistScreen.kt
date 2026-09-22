package cl.duoc.checklistdiaria

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChecklistScreen(
    state: ChecklistUiState,
    onTituloChange: (String) -> Unit,
    onAgregar: () -> Unit,
    onAlternar: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Checklist diaria",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Total ${state.total} · Completadas ${state.completadas}")

        OutlinedTextField(
            value = state.titulo,
            onValueChange = onTituloChange,
            label = { Text("Nueva tarea") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onAgregar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar")
        }

        state.mensaje?.let { mensaje ->
            Text(mensaje)
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = state.tareas,
                key = { it.id }
            ) { tarea ->
                Card(
                    onClick = { onAlternar(tarea.id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = tarea.titulo,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            if (tarea.completada) {
                                "COMPLETADA"
                            } else {
                                "PENDIENTE"
                            }
                        )
                    }
                }
            }
        }
    }
}
