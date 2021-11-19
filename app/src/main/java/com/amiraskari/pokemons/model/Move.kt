package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class Move (

   @SerializedName("name") var name : String,
   @SerializedName("url") var url : String

)