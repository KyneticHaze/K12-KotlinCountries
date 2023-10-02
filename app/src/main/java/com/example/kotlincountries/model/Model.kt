package com.example.kotlincountries.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Country(

    @ColumnInfo("name")
    @SerializedName("name")
    val countryName: String?,

    @ColumnInfo("region")
    @SerializedName("region")
    val countryRegion: String?,

    @ColumnInfo("capital")
    @SerializedName("capital")
    val countryCapital: String?,

    @ColumnInfo("currency")
    @SerializedName("currency")
    val countryCurrency: String?,

    @ColumnInfo("language")
    @SerializedName("language")
    val countryLanguage: String?,

    @ColumnInfo("flag")
    @SerializedName("flag")
    val imageUrl: String?
) {
    // Constructor'da tanımlamamamızın nedeni, her obje oluşturacağımızda bir tane de uuid oluşturmasın diye
    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0
}