package cl.duoc.ejemplos.semana06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ContadorUiState(val valor: Int = 0)

class ContadorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ContadorUiState())
    val uiState: StateFlow<ContadorUiState> = _uiState.asStateFlow()

    fun incrementar() {
        _uiState.value = _uiState.value.copy(valor = _uiState.value.valor + 1)
    }
}

class MainActivity : ComponentActivity() {
    private val viewModel: ContadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val state by viewModel.uiState.collectAsStateWithLifecycle()
                ContadorScreen(state = state, onIncrementar = viewModel::incrementar)
            }
        }
    }
}

@Composable
fun ContadorScreen(
    state: ContadorUiState,
    onIncrementar: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Valor: ${state.valor}")
        Button(onClick = onIncrementar) {
            Text("Incrementar")
        }
    }
}
