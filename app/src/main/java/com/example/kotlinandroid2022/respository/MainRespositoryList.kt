package com.example.kotlinandroid2022.respository

import com.example.kotlinandroid2022.R
import com.example.kotlinandroid2022.constant.MainItemsConst
import com.example.kotlinandroid2022.data.MainItems

class MainRespositoryList {
    fun fetchData(): List<MainItems>{
        val list = ArrayList<MainItems>()
        list.add(MainItems("Intent", R.drawable.intent_icon, MainItemsConst.MAIN_ITEM_INTENT))
        list.add(MainItems("TEMPLATE", R.drawable.intent_icon, MainItemsConst.MAIN_ITEM_DEFAULT))
        list.add(MainItems("TEMPLATE", R.drawable.intent_icon, MainItemsConst.MAIN_ITEM_DEFAULT))
        list.add(MainItems("TEMPLATE", R.drawable.intent_icon, MainItemsConst.MAIN_ITEM_DEFAULT))
        list.add(MainItems("TEMPLATE", R.drawable.intent_icon, MainItemsConst.MAIN_ITEM_DEFAULT))
        return list
    }
}