package com.gifengines

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class GifImageViewManager : SimpleViewManager<GifImageView>() {
    companion object {
        const val REACT_CLASS = "GifImageView"
    }

    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(context: ThemedReactContext): GifImageView {
        return GifImageView(context)
    }

    @ReactProp(name = "source")
    fun setSource(view: GifImageView, source: String) {
        view.setSource(source)
    }
}
