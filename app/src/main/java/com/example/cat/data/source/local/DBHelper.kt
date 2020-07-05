package com.example.cat.data.source.local

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteException
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class DBHelper(context: Context): SQLiteAssetHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        private const val DB_NAME = "SaveData.db"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "Gallery"
        private const val COLUMN_IMAGE = "Image"
    }

    @Throws(SQLiteException::class)
    fun addBitmap(image: ByteArray) {
        val database = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_IMAGE, image)
        database.insert(TABLE_NAME, null, cv)
    }
}