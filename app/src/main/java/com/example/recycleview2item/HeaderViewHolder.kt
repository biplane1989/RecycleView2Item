package com.example.recycleview2item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview2item.databinding.HeaderItemBinding

class HeaderViewHolder(val binding: HeaderItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(data: DataItem, listener: (DataItem) -> Unit) {
        binding.tvTitle.text = data.titleHeader
        binding.tvCount.text = data.count.toString()

        binding.root.setOnClickListener {
            listener(data)
        }

    }


    companion object {
        fun create(parent: ViewGroup): HeaderViewHolder {
            return HeaderViewHolder(HeaderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

}
