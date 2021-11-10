package com.example.kotlinandroid2022.respository

import android.content.res.Resources
import android.graphics.Color
import com.example.kotlinandroid2022.R
import com.example.kotlinandroid2022.constant.MainItemType
import com.example.kotlinandroid2022.constant.MainItemsConst
import com.example.kotlinandroid2022.data.ImageProperty
import com.example.kotlinandroid2022.data.MainItems

class MainRespositoryList {
    fun fetchData(resources: Resources): List<MainItems> {
        val list = ArrayList<MainItems>()
        list.apply {
            add(MainItems(
                    "Widgets",
                    ImageProperty(R.drawable.widgets_icon_100, resources.getColor(R.color.widgets_main_item_color)),
                    MainItemType.MAIN_ITEM_WIDGETS
                )
            )

            add(
                MainItems(
                    "Explicit Intent",
                    ImageProperty(R.drawable.intent_icon, R.color.explicit_intent_main_item_color),
                    MainItemType.MAIN_ITEM_EXPLICIT_INTENT
                )
            )

            add(
                MainItems(
                    "Implicit Intent",
                    ImageProperty(R.drawable.intent_icon, -1),
                    MainItemType.MAIN_ITEM_IMPLICIT_INTENT
                )
            )

            add(
                MainItems(
                    "Activity lifecycle",
                    ImageProperty(R.drawable.ic_activitylifecycle, -1),
                    MainItemType.MAIN_ITEM_DEFAULT
                )
            )

            add(
                MainItems(
                    "Fragment",
                    ImageProperty(R.drawable.fragment_optimize, -1),
                    MainItemType.MAIN_ITEM_FRAGMENT
                )
            )

            add(
                MainItems(
                    "RecyclerView",
                    ImageProperty(R.drawable.recyclerview_100, -1),
                    MainItemType.MAIN_ITEM_RECYCLERVIEW
                )
            )

            add(
                MainItems(
                    "ToolBar",
                    ImageProperty(R.drawable.fragment_optimize, -1),
                    MainItemType.MAIN_ITEM_FRAGMENT
                )
            )

            add(
                MainItems(
                    "RecyclerView",
                    ImageProperty(R.drawable.recyclerview_100, -1),
                    MainItemType.MAIN_ITEM_RECYCLERVIEW
                )
            )

            add(
                MainItems(
                    "Fragment",
                    ImageProperty(R.drawable.fragment_optimize, -1),
                    MainItemType.MAIN_ITEM_FRAGMENT
                )
            )

            add(
                MainItems(
                    "RecyclerView",
                    ImageProperty(R.drawable.recyclerview_100, -1),
                    MainItemType.MAIN_ITEM_RECYCLERVIEW
                )
            )

        }
        return list
    }
}