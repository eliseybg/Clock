package com.breaktime.clock.util

import com.breaktime.clock.data.AlarmEntity
import java.lang.Exception
import java.util.*
import kotlin.collections.LinkedHashMap

private val DAYS_NAMES = listOf(
    "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
)

fun Pair<Int, Int>.asTime() = StringBuilder().apply {
    if (first !in 0..24 || second !in 0..60)
        throw Exception("Time format exception")
    if (first < 10) append("0")
    append("$first:")
    if (second < 10) append("0")
    append(second)
}.toString()

operator fun Pair<Int, Int>.compareTo(another: Pair<Int, Int>) = when {
    first < another.first -> -1
    first > another.first -> 1
    second < another.second -> -1
    second > another.second -> 1
    second == another.second -> 0
    else -> throw Exception()
}

fun AlarmEntity.getActiveDays(isActiveAlarm: Boolean): String {
    val activeDays = this.selectedDays.filter { it.value }
    val calendar = Calendar.getInstance()
    val currentTime = calendar[Calendar.HOUR_OF_DAY] to calendar[Calendar.MINUTE]
    val dayOfAlarm = if (currentTime < this.alarmTime) "Today" else "Tomorrow"
    return when (activeDays.size) {
        0 -> if (isActiveAlarm) dayOfAlarm else "Not scheduled"
        1 -> activeDays.keys.first()
        7 -> "Every day"
        else -> buildString {
            activeDays.keys.forEach {
                append("${it.substring(0, 3)}, ")
            }
            substring(0, length - 2)
        }
    }
}

fun defaultSelectedDays() = LinkedHashMap<String, Boolean>().also {
    DAYS_NAMES.forEach { day -> it[day] = true }
}
