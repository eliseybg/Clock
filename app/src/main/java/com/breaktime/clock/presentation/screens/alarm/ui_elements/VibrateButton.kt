package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Vibration
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.breaktime.clock.presentation.components.StyledText
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun VibrateButton(
    modifier: Modifier = Modifier,
    vibrateState: Boolean,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Default.Vibration,
            contentDescription = "Vibration icon",
            tint = LightColors.white
        )

        StyledText(
            modifier = Modifier.padding(start = 10.dp),
            text = "Vibrate",
            textStyle = MaterialTheme.typography.subtitle1,
            color = if (vibrateState) LightColors.textLight
            else LightColors.textDark
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = if (vibrateState) Icons.Filled.CheckCircle
            else Icons.Outlined.Circle,
            contentDescription = "check icon",
            tint = if (vibrateState) LightColors.blue
            else LightColors.white
        )
    }
}