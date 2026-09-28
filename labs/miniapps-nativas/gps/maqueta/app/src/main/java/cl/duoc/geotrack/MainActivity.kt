package cl.duoc.geotrack

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

data class UiState(val status:String="Sin ubicación", val lat:Double?=null, val lon:Double?=null, val tracking:Boolean=false, val distance:Int=0)
class FakeSource {
    private val points=listOf(-33.4990 to -70.6150,-33.4986 to -70.6144,-33.4981 to -70.6138)
    private var index=0
    fun next():Pair<Double,Double> = points[index++ % points.size]
}
class LabViewModel:ViewModel(){
    private val source=FakeSource()
    var state by mutableStateOf(UiState()); private set
    fun locate(){ val p=source.next(); state=state.copy(status="Ubicación disponible",lat=p.first,lon=p.second) }
    fun toggle(){ state=state.copy(status=if(state.tracking)"Seguimiento detenido" else "Seguimiento activo",tracking=!state.tracking) }
    fun move(){ val p=source.next(); state=state.copy(lat=p.first,lon=p.second,distance=state.distance+62) }
    fun fail(){ state=UiState(status="Ubicación no disponible") }
}
class MainActivity:ComponentActivity(){override fun onCreate(savedInstanceState:Bundle?){super.onCreate(savedInstanceState);setContent{MaterialTheme{App()}}}}
@Composable fun App(vm:LabViewModel=viewModel()){
    val nav=rememberNavController()
    NavHost(nav,"inicio"){
        composable("inicio"){LabScreen("GeoTrack","Maqueta de GPS y seguimiento"){Button({nav.navigate("ubicacion")}){Text("Comenzar")}}}
        composable("ubicacion"){val s=vm.state;LabScreen("Ubicación",s.status){
            Text("Lat: "+(s.lat?.toString()?:"—"));Text("Lon: "+(s.lon?.toString()?:"—"))
            Row(horizontalArrangement=Arrangement.spacedBy(8.dp)){Button(vm::locate){Text("Simular ubicación")};OutlinedButton(vm::fail){Text("Sin ubicación")}}
            Button({nav.navigate("seguimiento")},enabled=s.lat!=null){Text("Ir a seguimiento")}
        }}
        composable("seguimiento"){val s=vm.state;LabScreen("Seguimiento",s.status){
            Text("Distancia simulada: "+s.distance+" m")
            Button(vm::toggle){Text(if(s.tracking)"Detener" else "Iniciar seguimiento")}
            Button(vm::move,enabled=s.tracking){Text("Simular nueva posición")}
            Button({nav.navigate("resumen")}){Text("Ver resumen")}
        }}
        composable("resumen"){val s=vm.state;LabScreen("Resumen","Recorrido simulado"){Text(s.distance.toString()+" m registrados");OutlinedButton({nav.popBackStack("inicio",false)}){Text("Volver al inicio")}}}
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
