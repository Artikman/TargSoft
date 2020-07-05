package com.example.cat.listcats.ui

import com.yuyakaido.android.cardstackview.Direction

sealed class ListCatEvent {
    object OnStart : ListCatEvent()
    data class OnSwipe(val position : Int, val direction: Direction?): ListCatEvent()
}