package com.breaktime.clock.presentation.screens.alarm

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.breaktime.clock.presentation.screens.alarm.ui_elements.AddAlarmButton
import org.koin.androidx.compose.get

@ExperimentalMaterialApi
@Composable
fun AlarmFragment() {
    val viewModel = get<AlarmViewModel>()
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
        AlarmList(viewModel)
    }
}

@ExperimentalMaterialApi
@Composable
private fun AlarmList(viewModel: AlarmViewModel) {
    val scrollState = rememberScrollState()
    val personList by viewModel.alarms.observeAsState(initial = emptyList())
    Column(Modifier.verticalScroll(scrollState)) {
        personList.forEach {
            AlarmItem(viewModel, alarmEntity = it)
        }
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(120.dp)
        )
    }
}