package com.breaktime.clock.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {
    @Insert
    suspend fun addAlarm(alarm: AlarmEntity)

    @Delete
    suspend fun deleteAlarm(alarm: AlarmEntity)

    @Update
    suspend fun updateAlarm(alarm: AlarmEntity)

    @Query("DELETE FROM alarm_database")
    suspend fun deleteAllAlarms()

    @Query("SELECT * FROM alarm_database ORDER BY id")
    fun readAllData(): Flow<List<AlarmEntity>>
}