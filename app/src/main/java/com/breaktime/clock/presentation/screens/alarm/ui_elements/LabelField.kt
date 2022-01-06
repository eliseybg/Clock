package com.breaktime.clock.presentation.screens.alarm.ui_elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Label
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.breaktime.clock.presentation.components.StyledText
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun LabelField(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    val (isLabelExist, labelText) = checkLabelText(text)
    Row {
        TextButton(
            modifier = modifier,
            onClick = onClick
        ) {
            Icon(
                imageVector = Icons.Outlined.Label,
                contentDescription = "label icon",
                tint = LightColors.white
            )

            StyledText(
                modifier = Modifier.padding(start = 10.dp),
                text = labelText,
                textStyle = MaterialTheme.typography.subtitle1,
                color = if (isLabelExist) LightColors.textLight
                else LightColors.textDark
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

private fun checkLabelText(text: String) =
    if (text.isNotEmpty()) true to text
    else false to "Add label"
