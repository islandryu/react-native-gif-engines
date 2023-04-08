package com.gifengines

import android.content.Context
import com.felipecsl.gifimageview.library.GifImageView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.net.URL

class GifImageView (context: Context): GifImageView(context){
    private var source: String? = null

    fun setSource(source: String) {
        this.source = source
        val view = this
        runBlocking {
            val byte = getUrlBytes(source)
            if(byte == null) {
                setImageDrawable(null)
                return@runBlocking
            }
            view.setBytes(byte)
            view.startAnimation()
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