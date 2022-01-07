package com.breaktime.clock.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.breaktime.clock.presentation.screens.alarm.AlarmFragment
import com.breaktime.clock.ui.theme.ClockTheme
import com.breaktime.clock.ui.theme.LightColors

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
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            AlarmFragment()
        }

    }
}