package cl.duoc.misnotasroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cl.duoc.misnotasroom.data.Nota
import cl.duoc.misnotasroom.ui.NotasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { PantallaNotas() }
        }
    }
}

@Composable
fun PantallaNotas(vm: NotasViewModel = viewModel()) {
    val notas by vm.notas.collectAsStateWithLifecycle(initialValue = emptyList())
    var texto by remember { mutableStateOf("") }
    var notaEnEdicion by remember { mutableStateOf<Nota?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .imePadding()
            .padding(16.dp)
    ) {
        Text("Mis Notas", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Escribe una nota") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {
                val seleccionada = notaEnEdicion
                if (seleccionada == null) vm.guardar(texto)
                else vm.modificar(seleccionada, texto)
                texto = ""
                notaEnEdicion = null
            },
            enabled = texto.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (notaEnEdicion == null) "Guardar nota" else "Actualizar nota")
        }
        if (notaEnEdicion != null) {
            TextButton(onClick = {
                notaEnEdicion = null
                texto = ""
            }) { Text("Cancelar edición") }
        }
        Spacer(Modifier.height(16.dp))
        Text("Notas guardadas: ${notas.size}", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = notas, key = { it.id }) { nota ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(nota.texto, style = MaterialTheme.typography.bodyLarge)
                        Row {
                            TextButton(onClick = {
                                notaEnEdicion = nota
                                texto = nota.texto
                            }) { Text("Editar") }
                            TextButton(onClick = {
                                vm.borrar(nota)
                                if (notaEnEdicion?.id == nota.id) {
                                    notaEnEdicion = null
                                    texto = ""
                                }
                            }) { Text("Eliminar") }
                        }
                    }
                }
            }
        }
    }
}
