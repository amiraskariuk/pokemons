package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class Moves (

   @SerializedName("move") var move : Move,
   @SerializedName("version_group_details") var versionGroupDetails : List<VersionGroupDetails>

)