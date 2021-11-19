package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class VersionDetails (

   @SerializedName("rarity") var rarity : Int,
   @SerializedName("version") var version : Version

)