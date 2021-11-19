package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class VersionGroupDetails (

   @SerializedName("level_learned_at") var levelLearnedAt : Int,
   @SerializedName("move_learn_method") var moveLearnMethod : MoveLearnMethod,
   @SerializedName("version_group") var versionGroup : VersionGroup

)