package com.breaktime.clock.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.breaktime.clock.data.AlarmEntity
import com.breaktime.clock.presentation.screens.TopAppBarContent
import com.breaktime.clock.presentation.screens.alarm.AlarmItem
import com.breaktime.clock.ui.theme.ClockTheme
import com.breaktime.clock.ui.theme.LightColors
import java.util.*

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClockTheme {
                Scaffold(
                    topBar = { TopAppBarContent("Alarm") },
                    content = { MainContent() },
                    backgroundColor = LightColors.background
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MainContent() {
    var item = AlarmEntity(time = Date(), isRepeat = true)
    item.selectedDays["Monday"] = true
    item.selectedDays["Wednesday"] = true
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            AlarmItem(item)
        }

    }
}