package com.amiraskari.pokemons.network

class ApiMedium(private val apiService: ApiService) {

    suspend fun getPokemons() = apiService.getPokemons()

    suspend fun getPokemonDetails(id: Int) = apiService.getPokemonDetails(id)
}