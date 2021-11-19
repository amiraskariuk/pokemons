package com.amiraskari.pokemons.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amiraskari.pokemons.network.ApiMedium
import com.amiraskari.pokemons.repo.home.HomeRepository

class HomeViewModelFactory(private val apiMedium: ApiMedium) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(HomeRepository(apiMedium)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}