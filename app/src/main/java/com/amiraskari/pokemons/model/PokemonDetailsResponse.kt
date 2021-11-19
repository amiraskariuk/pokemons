package com.amiraskari.pokemons.model

import com.google.gson.annotations.SerializedName

   
data class PokemonDetailsResponse (

   @SerializedName("abilities") var abilities : List<Abilities>,
   @SerializedName("base_experience") var baseExperience : Int,
   @SerializedName("forms") var forms : List<Forms>,
   @SerializedName("game_indices") var gameIndices : List<GameIndices>,
   @SerializedName("height") var height : Int,
   @SerializedName("held_items") var heldItems : List<HeldItems>,
   @SerializedName("id") var id : Int,
   @SerializedName("is_default") var isDefault : Boolean,
   @SerializedName("location_area_encounters") var locationAreaEncounters : String,
   @SerializedName("moves") var moves : List<Moves>,
   @SerializedName("name") var name : String,
   @SerializedName("order") var order : Int,
   @SerializedName("past_types") var pastTypes : List<String>,
   @SerializedName("species") var species : Species,
   @SerializedName("sprites") var sprites : Sprites,
   @SerializedName("stats") var stats : List<Stats>,
   @SerializedName("types") var types : List<Types>,
   @SerializedName("weight") var weight : Int

)