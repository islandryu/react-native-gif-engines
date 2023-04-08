//
//  SwiftGifOriginViewManager.swift
//  ReactNativeTS
//
//  Created by Ryuhei Shima on 2023/04/08.
//

import React

@objc(SwiftGifOriginViewManager)
class SwiftGifOriginViewManager: RCTViewManager {
    override static func moduleName() -> String {
        return "SwiftGifOriginView"
    }
    
    override func view() -> UIView {
      return SwiftGifOriginView(image: nil)
    }
  
    @objc override static func requiresMainQueueSetup() -> Bool {
        return false
    }
}
