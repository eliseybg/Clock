package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.breaktime.clock.presentation.components.RoundButton
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun DropDownButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    RoundButton(
        modifier = modifier
            .size(25.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = LightColors.mediumGray
        )
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Drop-Down arrow",
            tint = LightColors.white
        )
    }
}