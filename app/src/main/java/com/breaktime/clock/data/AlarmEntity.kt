package com.breaktime.clock.data

import androidx.room.*
import com.breaktime.clock.util.defaultSelectedDays
import java.util.*

@Entity(tableName = "alarm_database")
data class AlarmEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val alarmTime: Pair<Int, Int>,
    val label: String = "",
    val isActive: Boolean = true,
    val isVibrate: Boolean = true,
    val selectedDays: LinkedHashMap<String, Boolean> = defaultSelectedDays()
)
