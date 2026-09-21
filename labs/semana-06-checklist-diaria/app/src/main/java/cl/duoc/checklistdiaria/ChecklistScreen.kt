package cl.duoc.checklistdiaria

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
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
    Scaffold { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Checklist diaria", style = MaterialTheme.typography.headlineMedium)
            Text("Total ${state.total} · Completadas ${state.completadas}")
            OutlinedTextField(
                value = state.titulo,
                onValueChange = onTituloChange,
                label = { Text("Nueva tarea") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = onAgregar, modifier = Modifier.fillMaxWidth()) {
                Text("Agregar")
            }
            state.mensaje?.let { Text(it) }
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(state.tareas, key = { it.id }) { tarea ->
                    Card(
                        onClick = { onAlternar(tarea.id) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(Modifier.padding(12.dp)) {
                            Text(tarea.titulo, style = MaterialTheme.typography.titleMedium)
                            Text(if (tarea.completada) "COMPLETADA" else "PENDIENTE")
                        }
                    }
                }
            }
        }
    }
}
