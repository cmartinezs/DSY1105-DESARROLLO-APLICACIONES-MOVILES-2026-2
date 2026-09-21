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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

private object Rutas {
    const val INICIO = "inicio"
    const val REGISTROS = "registros"
    const val DETALLE = "detalle/{id}"

    fun detalle(id: Int) = "detalle/$id"
}

@Composable
fun PocketLogNavigation(viewModel: PocketLogViewModel) {
    val navController = rememberNavController()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Rutas.INICIO
    ) {
        composable(Rutas.INICIO) {
            PocketLogHomeScreen(
                total = state.total,
                pendientes = state.pendientes,
                onAbrirRegistros = { navController.navigate(Rutas.REGISTROS) }
            )
        }

        composable(Rutas.REGISTROS) {
            PocketLogScreen(
                state = state,
                onTituloChange = viewModel::cambiarTitulo,
                onCategoriaChange = viewModel::cambiarCategoria,
                onAgregar = viewModel::agregarRegistro,
                onCompletar = viewModel::completarRegistro,
                onFiltroChange = viewModel::cambiarFiltro,
                onVerDetalle = { id -> navController.navigate(Rutas.detalle(id)) }
            )
        }

        composable(Rutas.DETALLE) { entry ->
            val id = entry.arguments?.getString("id")?.toIntOrNull()
            val registro = id?.let(viewModel::obtenerRegistro)

            RegistroDetalleScreen(
                registro = registro,
                onVolver = { navController.popBackStack() }
            )
        }
    }
}

@Composable
private fun PocketLogHomeScreen(
    total: Int,
    pendientes: Int,
    onAbrirRegistros: () -> Unit
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
                Text("PocketLog", style = MaterialTheme.typography.headlineMedium)
                Text(
                    "Tu bitácora personal ahora tiene una navegación clara.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "$total registros · $pendientes pendientes",
                    style = MaterialTheme.typography.titleMedium
                )
                Button(onClick = onAbrirRegistros) {
                    Text("Ver registros")
                }
            }
        }
    }
}
