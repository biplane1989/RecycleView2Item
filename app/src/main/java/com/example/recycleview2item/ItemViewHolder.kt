package com.example.recycleview2item

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview2item.databinding.ContentItemBinding


class ItemViewHolder(val binding: ContentItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(data: DataItem) {
        binding.tvTitle.text = data.title
    }

    companion object {
        fun create(parent: ViewGroup): ItemViewHolder {
            return ItemViewHolder(ContentItemBinding.inflate(parent.getLayoutInflater(), parent, false))
        }
    }

}
