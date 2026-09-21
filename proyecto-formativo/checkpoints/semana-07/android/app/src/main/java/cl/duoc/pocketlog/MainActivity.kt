package cl.duoc.pocketlog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import cl.duoc.pocketlog.ui.PocketLogNavigation
import cl.duoc.pocketlog.ui.PocketLogViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: PocketLogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                PocketLogNavigation(viewModel = viewModel)
            }
        }
    }
}
