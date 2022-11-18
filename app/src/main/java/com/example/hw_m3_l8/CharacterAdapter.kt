package com.example.hw_m3_l8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw_m3_l8.databinding.ItemCharacterBinding

class CharacterAdapter(private val characters : ArrayList<Character>, private val onItemClick: OnItemClick) :
    Adapter<CharacterAdapter.CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind()
        holder.itemView.setOnClickListener{
            onItemClick.onItemClick(characters.get(position).photo.toString().toInt(),
                characters.get(position).alive.toString(), characters.get(position).name.toString())
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }


    inner class CharacterViewHolder(private val binding : ItemCharacterBinding) : ViewHolder(binding.root) {


        fun bind() {
            val char = characters.get(adapterPosition)
            binding.tvIsAlive.text = char.alive
            binding.tvName.text = char.name
            binding.imvPhoto.setImageResource(char.photo.toString().toInt())
        }
    }
}