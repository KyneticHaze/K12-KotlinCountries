package com.example.kotlincountries.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlincountries.model.Country

@Dao
interface CountryDao {

    @Insert
    suspend fun insertAll(vararg country: Country): List<Long>
    /*
    Insert -> Insert Into
    suspend -> coroutine, pause, resume
    vararg -> multiple country objects
    List<Long> -> primary Keys
     */
    @Query("SELECT * FROM country")
    suspend fun getAllCountries(): List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getOnlyCountry(countryId: Int): Country

    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()
}