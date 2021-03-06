package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName


data class PokemonResponse (

   @SerializedName("count") var count : Int,
   @SerializedName("next") var next : String,
   @SerializedName("previous") var previous : String,
   @SerializedName("results") var results : List<Results>

)