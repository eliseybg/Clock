package com.breaktime.clock.presentation.screens.alarm

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.breaktime.clock.data.AlarmEntity
import com.breaktime.clock.presentation.screens.alarm.ui_elements.AddAlarmButton

@ExperimentalMaterialApi
@Composable
fun AlarmFragment() {
    Box(modifier = Modifier.fillMaxSize()) {
        AddAlarmButton(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .align(Alignment.BottomCenter)
                .size(90.dp)
                .zIndex(1f),
            onClick = {

            }
        )
        AlarmList(
            alarm = listOf(
                AlarmEntity(alarmTime = 1 to 6),
                AlarmEntity(alarmTime = 23 to 56)
            )
        )
    }
}

@ExperimentalMaterialApi
@Composable
private fun AlarmList(alarm: List<AlarmEntity>) {
    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {
        alarm.forEach {
            AlarmItem(alarmEntity = it)
        }
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(120.dp))
    }
}