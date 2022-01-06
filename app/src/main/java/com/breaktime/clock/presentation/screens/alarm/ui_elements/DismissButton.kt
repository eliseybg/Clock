package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.breaktime.clock.presentation.components.StyledText
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun DismissButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    TextButton(
        modifier = modifier,
        onClick = onClick
    ) {
        StyledText(
            text = "Dismiss",
            textStyle = MaterialTheme.typography.subtitle1,
            color = LightColors.blue
        )
    }
}