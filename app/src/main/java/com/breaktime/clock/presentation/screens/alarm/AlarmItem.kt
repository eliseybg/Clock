package com.breaktime.clock.presentation.screens.alarm

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.breaktime.clock.data.AlarmEntity
import com.breaktime.clock.presentation.screens.alarm.ui_elements.*
import com.breaktime.clock.util.VibratorUtil
import com.breaktime.clock.util.asTime
import com.breaktime.clock.util.getActiveDays
import org.koin.androidx.compose.get

@ExperimentalMaterialApi
@Composable
fun AlarmItem(alarmViewModel: AlarmViewModel, alarmEntity: AlarmEntity) {
    var expandableState by remember { mutableStateOf(false) }
    var activeState by remember { mutableStateOf(alarmEntity.isActive) }
    var label by remember { mutableStateOf(alarmEntity.label) }
    var activeDaysState by remember { mutableStateOf(alarmEntity.getActiveDays(activeState)) }
    var vibrateState by remember { mutableStateOf(alarmEntity.isVibrate) }
    var googleAssistState by remember { mutableStateOf(true) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandableState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(horizontal = 23.dp)
            .padding(top = 10.dp),
        backgroundColor = MaterialTheme.colors.onBackground,
        onClick = {
            expandableState = !expandableState
        },
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            DropDownButton(
                Modifier
                    .align(Alignment.TopEnd)
                    .rotate(rotationState)
                    .padding(vertical = 20.dp),
                onClick = {
                    expandableState = !expandableState
                })

            Column {
                if (expandableState) {
                    LabelField(
                        modifier = Modifier
                            .padding(end = 30.dp),
                        text = label,
                        onClick = {
                            // TODO: 28.12.21 open dialog to write label
                        })
                }

                TimeWidget(
                    text = alarmEntity.alarmTime.asTime(),
                    activeState = activeState,
                    onClick = {
                        // TODO: 6.01.22 open time selector
                    })

                AlarmActivator(
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                    activeState = activeState,
                    text = activeDaysState,
                    onCheckedChange = {
                        activeState = !activeState
                        activeDaysState = alarmEntity.getActiveDays(activeState)
                        alarmViewModel.updateAlarm(alarmEntity.copy(isActive = activeState))
                    }
                )
                if (expandableState) {
                    DaysActivator(
                        alarmEntity = alarmEntity,
                        onClick = {
                            activeDaysState = alarmEntity.getActiveDays(activeState)
                            alarmViewModel.updateAlarm(alarmEntity)
                        }
                    )

                    SoundSelectorButton(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = "Default (Cesium)",
                        onClick = {
                            // TODO: 28.12.21 select sound
                        }
                    )
                    val vibrator = get<VibratorUtil>()
                    VibrateButton(
                        vibrateState = vibrateState,
                        onClick = {
                            vibrateState = !vibrateState
                            alarmViewModel.updateAlarm(alarmEntity.copy(isVibrate = vibrateState))
                            if (vibrateState)
                                vibrator.vibrate()
                        })

                    GoogleAssistantButton(
                        modifier = Modifier
                            .padding(vertical = 10.dp),
                        googleAssistantState = googleAssistState,
                        onClick = {
                            googleAssistState = !googleAssistState
                            // TODO: 6.01.22 open google assistant
                        })
                }
                val isLessThenTwoOursBeforeAlarm = true
                if (activeState && isLessThenTwoOursBeforeAlarm) {
                    DismissButton(
                        modifier = Modifier.padding(bottom = 10.dp),
                        onClick = {
                            activeState = false
                            alarmViewModel.updateAlarm(alarmEntity.copy(isActive = false))
                        }
                    )
                }
                if (expandableState) {
                    DeleteButton(
                        modifier = Modifier
                            .padding(bottom = 10.dp),
                        onClick = {
                            alarmViewModel.deleteAlarm(alarmEntity)
                        }
                    )
                }
            }
        }
    }
}
