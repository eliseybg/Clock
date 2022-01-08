package com.breaktime.clock.di

import com.breaktime.clock.data.AlarmDatabase
import com.breaktime.clock.presentation.screens.alarm.AlarmViewModel
import com.breaktime.clock.repository.AlarmRepository
import com.breaktime.clock.util.VibratorUtil
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single { AlarmDatabase.getDatabase(androidApplication()).alarmDao() }
    single { AlarmRepository(get()) }
    single { AlarmViewModel(androidApplication(), get()) }
    single { VibratorUtil() }
}