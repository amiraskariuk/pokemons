package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class GameIndices (

   @SerializedName("game_index") var gameIndex : Int,
   @SerializedName("version") var version : Version

)