package com.example.cat.data.source.remote

import com.example.cat.data.CatImage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("images/search")
    suspend fun getCatImages(
        @Query("x-api-key") apiKey: String,
        @Query("limit") limit: Int
    ): Response<List<CatImage>>
}