package com.breaktime.clock.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.breaktime.clock.presentation.components.StyledText
import com.breaktime.clock.ui.theme.LightColors

@Composable
fun TopAppBarContent(title: String) {
    val expanded = remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            StyledText(
                text = title,
                textStyle = MaterialTheme.typography.subtitle1,
                color = LightColors.textLight,
                fontSize = 22.sp
            )
        },
        backgroundColor = LightColors.background,
        elevation = 0.dp,
        actions = {
            Box(
                Modifier.wrapContentSize(Alignment.TopEnd)
            ) {
                IconButton(onClick = {
                    expanded.value = true
                }) {
                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "Localized description",
                        tint = LightColors.textLight
                    )
                }

                DropdownMenu(
                    modifier = Modifier
                        .width(200.dp)
                        .background(color = LightColors.mediumGray),
                    offset = DpOffset(14.dp, 0.dp),
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false },
                ) {
                    DropdownMenuItem(
                        onClick = {
                            expanded.value = false
                        }) {
                        StyledText(
                            text = "Screensaver",
                            textStyle = MaterialTheme.typography.subtitle2,
                            color = LightColors.textLight
                        )
                    }

                    DropdownMenuItem(
                        onClick = {
                            expanded.value = false
                        }) {
                        StyledText(
                            text = "Settings",
                            textStyle = MaterialTheme.typography.subtitle2,
                            color = LightColors.textLight
                        )
                    }

                    DropdownMenuItem(
                        onClick = {
                            expanded.value = false
                        }) {
                        StyledText(
                            text = "Send feedback",
                            textStyle = MaterialTheme.typography.subtitle2,
                            color = LightColors.textLight
                        )
                    }

                    DropdownMenuItem(
                        onClick = {
                            expanded.value = false
                        }) {
                        StyledText(
                            text = "Help",
                            textStyle = MaterialTheme.typography.subtitle2,
                            color = LightColors.textLight
                        )
                    }
                }
            }
        }
    )
}