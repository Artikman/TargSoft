package com.example.cat.util

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream

object Utils {

    fun getBytes(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, stream)
        return stream.toByteArray()
    }
}