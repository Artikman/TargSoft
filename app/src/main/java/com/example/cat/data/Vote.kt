package com.example.cat.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "votes")
data class Vote(

	@Json(name="id")
	@PrimaryKey
	val id: Int? = null,

	@Json(name="country_code")
	@ColumnInfo(name = "country_code")
	val countryCode: String? = null,

	@Json(name="sub_id")
	@ColumnInfo(name = "sub_id")
	val subId: String? = null,

	@Json(name="created_at")
	@ColumnInfo(name = "created_at")
	val createdAt: String? = null,

	@Json(name="image_id")
	val imageId: String? = null,

	@Json(name="value")
	@ColumnInfo(name = "value")
	val value: Int? = null
)