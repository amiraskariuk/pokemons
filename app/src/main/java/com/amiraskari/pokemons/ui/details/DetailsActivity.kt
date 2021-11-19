package com.amiraskari.pokemons.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.amiraskari.pokemons.R
import com.amiraskari.pokemons.databinding.ActivityDetailsBinding
import com.amiraskari.pokemons.model.PokemonDetailsResponse
import com.amiraskari.pokemons.network.ApiClient
import com.amiraskari.pokemons.network.ApiMedium
import com.amiraskari.pokemons.utils.Status
import com.amiraskari.pokemons.viewmodel.details.DetailsViewModel
import com.amiraskari.pokemons.viewmodel.details.DetailsViewModelFactory
import com.bumptech.glide.Glide
import java.lang.StringBuilder

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var detailsViewModel: DetailsViewModel
    private lateinit var rootView: ViewGroup
    private var TAG: String = "DetailsActivityInfo"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        supportActionBar?.hide()
        detailsViewModel = ViewModelProvider(this,DetailsViewModelFactory(ApiMedium(ApiClient.apiService))).get(
            DetailsViewModel::class.java)
        binding.lifecycleOwner = this
        val id = intent.getStringExtra("id")
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        if(!id.toString().equals("null"))
            setupObservers(Integer.valueOf(id))
    }


    fun setupObservers(id: Int) {

        detailsViewModel.getPokemonDetails(id).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.cardView.visibility = View.VISIBLE
                        binding.progress.visibility = View.GONE
                        resource.data?.let { item -> setData(item) }
                    }
                    Status.ERROR -> {
                        binding.cardView.visibility = View.VISIBLE
                        binding.progress.visibility = View.GONE
                        Log.i(TAG, "setupObservers: " + it.message)
                        Toast.makeText(this, "An error occurred!", Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.cardView.visibility = View.VISIBLE
                        binding.progress.visibility = View.GONE
                    }
                }
            }
        })

    }

    fun setData(item: PokemonDetailsResponse) {

        Glide
            .with(this)
            .load(item.sprites.other.officialArtwork.frontDefault)
            .centerCrop()
            .placeholder(R.drawable.pokemonball)
            .error(R.drawable.pokemonball)
            .into(binding.pokemonAvatar)

        binding.nameTextValue.text = item.name.replaceFirstChar(Char::titlecase)
        binding.weightTextValue.text = item.weight.toString() + " Kg"
        val cm = Integer.valueOf(item.height) * 30.8
        binding.heightTextValue.text = item.height.toString() + " Ft (" + cm.toString() + " Cm)"
        val types = StringBuilder()
        for(type in item.types){
            types.append(type.type.name.replaceFirstChar(Char::titlecase) + "  ")
        }
        binding.typeTextValue.text = types.toString()

    }

}