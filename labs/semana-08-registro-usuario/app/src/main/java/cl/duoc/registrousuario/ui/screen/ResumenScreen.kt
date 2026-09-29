package cl.duoc.registrousuario.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.duoc.registrousuario.model.UsuarioUiState

@Composable
fun ResumenScreen(
    state: UsuarioUiState,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Resumen",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Nombre: " + state.nombre)
        Text("Correo: " + state.correo)
        Text("Dirección: " + state.direccion)

        Text(
            if (state.aceptaTerminos)
                "Términos aceptados"
            else
                "Términos no aceptados"
        )

        Button(onClick = onVolver) {
            Text("Volver")
        }
    }
}
