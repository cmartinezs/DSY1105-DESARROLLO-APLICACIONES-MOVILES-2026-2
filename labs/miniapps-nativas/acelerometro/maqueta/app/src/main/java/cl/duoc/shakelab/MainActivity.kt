package cl.duoc.shakelab

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

import kotlin.math.sqrt

data class UiState(val x:Float=0f,val y:Float=0f,val z:Float=9.8f,val status:String="Reposo",val events:Int=0)
class FakeSource{fun rest()=Triple(0.1f,0.1f,9.7f);fun move()=Triple(2.5f,1.8f,9.0f);fun shake()=Triple(12.5f,8.0f,15.0f)}
class LabViewModel:ViewModel(){
    private val source=FakeSource();var state by mutableStateOf(UiState());private set
    private fun apply(v:Triple<Float,Float,Float>){val m=sqrt(v.first*v.first+v.second*v.second+v.third*v.third);val st=if(m>18f)"Sacudida detectada" else if(m>11f)"Movimiento leve" else "Reposo";state=UiState(v.first,v.second,v.third,st,state.events+(if(st=="Sacudida detectada")1 else 0))}
    fun rest(){apply(source.rest())};fun move(){apply(source.move())};fun shake(){apply(source.shake())}
}
class MainActivity:ComponentActivity(){override fun onCreate(savedInstanceState:Bundle?){super.onCreate(savedInstanceState);setContent{MaterialTheme{App()}}}}
@Composable fun App(vm:LabViewModel=viewModel()){
    val nav=rememberNavController()
    NavHost(nav,"inicio"){
        composable("inicio"){LabScreen("ShakeLab","Maqueta de acelerómetro y umbrales"){Button({nav.navigate("monitor")}){Text("Abrir monitor")}}}
        composable("monitor"){val s=vm.state;LabScreen("Monitor",s.status){Text("X "+s.x+" · Y "+s.y+" · Z "+s.z);Row(horizontalArrangement=Arrangement.spacedBy(8.dp)){OutlinedButton(vm::rest){Text("Reposo")};OutlinedButton(vm::move){Text("Mover")};Button(vm::shake){Text("Sacudir")}};Text("Sacudidas: "+s.events);Button({nav.navigate("historial")}){Text("Ver historial")}}}
        composable("historial"){LabScreen("Historial","Eventos detectados"){Text(vm.state.events.toString()+" sacudidas superaron el umbral.");OutlinedButton({nav.popBackStack()}){Text("Volver")}}}
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
