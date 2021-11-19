package com.amiraskari.pokemons.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amiraskari.pokemons.R
import com.amiraskari.pokemons.adapter.HomeAdapter
import com.amiraskari.pokemons.databinding.ActivityHomeBinding
import com.amiraskari.pokemons.model.PokemonResponse
import com.amiraskari.pokemons.model.Results
import com.amiraskari.pokemons.network.ApiClient
import com.amiraskari.pokemons.network.ApiMedium
import com.amiraskari.pokemons.ui.details.DetailsActivity
import com.amiraskari.pokemons.utils.Status
import com.amiraskari.pokemons.viewmodel.home.HomeViewModel
import com.amiraskari.pokemons.viewmodel.home.HomeViewModelFactory

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var detailsViewModel: HomeViewModel
    private lateinit var adapter: HomeAdapter
    private lateinit var rootView: ViewGroup
    private var TAG: String = "HomeActivityInfo"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        supportActionBar?.hide()
        detailsViewModel = ViewModelProvider(this,
            HomeViewModelFactory(ApiMedium(ApiClient.apiService))
        ).get(
            HomeViewModel::class.java)
        binding.lifecycleOwner = this

        initAdapter()
        setupObservers()
    }

    private fun initAdapter(){
        binding.homeRecycler.layoutManager = LinearLayoutManager(this)
        adapter = HomeAdapter { selectedItem: Results ->
            setData(selectedItem)
        }
        binding.homeRecycler.adapter = adapter
    }

    fun setupObservers() {

        detailsViewModel.getPokemons().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.recLayout.visibility = View.VISIBLE
                        binding.progress.visibility = View.GONE
                        resource.data?.let { item -> populateData(item) }
                    }
                    Status.ERROR -> {
                        binding.recLayout.visibility = View.VISIBLE
                        binding.progress.visibility = View.GONE
                        Log.i(TAG, "setupObservers: " + it.message)
                        Toast.makeText(this, "An error occurred!", Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.recLayout.visibility = View.GONE
                        binding.progress.visibility = View.VISIBLE
                    }
                }
            }
        })

    }

    fun populateData(pkemons: PokemonResponse) {
        adapter.apply {
            setList(pkemons.results)
            notifyDataSetChanged()
        }
    }

    fun setData(item: Results) {
        val i = Intent(this, DetailsActivity::class.java).apply {
            val id = item.url.split("/").get(6)
            putExtra("id", id)
        }
        startActivity(i)
    }

}