package cl.duoc.orientapp

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

data class UiState(val angle:Int=0,val status:String="Vertical")
class FakeSource { fun normalize(value:Int)=((value%360)+360)%360 }

class LabViewModel:ViewModel(){
    private val source=FakeSource()
    var state by mutableStateOf(UiState()); private set
    fun setAngle(value:Int){
        val a=source.normalize(value)
        val st=when(a){in 45..134->"Horizontal derecha";in 135..224->"Invertido";in 225..314->"Horizontal izquierda";else->"Vertical"}
        state=UiState(a,st)
    }
}

class MainActivity:ComponentActivity(){
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContent{MaterialTheme{App()}}
    }
}

@Composable fun App(vm:LabViewModel=viewModel()){
    val nav=rememberNavController()
    NavHost(nav,"inicio"){
        composable("inicio"){
            LabScreen("OrientApp","Maqueta de orientación y respuesta visual"){
                Button({nav.navigate("monitor")}){Text("Abrir monitor")}
            }
        }
        composable("monitor"){
            val s=vm.state
            LabScreen("Monitor",s.angle.toString()+"° · "+s.status){
                Slider(value=s.angle.toFloat(),onValueChange={vm.setAngle(it.toInt())},valueRange=0f..359f)
                Row(horizontalArrangement=Arrangement.spacedBy(8.dp)){
                    OutlinedButton({vm.setAngle(0)}){Text("0°")}
                    OutlinedButton({vm.setAngle(90)}){Text("90°")}
                    OutlinedButton({vm.setAngle(180)}){Text("180°")}
                }
                Button({nav.navigate("resultado")}){Text("Interpretar")}
            }
        }
        composable("resultado"){
            LabScreen("Resultado",vm.state.status){
                Text("Lectura simulada: "+vm.state.angle+"°")
                Text("Luego esta entrada será reemplazada por el sensor real.")
                OutlinedButton({nav.popBackStack()}){Text("Volver al monitor")}
            }
        }
    }
}

@Composable
private fun LabScreen(title:String,subtitle:String,content:@Composable ColumnScope.()->Unit){
    Box(Modifier.fillMaxSize(),contentAlignment=Alignment.TopCenter){
        Column(Modifier.fillMaxWidth().widthIn(max=720.dp).padding(20.dp),verticalArrangement=Arrangement.spacedBy(12.dp)){
            Text(title,style=MaterialTheme.typography.headlineMedium)
            Text(subtitle,style=MaterialTheme.typography.bodyLarge)
            content()
        }
    }
}
