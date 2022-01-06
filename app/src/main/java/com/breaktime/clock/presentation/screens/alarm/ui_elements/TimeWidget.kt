package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.breaktime.clock.presentation.components.StyledText
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun TimeWidget(text: String, activeState: Boolean, onClick: () -> Unit) {
    TextButton(
        contentPadding = PaddingValues(0.dp),
        onClick = onClick
    ) {
        StyledText(
            text = text,
            textStyle = MaterialTheme.typography.h1,
            color = if (activeState) LightColors.textLight
            else LightColors.textDark
        )
    }
}