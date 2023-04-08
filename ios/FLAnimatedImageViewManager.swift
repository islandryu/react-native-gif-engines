//
//  FLAnimatedImageViewManager.swift
//  ReactNativeTS
//
//  Created by Ryuhei Shima on 2023/04/08.
//

import Foundation
import React

@objc(FLAnimatedImageViewManager)
class FLAnimatedImageViewManager: RCTViewManager {
    override static func moduleName() -> String {
        return "FLAnimatedImageView"
    }

    override func view() -> UIView {
        return CustomFLAnimatedImageView(image: nil)
    }

    @objc override static func requiresMainQueueSetup() -> Bool {
        return false
    }
}
