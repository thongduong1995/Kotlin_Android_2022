package com.example.kotlinandroid2022.respository

import com.example.kotlinandroid2022.R
import com.example.kotlinandroid2022.data.MainItems

class MainRespositoryList {
    fun fetchData(): List<MainItems>{
        val list = ArrayList<MainItems>()
        list.add(MainItems("Intent", R.drawable.ic_launcher_background))
        list.add(MainItems("Intent", R.drawable.ic_launcher_background))
        list.add(MainItems("Intent", R.drawable.ic_launcher_background))
        list.add(MainItems("Intent", R.drawable.ic_launcher_background))
        list.add(MainItems("Intent", R.drawable.ic_launcher_background))
        return list
    }
}