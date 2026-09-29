package cl.duoc.registrousuario.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.duoc.registrousuario.ui.screen.RegistroScreen
import cl.duoc.registrousuario.ui.screen.ResumenScreen
import cl.duoc.registrousuario.viewmodel.UsuarioViewModel

@Composable
fun RegistroNavigation(
    viewModel: UsuarioViewModel
) {
    val navController = rememberNavController()
    val state by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = "registro"
    ) {
        composable("registro") {
            RegistroScreen(
                state = state,
                onNombreChange = viewModel::onNombreChange,
                onCorreoChange = viewModel::onCorreoChange,
                onClaveChange = viewModel::onClaveChange,
                onDireccionChange = viewModel::onDireccionChange,
                onAceptaTerminosChange = viewModel::onAceptaTerminosChange,
                onContinuar = {
                    if (viewModel.validarFormulario()) {
                        navController.navigate("resumen")
                    }
                }
            )
        }

        composable("resumen") {
            ResumenScreen(
                state = state,
                onVolver = {
                    navController.popBackStack()
                }
            )
        }
    }
}
