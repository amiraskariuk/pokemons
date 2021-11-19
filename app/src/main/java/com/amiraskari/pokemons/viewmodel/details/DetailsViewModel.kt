package com.amiraskari.pokemons.viewmodel.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amiraskari.pokemons.repo.details.DetailsRepository
import com.amiraskari.pokemons.utils.Resource
import kotlinx.coroutines.Dispatchers

class DetailsViewModel(private val detailsRepository: DetailsRepository) : ViewModel() {

    fun getPokemonDetails(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = detailsRepository.getPokemonDetails(id)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}