package cl.duoc.semana07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

data class Categoria(val id: Int, val nombre: String, val descripcion: String)

private val categorias = listOf(
    Categoria(1, "Estudio", "Recursos para organizar una jornada de estudio."),
    Categoria(2, "Salud", "Ideas simples para bienestar cotidiano."),
    Categoria(3, "Tiempo libre", "Actividades para desconectarse y descansar.")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MiniCatalogoApp()
            }
        }
    }
}

@Composable
fun MiniCatalogoApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            PantallaInicio(
                onVerCategorias = { navController.navigate("categorias") }
            )
        }

        composable("categorias") {
            PantallaCategorias(
                onSeleccionar = { id ->
                    navController.navigate("detalle/$id")
                }
            )
        }

        composable("detalle/{id}") { entry ->
            val id = entry.arguments?.getString("id")?.toIntOrNull()
            val categoria = categorias.find { it.id == id }

            PantallaDetalle(
                categoria = categoria,
                onVolver = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun PantallaInicio(onVerCategorias: () -> Unit) {
    PantallaCentrada {
        Text("MiniCatálogo", style = MaterialTheme.typography.headlineMedium)
        Text(
            "Ejemplo de jerarquía visual y navegación estructurada.",
            style = MaterialTheme.typography.bodyLarge
        )
        Button(onClick = onVerCategorias) {
            Text("Ver categorías")
        }
    }
}

@Composable
fun PantallaCategorias(onSeleccionar: (Int) -> Unit) {
    PantallaCentrada {
        Text("Categorías", style = MaterialTheme.typography.headlineMedium)

        categorias.forEach { categoria ->
            Card(
                onClick = { onSeleccionar(categoria.id) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(categoria.nombre, style = MaterialTheme.typography.titleMedium)
                    Text(categoria.descripcion)
                }
            }
        }
    }
}

@Composable
fun PantallaDetalle(categoria: Categoria?, onVolver: () -> Unit) {
    PantallaCentrada {
        Text(
            categoria?.nombre ?: "Categoría no encontrada",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(categoria?.descripcion ?: "El identificador recibido no existe.")
        Button(onClick = onVolver) {
            Text("Volver")
        }
    }
}

@Composable
private fun PantallaCentrada(content: @Composable ColumnScope.() -> Unit) {
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
                verticalArrangement = Arrangement.spacedBy(12.dp),
                content = content
            )
        }
    }
}
