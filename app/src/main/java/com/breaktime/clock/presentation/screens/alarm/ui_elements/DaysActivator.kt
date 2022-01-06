package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.breaktime.clock.data.AlarmEntity
import com.breaktime.clock.presentation.components.RoundButton
import com.breaktime.clock.presentation.components.StyledText
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun DaysActivator(
    modifier: Modifier = Modifier,
    alarmEntity: AlarmEntity,
    onClick: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        alarmEntity.selectedDays.forEach { (day, isActive) ->
            var state by remember { mutableStateOf(isActive) }
            RoundButton(
                modifier = Modifier.size(35.dp),
                onClick = {
                    alarmEntity.selectedDays[day] =
                        !alarmEntity.selectedDays[day]!!
                    state = alarmEntity.selectedDays[day]!!
                    onClick(day)
                },
                border = BorderStroke(1.dp, LightColors.mediumGray),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (state) LightColors.lightBlue
                    else LightColors.cardBackground
                )
            ) {
                StyledText(
                    text = day.first().toString(),
                    textStyle = MaterialTheme.typography.subtitle1,
                    fontWeight = if (state) FontWeight.Normal
                    else FontWeight.ExtraBold,
                    color = if (state) LightColors.darkBlue
                    else LightColors.lightGray
                )
            }
        }
    }
}