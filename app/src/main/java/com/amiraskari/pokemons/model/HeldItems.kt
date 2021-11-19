package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class HeldItems (

   @SerializedName("item") var item : Item,
   @SerializedName("version_details") var versionDetails : List<VersionDetails>

)