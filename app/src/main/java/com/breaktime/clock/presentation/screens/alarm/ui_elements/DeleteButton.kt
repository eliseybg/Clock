package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.breaktime.clock.presentation.components.StyledText
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun DeleteButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier
            .wrapContentWidth(),
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Bin",
            tint = LightColors.white
        )

        StyledText(
            modifier = Modifier.padding(start = 10.dp),
            text = "Delete",
            color = LightColors.textLight,
            textStyle = MaterialTheme.typography.subtitle1
        )
    }
}