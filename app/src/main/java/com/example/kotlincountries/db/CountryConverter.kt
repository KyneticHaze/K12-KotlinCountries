package com.example.kotlincountries.db

import android.net.Uri
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverters

@ProvidedTypeConverter
class CountryConverter {
    @TypeConverters
    fun fromString(value: String): Uri {
        return Uri.parse(value)
    }

    @TypeConverters
    fun toString(value: Uri):String {
        return value.toString()
    }
}