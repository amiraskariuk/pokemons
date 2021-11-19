package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class Gold (

   @SerializedName("back_default") var backDefault : String,
   @SerializedName("back_shiny") var backShiny : String,
   @SerializedName("front_default") var frontDefault : String,
   @SerializedName("front_shiny") var frontShiny : String,
   @SerializedName("front_transparent") var frontTransparent : String

)