package com.breaktime.clock.repository

import com.breaktime.clock.data.AlarmDao
import com.breaktime.clock.data.AlarmEntity

class AlarmRepository(private val userDao: AlarmDao) {
    val readAllData = userDao.readAllData()

    suspend fun addAlarm(alarm: AlarmEntity) =
        userDao.addAlarm(alarm)

    suspend fun deleteAlarm(alarm: AlarmEntity) =
        userDao.deleteAlarm(alarm)

    suspend fun updateAlarm(alarm: AlarmEntity) =
        userDao.updateAlarm(alarm)

    suspend fun deleteAllAlarms() =
        userDao.deleteAllAlarms()

    fun readAllData() =
        userDao.readAllData()
}