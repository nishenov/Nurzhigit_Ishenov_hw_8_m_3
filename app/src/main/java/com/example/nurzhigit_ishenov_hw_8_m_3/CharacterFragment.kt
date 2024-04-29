package com.example.nurzhigit_ishenov_hw_8_m_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.nurzhigit_ishenov_hw_8_m_3.Character
import com.example.nurzhigit_ishenov_hw_8_m_3.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    private val characterList = listOf(
        Character("Alive", "Rich Sanches", "https://static.wikia.nocookie.net/deathbattle/images/7/7e/Portrait.rick.png/revision/latest/thumbnail/width/360/height/450?cb=20231106231518")
        , Character("Alive", "Morty Smith", "https://www.pngitem.com/pimgs/m/85-851974_mortysmith-morty-rick-morty-morty-smith-hd-png.png")
        , Character("Dead", "Albert Einstein", "https://static.vecteezy.com/system/resources/previews/031/823/775/original/albert-einstein-character-ai-generative-free-png.png")
        , Character("Alive", "Jerry Smith", "https://i.pinimg.com/originals/0e/6c/51/0e6c51f100fb15f146f16d1c5669573b.png")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter: CharacterAdapter = CharacterAdapter(characterList)
        binding.rvCharacters.adapter = adapter
        adapter.setOnClickListener(object : CharacterAdapter.OnClickListener {
            override fun onClick(position: Int, model: Character) {
                findNavController().navigate(R.id.characterInfoFragment, bundleOf("deadOrAlive" to model.deadOrAlive,
                    "name" to model.name,
                    "photo" to model.photo))
            }
        })
    }
}