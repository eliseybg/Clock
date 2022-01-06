package com.breaktime.clock.data

import java.util.*

data class AlarmEntity(
    val id: Int = 0,
    val time: Date,
    val label: String = "",
    val isActive: Boolean = true,
    val isVibrate: Boolean = false,
    val isRepeat: Boolean = false,
    val selectedDays: LinkedHashMap<String, Boolean> = defaultSelectedDays()
)

private fun defaultSelectedDays(): LinkedHashMap<String, Boolean> {
    val days = LinkedHashMap<String, Boolean>()
    DAYS_NAMES.forEach { day -> days[day] = true }
    return days
}

private val DAYS_NAMES = listOf(
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
)
