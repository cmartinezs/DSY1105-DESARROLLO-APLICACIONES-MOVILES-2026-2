package cl.duoc.ejemplos.semana07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { AppDosDestinos() } }
    }
}

@Composable
fun AppDosDestinos() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            PantallaInicio(onVerDetalle = { navController.navigate("detalle") })
        }
        composable("detalle") {
            PantallaDetalle(onVolver = { navController.popBackStack() })
        }
    }
}

@Composable
fun PantallaInicio(onVerDetalle: () -> Unit) {
    PantallaCentrada {
        Text("Inicio", style = MaterialTheme.typography.headlineMedium)
        Button(onClick = onVerDetalle) { Text("Ver detalle") }
    }
}

@Composable
fun PantallaDetalle(onVolver: () -> Unit) {
    PantallaCentrada {
        Text("Detalle", style = MaterialTheme.typography.headlineMedium)
        Button(onClick = onVolver) { Text("Volver") }
    }
}

@Composable
private fun PantallaCentrada(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}
