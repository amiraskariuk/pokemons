package com.amiraskari.pokemons.repo.details

import com.amiraskari.pokemons.network.ApiMedium

class DetailsRepository(private val apiMedium: ApiMedium) {

    suspend fun getPokemonDetails(id: Int) = apiMedium.getPokemonDetails(id)
}