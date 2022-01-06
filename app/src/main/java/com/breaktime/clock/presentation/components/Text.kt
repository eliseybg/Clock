package com.breaktime.clock.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun StyledText(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
    color: Color = textStyle.color,
    fontWeight: FontWeight? = textStyle.fontWeight,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = textStyle.fontSize,
        fontFamily = textStyle.fontFamily,
        fontWeight = fontWeight,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}


