package com.breaktime.clock.util

import android.app.Activity
import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator

class VibratorUtil {
    lateinit var activity: Activity

    fun vibrate(timeout: Long = 250L) {
        val vibrationEffect =
            VibrationEffect.createOneShot(timeout, VibrationEffect.DEFAULT_AMPLITUDE)
        val vibrator = activity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
        vibrator?.vibrate(vibrationEffect)
    }
}