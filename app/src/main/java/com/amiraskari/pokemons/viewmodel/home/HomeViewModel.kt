package com.amiraskari.pokemons.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amiraskari.pokemons.repo.home.HomeRepository
import com.amiraskari.pokemons.utils.Resource
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    fun getPokemons() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = homeRepository.getPokemons()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}