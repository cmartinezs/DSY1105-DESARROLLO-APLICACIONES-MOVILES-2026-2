package cl.duoc.rutalocal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

private object Rutas {
    const val INICIO = "inicio"
    const val LUGARES = "lugares"
    const val DETALLE = "detalle/{id}"

    fun detalle(id: Int) = "detalle/$id"
}

@Composable
fun RutaLocalApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.INICIO
    ) {
        composable(Rutas.INICIO) {
            PantallaInicio(
                onExplorar = { navController.navigate(Rutas.LUGARES) }
            )
        }

        composable(Rutas.LUGARES) {
            PantallaLugares(
                lugares = lugaresDemo,
                onSeleccionar = { id ->
                    navController.navigate(Rutas.detalle(id))
                }
            )
        }

        composable(Rutas.DETALLE) { entry ->
            val id = entry.arguments?.getString("id")?.toIntOrNull()
            val lugar = lugaresDemo.find { it.id == id }

            PantallaDetalle(
                lugar = lugar,
                onVolver = { navController.popBackStack() }
            )
        }
    }
}

@Composable
private fun PantallaInicio(onExplorar: () -> Unit) {
    ContenedorAdaptable {
        Text("RutaLocal", style = MaterialTheme.typography.headlineMedium)
        Text(
            "Consulta rápidamente lugares útiles y su ubicación de referencia.",
            style = MaterialTheme.typography.bodyLarge
        )
        Button(onClick = onExplorar) {
            Text("Explorar lugares")
        }
    }
}

@Composable
private fun PantallaLugares(
    lugares: List<Lugar>,
    onSeleccionar: (Int) -> Unit
) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 720.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Text(
                        "Lugares",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }

                items(lugares) { lugar ->
                    Card(
                        onClick = { onSeleccionar(lugar.id) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                lugar.nombre,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(lugar.categoria)
                            Text(
                                lugar.referencia,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PantallaDetalle(
    lugar: Lugar?,
    onVolver: () -> Unit
) {
    ContenedorAdaptable {
        Text(
            lugar?.nombre ?: "Lugar no encontrado",
            style = MaterialTheme.typography.headlineMedium
        )

        if (lugar == null) {
            Text("No existe un lugar asociado al identificador recibido.")
        } else {
            Text(
                lugar.categoria,
                style = MaterialTheme.typography.titleMedium
            )
            Text(lugar.descripcion)
            Text(
                "Referencia: ${lugar.referencia}",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Button(onClick = onVolver) {
            Text("Volver")
        }
    }
}

@Composable
private fun ContenedorAdaptable(
    content: @Composable ColumnScope.() -> Unit
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
                verticalArrangement = Arrangement.spacedBy(12.dp),
                content = content
            )
        }
    }
}
