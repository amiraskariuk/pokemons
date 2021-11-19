package com.amiraskari.pokemons.repo.home

import com.amiraskari.pokemons.network.ApiMedium

class HomeRepository(private val apiMedium: ApiMedium) {

    suspend fun getPokemons() = apiMedium.getPokemons()
}