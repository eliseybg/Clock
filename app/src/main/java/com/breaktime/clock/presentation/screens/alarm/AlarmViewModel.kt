package com.breaktime.clock.presentation.screens.alarm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.breaktime.clock.data.AlarmEntity
import com.breaktime.clock.repository.AlarmRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlarmViewModel(application: Application, private val repository: AlarmRepository) :
    AndroidViewModel(application) {
    val alarms: LiveData<List<AlarmEntity>> = repository.readAllData

    fun addAlarm(alarmEntity: AlarmEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAlarm(alarmEntity)
        }
    }

    fun deleteAlarm(alarmEntity: AlarmEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAlarm(alarmEntity)
        }
    }

    fun updateAlarm(alarmEntity: AlarmEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateAlarm(alarmEntity)
        }
    }

    fun deleteAllAlarms() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllAlarms()
        }
    }
}