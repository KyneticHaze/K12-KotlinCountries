package com.example.kotlincountries.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.kotlincountries.model.Country
import com.example.kotlincountries.db.CountryDatabase
import kotlinx.coroutines.launch

class ShowCountryViewModel(application: Application) : BaseViewModel(application) {
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(uuid : Int) {

        launch {
            val dao = CountryDatabase(getApplication()).countryDao()
            val country = dao.getOnlyCountry(uuid)
            countryLiveData.value = country
        }

    }
}