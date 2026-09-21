package cl.duoc.pocketlog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.duoc.pocketlog.domain.Registro

@Composable
fun RegistroDetalleScreen(
    registro: Registro?,
    onVolver: () -> Unit
) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 720.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    registro?.titulo ?: "Registro no encontrado",
                    style = MaterialTheme.typography.headlineMedium
                )

                if (registro != null) {
                    Text(
                        "Categoría: ${registro.categoria}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(if (registro.completado) "Estado: completado" else "Estado: pendiente")
                    Text("Identificador: ${registro.id}")
                } else {
                    Text("El registro solicitado no existe.")
                }

                Button(onClick = onVolver) {
                    Text("Volver")
                }
            }
        }
    }
}
