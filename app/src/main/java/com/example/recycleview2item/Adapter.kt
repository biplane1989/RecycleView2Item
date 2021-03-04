package com.example.recycleview2item

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

const val HEADER: Int = 1
const val ITEM: Int = 0
class Adapter {}
class StickyAdapter : androidx.recyclerview.widget.ListAdapter<StickyData, RecyclerView.ViewHolder>(DiffStickyUtil()), StickHeaderItemDecoration.StickyHeaderInterface {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.header) HEADER else ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER) HeaderViewHolder.create(parent) else ItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is HeaderViewHolder) {
            holder.build(item)
        } else if (holder is ItemViewHolder) {
            holder.build(item)
        }
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        for (i in itemPosition downTo 0) {
            val item = getItem(i)
            if (item.header) {
                return i
            }
        }
        return RecyclerView.NO_POSITION
    }

    override fun getHeaderViewHolder(parent: ViewGroup, headerPosition: Int): RecyclerView.ViewHolder {
        return HeaderViewHolder.create(parent)
    }

    override fun bindHeaderData(holder: RecyclerView.ViewHolder?, headerPosition: Int) {
        if(holder is HeaderViewHolder){
            holder.build(getItem(headerPosition))
        }
    }

    override fun isHeader(itemPosition: Int): Boolean {
        return getItem(itemPosition).header
    }

}

class DiffStickyUtil : DiffUtil.ItemCallback<StickyData>() {
    override fun areItemsTheSame(oldItem: StickyData, newItem: StickyData) = oldItem == newItem
    override fun areContentsTheSame(oldItem: StickyData, newItem: StickyData): Boolean {
        TODO("Not yet implemented")
    }

}