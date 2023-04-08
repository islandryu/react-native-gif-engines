package com.gifengines

import android.content.Context
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifImageView
import java.io.ByteArrayOutputStream
import java.net.URL
import java.util.*

class GIFDrawableView(context: Context?) : GifImageView(context) {
    private var source: String? = null
    fun setSource(source: String?) {
        this.source = source
        updateImage()
    }

    private fun updateImage() {
        runBlocking {
            val byte = getUrlBytes(source!!)
            if(byte == null) {
                setImageDrawable(null)
                return@runBlocking
            }
            val gifDrawable = GifDrawable(byte)
            setImageDrawable(gifDrawable)
        }
    }

    suspend fun getUrlBytes(url: String): ByteArray {
        return withContext(Dispatchers.IO) {
            URL(url).openStream().use { stream ->
                val buffer = ByteArray(1024)
                val output = ByteArrayOutputStream()
                var bytesRead = stream.read(buffer)
                while (bytesRead != -1) {
                    output.write(buffer, 0, bytesRead)
                    bytesRead = stream.read(buffer)
                }
                output.toByteArray()
            }
        }
    }
}