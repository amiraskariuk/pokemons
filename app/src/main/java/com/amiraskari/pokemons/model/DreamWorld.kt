package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class DreamWorld (

   @SerializedName("front_default") var frontDefault : String,
   @SerializedName("front_female") var frontFemale : String

)