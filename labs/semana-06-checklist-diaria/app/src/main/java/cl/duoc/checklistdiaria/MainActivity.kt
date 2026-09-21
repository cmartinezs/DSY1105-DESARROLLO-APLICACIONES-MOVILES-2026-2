package cl.duoc.checklistdiaria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class MainActivity : ComponentActivity() {
    private val viewModel: ChecklistViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val state by viewModel.uiState.collectAsStateWithLifecycle()
                ChecklistScreen(
                    state = state,
                    onTituloChange = viewModel::cambiarTitulo,
                    onAgregar = viewModel::agregar,
                    onAlternar = viewModel::alternar
                )
            }
        }
    }
}
