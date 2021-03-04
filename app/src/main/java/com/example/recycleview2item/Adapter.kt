package com.example.recycleview2item

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

const val HEADER: Int = 1
const val ITEM: Int = 0

class Adapter(val listener: (DataItem) -> Unit) : ListAdapter<DataItem, RecyclerView.ViewHolder>(DiffStickyUtil()) {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.isHeader) HEADER else ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER) HeaderViewHolder.create(parent) else ItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is HeaderViewHolder) {
            holder.build(item,listener)
        } else if (holder is ItemViewHolder) {
            holder.build(item)
        }
    }

//    fun getHeaderPositionForItem(itemPosition: Int): Int {
//        for (i in itemPosition downTo 0) {
//            val item = getItem(i)
//            if (item.isHeader) {
//                return i
//            }
//        }
//        return RecyclerView.NO_POSITION
//    }
//
//    fun getHeaderViewHolder(parent: ViewGroup, headerPosition: Int): RecyclerView.ViewHolder {
//        return HeaderViewHolder.create(parent)
//    }
//
//    fun bindHeaderData(holder: RecyclerView.ViewHolder?, headerPosition: Int) {
//        if (holder is HeaderViewHolder) {
//            holder.build(getItem(headerPosition))
//        }
//    }
//
//    fun isHeader(itemPosition: Int): Boolean {
//        return getItem(itemPosition).isHeader
//    }

}

class DiffStickyUtil : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem) = oldItem == newItem
    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return true
    }

}