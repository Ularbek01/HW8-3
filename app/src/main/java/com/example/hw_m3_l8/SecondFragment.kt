package com.example.hw_m3_l8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw_m3_l8.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imvBigPhoto.setImageResource(arguments?.getInt(MainFragment.KEY_FOR_PHOTO).toString().toInt())
        binding.tvBigIsAlive.text = arguments?.getString(MainFragment.KEY_FOR_ALIVE)
        binding.tvBigName.text = arguments?.getString(MainFragment.KEY_FOR_NAME)

    }


}