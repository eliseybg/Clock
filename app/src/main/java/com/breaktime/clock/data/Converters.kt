package com.breaktime.clock.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.LinkedHashMap

class Converters {
    @TypeConverter
    fun fromLinkedHashMap(value: LinkedHashMap<String, Boolean>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toLinkedHashMap(value: String): LinkedHashMap<String, Boolean> {
        return Gson().fromJson(value, object : TypeToken<LinkedHashMap<String, Boolean>>() {}.type)
    }

    @TypeConverter
    fun fromPair(value: Pair<Int, Int>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toPair(value: String): Pair<Int, Int> {
        return Gson().fromJson(value, object : TypeToken<Pair<Int, Int>>() {}.type)
    }
}