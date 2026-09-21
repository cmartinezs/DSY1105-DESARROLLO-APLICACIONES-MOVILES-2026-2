package cl.duoc.pocketlog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.duoc.pocketlog.domain.Registro

@Composable
fun PocketLogScreen(
    state: PocketLogUiState,
    onTituloChange: (String) -> Unit,
    onCategoriaChange: (String) -> Unit,
    onAgregar: () -> Unit,
    onCompletar: (Int) -> Unit,
    onFiltroChange: (FiltroEstado) -> Unit,
    onVerDetalle: (Int) -> Unit
) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 720.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Registros", style = MaterialTheme.typography.headlineMedium)
                Text(
                    "Total ${state.total} · Pendientes ${state.pendientes} · Completados ${state.completados}",
                    style = MaterialTheme.typography.bodyLarge
                )

                OutlinedTextField(
                    value = state.titulo,
                    onValueChange = onTituloChange,
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = state.categoria,
                    onValueChange = onCategoriaChange,
                    label = { Text("Categoría") },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(onClick = onAgregar, modifier = Modifier.fillMaxWidth()) {
                    Text("Agregar registro")
                }

                state.mensaje?.let {
                    Text(it, style = MaterialTheme.typography.bodyMedium)
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FiltroEstado.entries.forEach { filtro ->
                        FilterChip(
                            selected = state.filtro == filtro,
                            onClick = { onFiltroChange(filtro) },
                            label = {
                                Text(filtro.name.lowercase().replaceFirstChar(Char::uppercase))
                            }
                        )
                    }
                }

                Spacer(Modifier.height(4.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.registros, key = { it.id }) { registro ->
                        RegistroCard(
                            registro = registro,
                            onCompletar = { onCompletar(registro.id) },
                            onVerDetalle = { onVerDetalle(registro.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RegistroCard(
    registro: Registro,
    onCompletar: () -> Unit,
    onVerDetalle: () -> Unit
) {
    Card(
        onClick = onVerDetalle,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                "${registro.id}. ${registro.titulo}",
                style = MaterialTheme.typography.titleMedium
            )
            Text("Categoría: ${registro.categoria}")
            Text(if (registro.completado) "COMPLETADO" else "PENDIENTE")

            if (!registro.completado) {
                Button(onClick = onCompletar) {
                    Text("Completar")
                }
            }
        }
    }
}
