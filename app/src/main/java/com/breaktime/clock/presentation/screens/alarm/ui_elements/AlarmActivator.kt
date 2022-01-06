package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import com.breaktime.clock.presentation.components.StyledText
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun AlarmActivator(
    modifier: Modifier = Modifier,
    activeState: Boolean,
    text: String,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        StyledText(
            modifier = Modifier.weight(1f),
            text = text,
            textStyle = MaterialTheme.typography.subtitle1,
            color = if (activeState) LightColors.textLight
            else LightColors.textDark
        )

        Switch(
            modifier = Modifier
                .alpha(1f)
                .scale(1.5f),
            checked = activeState,
            colors = SwitchDefaults.colors(
                checkedThumbColor = LightColors.darkBlue,
                checkedTrackColor = LightColors.lightBlue,
                uncheckedThumbColor = LightColors.darkBlue,
                uncheckedTrackColor = LightColors.mediumGray,
                checkedTrackAlpha = 1f,
                uncheckedTrackAlpha = 1f
            ),
            onCheckedChange = onCheckedChange
        )
    }
}