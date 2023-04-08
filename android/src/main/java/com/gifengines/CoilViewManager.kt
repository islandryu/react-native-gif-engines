package com.gifengines

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class CoilViewManager : SimpleViewManager<CoilView>() {
    companion object {
        const val REACT_CLASS = "CoilView"
    }

    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(context: ThemedReactContext): CoilView {
        return CoilView(context)
    }

    @ReactProp(name = "source")
    fun setSource(view: CoilView, source: String) {
        view.setSource(source)
    }
}