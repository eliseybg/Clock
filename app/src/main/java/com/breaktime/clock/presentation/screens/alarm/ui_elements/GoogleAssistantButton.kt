package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.breaktime.clock.R
import com.breaktime.clock.presentation.components.StyledText
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun GoogleAssistantButton(
    modifier: Modifier = Modifier,
    googleAssistantState: Boolean,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_google_assistant_24),
            contentDescription = "Google assistant icon",
            tint = if (googleAssistantState) Color.Unspecified
            else LightColors.white
        )

        StyledText(
            modifier = Modifier.padding(start = 10.dp),
            text = "Google Assistant Routine",
            color = if (googleAssistantState) LightColors.textLight
            else LightColors.textDark,
            textStyle = MaterialTheme.typography.subtitle1
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = if (googleAssistantState) Icons.Default.RemoveCircleOutline
            else Icons.Default.AddCircleOutline,
            contentDescription = "Bin",
            tint = LightColors.white
        )
    }
}