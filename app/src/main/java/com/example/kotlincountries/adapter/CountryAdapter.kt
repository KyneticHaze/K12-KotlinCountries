package com.example.kotlincountries.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountries.R
import com.example.kotlincountries.databinding.ItemCountryBinding
import com.example.kotlincountries.model.Country
import com.example.kotlincountries.view.CountriesFragmentDirections

class CountryAdapter(private val countryList: ArrayList<Country>):
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),
        CountryClickListener
{

    inner class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater, R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        /*
                holder.view.country.text = countryList[position].countryName
        holder.view.region.text = countryList[position].countryRegion
        holder.view.imageView.getImageWithGlide(countryList[position].imageUrl,
            placeholderProgressBar(holder.itemView.context)
        )

        holder.itemView.setOnClickListener {
            val action = CountriesFragmentDirections.actionCountriesFragmentToShowCountryFragment(countryList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }
         */

        var country = holder.view.getCountry()
        country = countryList[position]
        holder.view.listener = this
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val uuid = ItemCountryBinding.bind(v).countryUuidText.text.toString().toInt()
        val action = CountriesFragmentDirections.actionCountriesFragmentToShowCountryFragment(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}