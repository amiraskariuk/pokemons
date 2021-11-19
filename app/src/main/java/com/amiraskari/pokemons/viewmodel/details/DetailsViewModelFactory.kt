package com.amiraskari.pokemons.viewmodel.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amiraskari.pokemons.network.ApiMedium
import com.amiraskari.pokemons.repo.details.DetailsRepository

class DetailsViewModelFactory(private val apiMedium: ApiMedium) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(DetailsRepository(apiMedium)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}