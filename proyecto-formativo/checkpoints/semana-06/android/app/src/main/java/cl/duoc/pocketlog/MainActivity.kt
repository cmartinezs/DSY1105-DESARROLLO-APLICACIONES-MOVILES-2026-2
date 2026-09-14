package cl.duoc.pocketlog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cl.duoc.pocketlog.ui.PocketLogScreen
import cl.duoc.pocketlog.ui.PocketLogViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: PocketLogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val state by viewModel.uiState.collectAsStateWithLifecycle()

                PocketLogScreen(
                    state = state,
                    onTituloChange = viewModel::cambiarTitulo,
                    onCategoriaChange = viewModel::cambiarCategoria,
                    onAgregar = viewModel::agregarRegistro,
                    onCompletar = viewModel::completarRegistro,
                    onFiltroChange = viewModel::cambiarFiltro
                )
            }
        }
    }
}
