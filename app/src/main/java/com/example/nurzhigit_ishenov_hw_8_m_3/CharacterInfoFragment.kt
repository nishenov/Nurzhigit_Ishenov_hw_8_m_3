package com.example.nurzhigit_ishenov_hw_8_m_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.nurzhigit_ishenov_hw_8_m_3.databinding.FragmentCharacterInfoBinding


class CharacterInfoFragment : Fragment() {
    private lateinit var binding: FragmentCharacterInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharacterInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val deadOrAlive = arguments?.getString("deadOrAlive")
        val name = arguments?.getString("name")
        val photo = arguments?.getString("photo")

        binding.tvDeadOrAlive.text = deadOrAlive
        binding.tvName.text = name
        Glide.with(binding.imgCharacter).load(photo).into(binding.imgCharacter)

    }
}