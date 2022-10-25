package com.example.kotlin_hw_1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_hw_1.ui.theme.Kotlinhw1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlinhw1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeWork1()
                }
            }
        }
    }
}

@Composable
fun Plate(n: Int) {
    val modifier = Modifier
        .background(
            if (n % 2 == 0) {
                Color.Red
            }
            else {
                Color.Blue
            }
        )

    Box(
        modifier = Modifier
            .padding(5.dp)
            .size(100.dp)
//            .height(50.dp)
//            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Text("$n", fontSize = 30.sp, color = Color.White, textAlign = TextAlign.Center)
    }
}

@Composable
fun PlateRow(s: Int, f: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .background(Color.Gray)
        ,horizontalArrangement = Arrangement.Center
    ) {
        for (i in s..f) {
            Plate(i)
        }
    }
}

@Composable
fun Board(counter: Int, colAmount: Int) {
    LazyColumn() {
        for (i in 0 .. counter/colAmount) {
            val fin: Int = if (counter >= i * colAmount + colAmount) { i * colAmount + colAmount } else { counter }
            item {
                PlateRow(s = i * colAmount + 1, f = fin)
            }
        }
    }
}

@Composable
fun HomeWork1() {
    val configuration = LocalConfiguration.current
    val colAmount = when (configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> { 3 }
        else -> { 4 }
    }
    var counter by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                /* Bottom app bar content */
                Row(
                    modifier = Modifier
                        .fillMaxWidth(  )
                    ,horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = { counter++ }){
                        Text("Increment", fontSize = 25.sp)
                    }
                    Button(onClick = {
                        counter = when (counter) {
                            0 -> { 0 }
                            else -> { counter - 1 }
                        }
                    } ){
                        Text("Decrement", fontSize = 25.sp)
                    }
                }
            }
        }
    ) {
        // Screen content
        Box (
            modifier = Modifier
                .padding(10.dp)
                ) {
            Board(counter, colAmount)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeWork1Preview() {
    HomeWork1()
}