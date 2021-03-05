package com.example.recycleview2item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewmodel : ViewModel() {

    var status: Boolean = false
    private val _listData = MutableLiveData<List<DataItem>>()
    val listData: LiveData<List<DataItem>> get() = _listData
    var lists = ArrayList<DataItem>()

    init {
        val datas = ArrayList<DataItem>()
        datas.add(DataItem(6, "orange", false, "C ", 0))
        datas.add(DataItem(9, "orange", false, "D ", 0))
        datas.add(DataItem(1, "orange", false, "A ", 0))
        datas.add(DataItem(2, "orange", false, "A ", 0))
        datas.add(DataItem(3, "orange", false, "B ", 0))
        datas.add(DataItem(4, "orange", false, "B ", 0))
        datas.add(DataItem(5, "orange", false, "C ", 0))
        datas.add(DataItem(6, "orange", false, "C ", 0))
        datas.add(DataItem(6, "orange", false, "C ", 0))
        datas.add(DataItem(6, "orange", false, "C ", 0))
        datas.add(DataItem(7, "orange", false, "D ", 0))
        datas.add(DataItem(8, "orange", false, "D ", 0))


        _listData.value = datas
        lists = datas
    }

    fun changeData() {
        var list : List<DataItem> = lists
        val newList = ArrayList<DataItem>()

        list = list.sortedBy { it.titleHeader }

        newList.add(DataItem(1,"",true,"All", list.size))
        var hearder = ""
        var count = 1
        var index = 1
        for (item in list) {
            if (!item.titleHeader.equals(hearder)) {

                hearder = item.titleHeader
                val newItem = item.copy()
                newItem.isHeader = true

                newList.add(newItem)

                if (count > 1) {
                    newList[index - 1].count = count
                }
                count = 1
                index++

            } else {
                count++
            }
            if (item == list.get(list.lastIndex)){
                newList[index - 1].count = count
            }
        }

        _listData.value = newList

    }

    fun filterTypeFolder(dataItem: DataItem){

        if (dataItem.titleHeader.equals("All")){
            _listData.value = lists
        }else{
            var newList = ArrayList<DataItem>(lists)
            val listData = ArrayList<DataItem>()

            for (item in newList){
                if (item.titleHeader.equals(dataItem.titleHeader)){
                    listData.add(item)
                }
            }
            _listData.value= listData

            status = true
        }
    }

}