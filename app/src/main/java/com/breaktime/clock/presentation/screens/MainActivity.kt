package com.breaktime.clock.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.breaktime.clock.data.AlarmEntity
import com.breaktime.clock.presentation.screens.alarm.AlarmItem
import com.breaktime.clock.ui.theme.ClockTheme
import java.util.*

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var item = AlarmEntity(time = Date(), isRepeat = true)
            item.selectedDays["Monday"] = true
            item.selectedDays["Wednesday"] = true
            ClockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Greeting(name = "d")
                        AlarmItem(item)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(modifier = Modifier.padding(vertical = 16.dp), text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ClockTheme {
        Greeting("Android")
    }
}