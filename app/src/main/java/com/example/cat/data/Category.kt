package com.example.cat.data

import com.squareup.moshi.Json

data class Category(

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "id")
    val id: Int? = null
)