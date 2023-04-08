//
//  GifuViewManager.swift
//  ReactNativeTS
//
//  Created by Ryuhei Shima on 2023/04/08.
//

import React

@objc(GifuViewManager)
class GifuViewManager: RCTViewManager {
    override static func moduleName() -> String {
        return "GifuView"
    }
    
    override func view() -> UIView {
      return GifuView(image: nil)
    }
  
    @objc override static func requiresMainQueueSetup() -> Bool {
        return false
    }
}
