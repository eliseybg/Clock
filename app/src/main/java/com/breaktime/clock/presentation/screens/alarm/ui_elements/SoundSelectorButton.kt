package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.breaktime.clock.presentation.components.StyledText
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun SoundSelectorButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Default.NotificationsActive,
            contentDescription = "Alarm icon",
            tint = LightColors.white
        )

        StyledText(
            modifier = Modifier.padding(start = 10.dp),
            text = text,
            textStyle = MaterialTheme.typography.subtitle1,
            color = LightColors.textLight
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}