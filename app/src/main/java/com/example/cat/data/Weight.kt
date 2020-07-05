package com.example.cat.data

import com.squareup.moshi.Json

data class Weight(

    @Json(name = "metric")
    val metric: String? = null,

    @Json(name = "imperial")
    val imperial: String? = null
)