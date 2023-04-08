package com.gifengines

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class GlideViewManager : SimpleViewManager<GlideView?>() {
    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(reactContext: ThemedReactContext): GlideView {
        return GlideView(reactContext)
    }

    @ReactProp(name = "source")
    fun setSource(view: GlideView, source: String?) {
        view.setSource(source)
    }

    companion object {
        const val REACT_CLASS = "GlideView"
    }
}