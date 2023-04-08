package com.gifengines

import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.bumptech.glide.request.target.Target


class GlideView(context: Context?) : ImageView(context) {
    private var source: String? = null
    fun setSource(source: String?) {
        this.source = source
        val requestOptions: RequestOptions = RequestOptions().centerCrop()
        val imageViewTarget = DrawableImageViewTarget(this)
        Glide.with(context).load(source).into<Target<Drawable>>(imageViewTarget)
    }
}