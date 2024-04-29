package com.example.nurzhigit_ishenov_hw_8_m_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nurzhigit_ishenov_hw_8_m_3.databinding.FragmentCharacterBinding
import com.example.nurzhigit_ishenov_hw_8_m_3.databinding.ItemCharacterBinding

class CharacterAdapter(private val characterList: List<Character>):
    RecyclerView.Adapter<ViewHolder>() {
    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = characterList[position]
        holder.bind(characterList[position])
        holder.itemView.setOnClickListener(){
            if (onClickListener != null){
                onClickListener!!.onClick(position, item)
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Character)
    }


}

class ViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(character: Character) {
        Glide.with(binding.imgCharacter).load(character.photo).into(binding.imgCharacter)
        binding.tvDeadOrAlive.text = character.deadOrAlive
        binding.tvName.text = character.name
    }
}
