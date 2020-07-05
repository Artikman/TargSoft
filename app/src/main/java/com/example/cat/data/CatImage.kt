package com.example.cat.data

import com.squareup.moshi.Json

data class CatImage(

    @Json(name = "width")
    val width: Int? = null,

    @Json(name = "categories")
    val categories: List<Category?>? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "url")
    val url: String? = null,

    @Json(name = "breeds")
    val breeds: List<Breed?>? = null,

    @Json(name = "height")
    val height: Int? = null
)