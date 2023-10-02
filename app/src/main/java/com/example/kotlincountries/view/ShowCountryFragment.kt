package com.example.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.kotlincountries.R
import com.example.kotlincountries.databinding.FragmentShowCountryBinding
import com.example.kotlincountries.util.getImageWithGlide
import com.example.kotlincountries.util.placeholderProgressBar
import com.example.kotlincountries.viewModel.ShowCountryViewModel

class ShowCountryFragment : Fragment() {
    private lateinit var binding: FragmentShowCountryBinding
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
        binding = FragmentShowCountryBinding.inflate(inflater, container, false)
        return binding.root
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
                binding.countryName.text = country.countryName
                binding.countryCapital.text = country.countryCapital
                binding.countryRegion.text = country.countryRegion
                binding.countryLanguage.text = country.countryLanguage
                binding.countryCurrency.text = country.countryCurrency
                context?.let {
                    binding.countryImage.getImageWithGlide(country.imageUrl, placeholderProgressBar(it))
                }
            }
        }
    }
}