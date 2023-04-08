import type { ImageStyle } from 'react-native';
import type { StyleProp } from 'react-native';
import type { ImageSourcePropType } from 'react-native';

export type GifEnginesBaseProps = {
  source: string;
  style: StyleProp<ImageStyle>;
};

export type GifEnginesProps = {
  androidEngine?: 'glide' | 'coil' | 'gifDrawable' | 'gifImageView';
  iosEngine?: 'gifu' | 'swiftGifOrigin' | 'FLAnimatedImage';
  source: ImageSourcePropType;
  style: StyleProp<ImageStyle>;
};
