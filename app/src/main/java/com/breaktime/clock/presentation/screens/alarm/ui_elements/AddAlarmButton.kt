package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.breaktime.clock.presentation.components.RoundButton
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun AddAlarmButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    RoundButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = LightColors.blue
        )
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add alarm",
            tint = LightColors.darkBlue
        )
    }
}