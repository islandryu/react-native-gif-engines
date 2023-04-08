package com.gifengines

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp


class GIFDrawableViewManager : SimpleViewManager<GIFDrawableView?>() {
    override fun getName(): String {
        return REACT_CLASS
    }

    public override fun createViewInstance(context: ThemedReactContext): GIFDrawableView {
        return GIFDrawableView(context)
    }

    @ReactProp(name = "source")
    fun setSource(view: GIFDrawableView, source: String?) {
        view.setSource(source)
    }

    companion object {
        const val REACT_CLASS = "GIFDrawableView"
    }
}