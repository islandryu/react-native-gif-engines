package com.gifengines

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager


class GifEnginesPackage : ReactPackage {
  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
    return emptyList()
  }

  override fun createViewManagers(reactContext: ReactApplicationContext):MutableList<ViewManager<*,*>> {
    val viewManagers: MutableList<ViewManager<*, *>> = ArrayList()
    viewManagers.add(GlideViewManager())
    viewManagers.add(CoilViewManager())
    viewManagers.add(GIFDrawableViewManager())
    viewManagers.add(GifImageViewManager())
    return viewManagers
  }
}
