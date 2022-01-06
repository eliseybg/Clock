package com.breaktime.clock.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun StyledText(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
    color: Color = textStyle.color,
    fontWeight: FontWeight? = textStyle.fontWeight,
    fontSize: TextUnit = textStyle.fontSize,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        fontFamily = textStyle.fontFamily,
        fontWeight = fontWeight,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}


