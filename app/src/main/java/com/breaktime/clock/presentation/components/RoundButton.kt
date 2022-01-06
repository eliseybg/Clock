package com.breaktime.clock.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RoundButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    colors: ButtonColors,
    border: BorderStroke? = null,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier,
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        border = border,
        onClick = {
            onClick()
        },
        colors = colors
    ) {
        Row(content = content)
    }
}