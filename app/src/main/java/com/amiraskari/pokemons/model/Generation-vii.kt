package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class GenerationVii (

   @SerializedName("icons") var icons : Icons,
   @SerializedName("ultra-sun-ultra-moon") var ultraSunUltraMoon : UltraSunUltraMoon

)