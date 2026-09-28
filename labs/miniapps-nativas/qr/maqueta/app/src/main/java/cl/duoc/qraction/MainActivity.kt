package cl.duoc.qraction

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

data class UiState(val status:String="Esperando",val payload:String?=null,val action:String?=null)
class FakeSource{fun station()="station:CITT-07";fun url()="url:https://example.invalid/recurso";fun invalid()="???"}
class LabViewModel:ViewModel(){
    private val source=FakeSource();var state by mutableStateOf(UiState());private set
    private fun parse(value:String){state=when{value.startsWith("station:")->UiState("QR válido",value,"Abrir ficha");value.startsWith("url:")->UiState("QR válido",value,"Mostrar recurso");else->UiState("QR inválido",value,null)}}
    fun station(){parse(source.station())};fun url(){parse(source.url())};fun invalid(){parse(source.invalid())};fun reset(){state=UiState()}
}
class MainActivity:ComponentActivity(){override fun onCreate(savedInstanceState:Bundle?){super.onCreate(savedInstanceState);setContent{MaterialTheme{App()}}}}
@Composable fun App(vm:LabViewModel=viewModel()){
    val nav=rememberNavController()
    NavHost(nav,"inicio"){
        composable("inicio"){LabScreen("QRAction","Maqueta de lectura, validación y acción"){Button({nav.navigate("scanner")}){Text("Abrir escáner simulado")}}}
        composable("scanner"){LabScreen("Escáner","Selecciona una lectura simulada"){Button({vm.station();nav.navigate("resultado")}){Text("QR estación válido")};Button({vm.url();nav.navigate("resultado")}){Text("QR recurso válido")};OutlinedButton({vm.invalid();nav.navigate("resultado")}){Text("QR inválido")}}}
        composable("resultado"){val s=vm.state;LabScreen("Resultado",s.status){Text("Payload: "+(s.payload?:"—"));Text("Acción: "+(s.action?:"Ninguna"));Button({},enabled=s.action!=null){Text("Ejecutar acción")};OutlinedButton({vm.reset();nav.popBackStack()}){Text("Reintentar")}}}
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
