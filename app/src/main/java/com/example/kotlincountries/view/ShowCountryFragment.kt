package com.example.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.kotlincountries.R
import com.example.kotlincountries.databinding.FragmentShowCountryBinding
import com.example.kotlincountries.util.getImageWithGlide
import com.example.kotlincountries.util.placeholderProgressBar
import com.example.kotlincountries.viewModel.ShowCountryViewModel

class ShowCountryFragment : Fragment() {
    private lateinit var dataBinding: FragmentShowCountryBinding
    private var countryUUID = 0
    private lateinit var viewModel: ShowCountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_show_country, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUUID = ShowCountryFragmentArgs.fromBundle(it).uuid
        }
        viewModel = ViewModelProviders.of(this)[ShowCountryViewModel::class.java]
        viewModel.getDataFromRoom(countryUUID)
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.countryLiveData.observe(viewLifecycleOwner) {country ->
            country?.let {
                dataBinding.selectedCountry = it

                /*
                dataBinding.countryName.text = country.countryName
                dataBinding.countryCapital.text = country.countryCapital
                dataBinding.countryRegion.text = country.countryRegion
                dataBinding.countryLanguage.text = country.countryLanguage
                dataBinding.countryCurrency.text = country.countryCurrency
                context?.let {
                    dataBinding.countryImage.getImageWithGlide(country.imageUrl, placeholderProgressBar(it))
                }
                 */
            }
        }
    }
}