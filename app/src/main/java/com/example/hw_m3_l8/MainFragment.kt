package com.example.hw_m3_l8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw_m3_l8.databinding.FragmentMainBinding


class MainFragment : Fragment(), OnItemClick {

    private lateinit var binding : FragmentMainBinding
    private val characters = arrayListOf<com.example.hw_m3_l8.Character>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characters.add(Character(R.drawable._image_, "Alive", "Rick Sanchez"))
        characters.add(Character(R.drawable.img1, "Alive", "Morty Smith"))
        characters.add(Character(R.drawable.img2, "Alive", "Jerry Smith"))
        characters.add(Character(R.drawable.img3, "Dead", "Albert Einstein"))
        characters.add(Character(R.drawable.img4, "Alive", "Summer Smith"))
        characters.add(Character(R.drawable.img5, "Alive", "Beth Smith"))
        characters.add(Character(R.drawable.img6, "Alive", "Squanchy"))
        characters.add(Character(R.drawable.img7, "Alive", "Birdperson"))
        characters.add(Character(R.drawable.img8, "Alive", "Mr.Goldenfold"))

        val adapter = CharacterAdapter(characters, this)
        binding.recyclerView.adapter = adapter
    }

    override fun onItemClick(photo: Int, alive: String, name: String) {
        findNavController().navigate(R.id.secondFragment,
            bundleOf(KEY_FOR_PHOTO to photo, KEY_FOR_ALIVE to alive, KEY_FOR_NAME to name))
    }

    companion object {

        const val KEY_FOR_PHOTO = "key1"
        const val KEY_FOR_ALIVE = "key2"
        const val KEY_FOR_NAME = "key3"
    }

}