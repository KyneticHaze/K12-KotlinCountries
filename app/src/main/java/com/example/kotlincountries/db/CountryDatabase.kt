package com.example.kotlincountries.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlincountries.model.Country

@Database(entities = [Country::class], version = 1)
abstract class CountryDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao

    // Singleton pattern -> Tek obje oluşturma, obje oluşmuş ise yenisini oluşturmama
    companion object {
        @Volatile private var instance : CountryDatabase? = null
        // Veritabanımız farklı threadlerde çalıştırılacağı için o threadlerin hepsinde görünür kılınması lazım. O da Volatile anotasyonu ile oluyor.

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context : Context) = Room.databaseBuilder(
            context.applicationContext,
            CountryDatabase::class.java,
            "CountryDatabase")
            .build()
    }
}