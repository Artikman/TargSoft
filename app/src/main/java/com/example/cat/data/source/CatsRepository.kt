package com.example.cat.data.source

import com.example.cat.data.CatImage
import com.example.cat.data.Vote
import com.example.cat.data.source.local.VoteDao
import com.example.cat.data.source.remote.ApiInterface
import com.example.cat.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CatsRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val votesDao: VoteDao
) : ICatsDataSource {
    override suspend fun getCatImages(): List<CatImage>? {
        return apiInterface.getCatImages(Constants.API_KEY, 100).body()
    }

    override suspend fun saveVote(vote: Vote) = withContext(Dispatchers.IO) {
        votesDao.insertVote(vote)
    }
}