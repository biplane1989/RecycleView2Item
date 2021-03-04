package com.example.recycleview2item

data class DataItem(val id: Int, val title: String, var isHeader: Boolean = false, val titleHeader: String, var count: Int) {}