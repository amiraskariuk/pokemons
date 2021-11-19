package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class GenerationIii (

   @SerializedName("emerald") var emerald : Emerald,
   @SerializedName("firered-leafgreen") var fireredLeafgreen : FireredLeafgreen,
   @SerializedName("ruby-sapphire") var rubySapphire : RubySapphire

)