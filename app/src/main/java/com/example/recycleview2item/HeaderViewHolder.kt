package com.example.recycleview2item

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.databinding.HeaderItemBinding
import com.example.demorecyclerview.getLayoutInflater
import com.example.recycleview2item.databinding.HeaderItemBinding

class HeaderViewHolder(val binding : HeaderItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(data: StickyData){
        binding.tvHeader.text = data.title
    }

    companion object{
        fun create(parent: ViewGroup): HeaderViewHolder {
            return HeaderViewHolder(HeaderItemBinding.inflate(parent.getLayoutInflater(), parent, false))
        }
    }

}
