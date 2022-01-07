package com.breaktime.clock.presentation.screens.alarm

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.breaktime.clock.data.AlarmEntity
import com.breaktime.clock.presentation.screens.alarm.ui_elements.AddAlarmButton
import java.util.*

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
                AlarmEntity(time = Date()),
                AlarmEntity(time = Date())
            )
        )
    }
}

@ExperimentalMaterialApi
@Composable
private fun AlarmList(alarm: List<AlarmEntity>) {
    LazyColumn {
        alarm.forEach {
            item {
                AlarmItem(alarmEntity = it)
            }
        }

    }
}