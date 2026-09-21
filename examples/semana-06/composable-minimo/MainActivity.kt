package cl.duoc.ejemplos.semana06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { PantallaBienvenida() } }
    }
}

@Composable
fun PantallaBienvenida() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Mi primera pantalla Compose")
        Text("La interfaz se describe con funciones @Composable.")
        Button(onClick = { }) { Text("Continuar") }
    }
}
