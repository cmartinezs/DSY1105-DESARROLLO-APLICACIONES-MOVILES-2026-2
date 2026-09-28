package cl.duoc.photoproof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*

data class UiState(val status:String="Lista para capturar",val preview:String?=null,val confirmed:Boolean=false)
class FakeSource{private var n=1;fun capture():String="evidencia_mock_"+(n++)+".jpg"}
class LabViewModel:ViewModel(){
    private val source=FakeSource();var state by mutableStateOf(UiState());private set
    fun capture(){state=UiState("Captura simulada",source.capture())}
    fun confirm(){state=state.copy(status="Evidencia confirmada",confirmed=true)}
    fun discard(){state=UiState(status="Captura descartada")}
    fun fail(){state=UiState(status="Error simulado de cámara")}
}
class MainActivity:ComponentActivity(){override fun onCreate(savedInstanceState:Bundle?){super.onCreate(savedInstanceState);setContent{MaterialTheme{App()}}}}
@Composable fun App(vm:LabViewModel=viewModel()){
    val nav=rememberNavController()
    NavHost(nav,"inicio"){
        composable("inicio"){LabScreen("PhotoProof","Maqueta de captura y confirmación"){Button({nav.navigate("captura")}){Text("Abrir cámara simulada")}}}
        composable("captura"){LabScreen("Captura",vm.state.status){Button({vm.capture();nav.navigate("preview")}){Text("Simular captura")};OutlinedButton(vm::fail){Text("Simular fallo")}}}
        composable("preview"){val s=vm.state;LabScreen("Vista previa",s.status){
            Surface(Modifier.fillMaxWidth().height(220.dp),tonalElevation=2.dp){Box(contentAlignment=Alignment.Center){Text(s.preview?:"Sin imagen")}}
            Row(horizontalArrangement=Arrangement.spacedBy(8.dp)){Button({vm.confirm();nav.navigate("resultado")}){Text("Confirmar")};OutlinedButton({vm.discard();nav.popBackStack()}){Text("Descartar")}}
        }}
        composable("resultado"){LabScreen("Resultado",vm.state.status){Text(if(vm.state.confirmed)"La evidencia quedó asociada." else "Sin evidencia confirmada.");OutlinedButton({nav.popBackStack("inicio",false)}){Text("Volver al inicio")}}}
    }
}

@Composable
private fun LabScreen(title: String, subtitle: String, content: @Composable ColumnScope.() -> Unit) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            Modifier.fillMaxWidth().widthIn(max = 720.dp).padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(title, style = MaterialTheme.typography.headlineMedium)
            Text(subtitle, style = MaterialTheme.typography.bodyLarge)
            content()
        }
    }
}
