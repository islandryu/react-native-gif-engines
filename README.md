# React Native Gif Engines

![icon](./images/icon.png)

React Native Gif Engines is a library that enables you to test multiple native libraries for displaying GIF animations on Android and iOS platforms, primarily to determine which engine provides the best performance.

## Table of Contents

- [Features](#features)
- [Supported Engines](#supported-engines)
  - [Android](#android)
  - [iOS](#ios)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## Features

- Supports multiple GIF engines for both Android and iOS
- Helps you find the best-performing GIF engine for your React Native app

## Supported Engines

### Android

- [glide](https://github.com/bumptech/glide)
- [coil](https://github.com/coil-kt/coil)
- [gifDrawable](https://github.com/koral--/android-gif-drawable)
- [gifImageView](https://github.com/koral--/android-gif-drawable)

### iOS

- [gifu](https://github.com/bumptech/glide)
- [swiftGifOrigin](https://github.com/swiftgif/SwiftGif)
- [FLAnimatedImage](https://github.com/Flipboard/FLAnimatedImage)

## Installation

```sh
npm install react-native-gif-engines --save
```

## Usage

First, import the library:

```jsx
import {GifEngine} from 'react-native-gif-engines';

// ...

render() {
  return (
    <GifEngine
      source={{uri: 'https://example.com/your-gif.gif'}}
      style={{width: 200, height: 100}}
      androidEngine="glide"
      iosEngine="SwiftOrigin"
    />
  );
}
```

## License

React Native Gif Engines is released under the MIT License.

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
