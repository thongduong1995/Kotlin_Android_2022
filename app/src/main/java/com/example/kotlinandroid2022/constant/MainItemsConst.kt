package com.example.kotlinandroid2022.constant

class MainItemsConst {
    companion object {
        const val MAIN_ITEM_DEFAULT = -1
        const val MAIN_ITEM_WIDGETS = 0
        const val MAIN_ITEM_EXPLICIT_INTENT = 1
        const val MAIN_ITEM_IMPLICIT_INTENT = 2
        const val MAIN_ITEM_FRAGMENT = 3
    }
    enum class Type{
        MAIN_ITEM_DEFAULT,
        MAIN_ITEM_WIDGETS,
        MAIN_ITEM_EXPLICIT_INTENT
    }
}