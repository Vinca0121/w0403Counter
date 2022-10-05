package kr.ac.kumoh.s20180287.prof.w0403counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20180287.prof.w0403counter.ui.theme.W0403CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Column{
                    Counter()
                    Counter()
                    Counter()
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    W0403CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Counter() {
    var count by remember {
        mutableStateOf(10)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "$count", fontSize = 100.sp)
        Row{
            Button(modifier = Modifier
                .weight(0.5f)
                .padding(3.dp),
                
                onClick = {
                    count++
                }
            ){
                Text(text = "증가")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(modifier = Modifier
                .weight(0.5f)
                .padding(3.dp),
                onClick = {
                    count--
                }
            ){
                Text(text = "감소")
            }
        }

    }
}

@Preview
@Composable
fun PreviewGreeting() {
    MyApp{Counter()}
}
