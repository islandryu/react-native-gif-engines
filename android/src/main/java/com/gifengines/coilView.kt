package com.gifengines

import android.content.Context
import android.os.Build
import android.widget.ImageView
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load

class CoilView(context: Context) : ImageView(context) {
    private var source: String? = null

    fun setSource(source: String) {
        this.source = source
        updateImage()
    }

    private fun updateImage() {
        val loader = ImageLoader.Builder(context).components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }.build()
        this.load(source, imageLoader = loader)
    }
}
