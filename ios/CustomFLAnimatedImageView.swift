//
//  FLAnimatedImageView.swift
//  UIkitPlayground
//
//  Created by Ryuhei Shima on 2023/04/08.
//

import UIKit
import FLAnimatedImage

@objc class CustomFLAnimatedImageView: FLAnimatedImageView {
    
    private var source: String? = nil


    override init(image: UIImage?) {
        super.init(image: image)
        loadGifImage()
    }

    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        loadGifImage()
    }

    @objc func setSource(_ source: String) {
        self.source = source
        loadGifImage()
    }
  
    private func loadGifImage() {
        guard let unwrapSource = self.source else {
            return
        }
        print(unwrapSource)
        if let url = URL(string: unwrapSource) {
            URLSession.shared.dataTask(with: url) { (data, _, _) in
                if let data = data {
                    let gifImage = FLAnimatedImage(animatedGIFData: data)
                    DispatchQueue.main.async {
                        self.animatedImage = gifImage
                    }
                }
            }.resume()
        }
    }
}
