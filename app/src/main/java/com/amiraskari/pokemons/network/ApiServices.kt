package com.amiraskari.pokemons.network

import com.amiraskari.pokemons.model.PokemonDetailsResponse
import com.amiraskari.pokemons.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("pokemon")
    suspend fun getPokemons(): PokemonResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path(value = "id", encoded = false) id: Int): PokemonDetailsResponse

}