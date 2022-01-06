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
import java.lang.StringBuilder

@ExperimentalMaterialApi
@Composable
fun AlarmItem(alarmEntity: AlarmEntity) {
    var expandableState by remember { mutableStateOf(false) }
    var activeState by remember { mutableStateOf(alarmEntity.isActive) }
    var label by remember { mutableStateOf(alarmEntity.label) }
    var activeDaysState by remember { mutableStateOf(getActiveDays(alarmEntity, activeState)) }
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
            .padding(horizontal = 23.dp, vertical = 10.dp),
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
//                            label = TODO()
                            // TODO: 28.12.21 open dialog to write label
                        })
                }

                TimeWidget(
                    text = "05:00",
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
                        activeDaysState = getActiveDays(alarmEntity, activeState)
                    }
                )
                if (expandableState) {
                    DaysActivator(
                        alarmEntity = alarmEntity,
                        onClick = {
                            activeDaysState = getActiveDays(alarmEntity, activeState)
                        }
                    )

                    SoundSelectorButton(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = "Default (Cesium)",
                        onClick = {
                            // TODO: 28.12.21 select sound
                        }
                    )

                    VibrateButton(
                        vibrateState = vibrateState,
                        onClick = { vibrateState = !vibrateState })

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
                        }
                    )
                }
                if (expandableState) {
                    DeleteButton(
                        modifier = Modifier
                            .padding(bottom = 10.dp),
                        onClick = {
                            // TODO: 29.12.21  delete alarm
                        }
                    )
                }
            }
        }
    }
}

private fun getActiveDays(alarmEntity: AlarmEntity, isActiveAlarm: Boolean): String {
    val activeDays = alarmEntity.selectedDays.filter { it.value }
    val days = when (activeDays.size) {
        0 -> if (isActiveAlarm) "Tomorrow" else "Not scheduled"
        1 -> activeDays.keys.first()
        7 -> "Every day"
        else -> with(StringBuilder()) {
            activeDays.keys.forEach {
                append(it.substring(0, 3)).append(", ")
            }
            substring(0, length - 2).toString()
        }
    }
    return days
}
