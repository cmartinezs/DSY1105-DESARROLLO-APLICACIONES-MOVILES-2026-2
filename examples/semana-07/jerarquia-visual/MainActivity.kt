package cl.duoc.ejemplos.semana07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { ResumenEstudio() } }
    }
}

@Composable
fun ResumenEstudio() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Mi jornada", style = MaterialTheme.typography.headlineMedium)
        Text("Tres bloques para organizar el estudio de hoy.", style = MaterialTheme.typography.bodyMedium)

        listOf("Android", "Kotlin", "Git").forEach { tema ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(tema, style = MaterialTheme.typography.titleMedium)
                    Text("45 minutos", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
