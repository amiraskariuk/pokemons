package com.amiraskari.pokemons.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amiraskari.pokemons.R
import com.amiraskari.pokemons.databinding.ListItemBinding
import com.amiraskari.pokemons.model.Results


class HomeAdapter(private val clickListener: (Results) -> Unit) :
    RecyclerView.Adapter<HomeViewHolder>() {
    private val pokemonsList = ArrayList<Results>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonsList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(pokemonsList[position], clickListener)
    }

    fun setList(players: List<Results>) {
        pokemonsList.clear()
        pokemonsList.addAll(players)

    }

}

class HomeViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Results, clickListener: (Results) -> Unit) {
        binding.nameTextValue.text = item.name.replaceFirstChar(Char::titlecase)
        binding.listItemLayout.setOnClickListener {
            clickListener(item)
        }
    }
}