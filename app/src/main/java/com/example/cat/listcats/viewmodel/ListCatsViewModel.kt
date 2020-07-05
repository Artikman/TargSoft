package com.example.cat.listcats.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cat.common.BaseViewModel
import com.example.cat.data.CatImage
import com.example.cat.data.Vote
import com.example.cat.data.source.ICatsDataSource
import com.example.cat.listcats.ui.ListCatEvent
import com.yuyakaido.android.cardstackview.Direction
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListCatsViewModel(
    private val catsDataSource: ICatsDataSource,
    uiContext: CoroutineContext
) : BaseViewModel<ListCatEvent>(uiContext) {

    private val catsListState = MutableLiveData<List<CatImage>>()
    val catsList: LiveData<List<CatImage>> get() = catsListState

    private var value: Int = 0

    override fun handleEvent(event: ListCatEvent) {
        when (event) {
            is ListCatEvent.OnStart -> getCatsList()
            is ListCatEvent.OnSwipe -> saveVoteToLocalStorage(event.position, event.direction)
        }
    }

    private fun saveVoteToLocalStorage(position: Int, direction: Direction?) = launch {
        val imageId = catsList.value!![position].id
        if (direction == Direction.Right) {
            value = 1
        }

        val vote = Vote(imageId = imageId, value = value)

        catsDataSource.saveVote(vote)

    }

    private fun getCatsList() = launch {
        val result = catsDataSource.getCatImages()
        catsListState.value = result
    }
}