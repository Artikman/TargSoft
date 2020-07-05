package com.example.cat.data.source

import com.example.cat.data.CatImage
import com.example.cat.data.Vote

interface ICatsDataSource {

    suspend fun getCatImages(): List<CatImage>?

    suspend fun saveVote(vote : Vote)
}