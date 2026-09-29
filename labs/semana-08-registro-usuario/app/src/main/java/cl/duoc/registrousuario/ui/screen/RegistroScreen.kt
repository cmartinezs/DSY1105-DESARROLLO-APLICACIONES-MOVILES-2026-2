package cl.duoc.registrousuario.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.spacedBy
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import cl.duoc.registrousuario.model.UsuarioUiState

@Composable
fun RegistroScreen(
    state: UsuarioUiState,
    onNombreChange: (String) -> Unit,
    onCorreoChange: (String) -> Unit,
    onClaveChange: (String) -> Unit,
    onDireccionChange: (String) -> Unit,
    onAceptaTerminosChange: (Boolean) -> Unit,
    onContinuar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Crear cuenta",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Completa tus datos para continuar.",
            style = MaterialTheme.typography.bodyLarge
        )

        OutlinedTextField(
            value = state.nombre,
            onValueChange = onNombreChange,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Nombre") },
            isError = state.errores.nombre != null,
            supportingText = {
                state.errores.nombre?.let { Text(it) }
            }
        )

        OutlinedTextField(
            value = state.correo,
            onValueChange = onCorreoChange,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Correo") },
            isError = state.errores.correo != null,
            supportingText = {
                state.errores.correo?.let { Text(it) }
            }
        )

        OutlinedTextField(
            value = state.clave,
            onValueChange = onClaveChange,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Clave") },
            visualTransformation = PasswordVisualTransformation(),
            isError = state.errores.clave != null,
            supportingText = {
                state.errores.clave?.let { Text(it) }
            }
        )

        OutlinedTextField(
            value = state.direccion,
            onValueChange = onDireccionChange,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Dirección") },
            isError = state.errores.direccion != null,
            supportingText = {
                state.errores.direccion?.let { Text(it) }
            }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = state.aceptaTerminos,
                onCheckedChange = onAceptaTerminosChange
            )
            Text("Acepto los términos")
        }

        state.errores.terminos?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Button(
            onClick = onContinuar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continuar")
        }
    }
}
