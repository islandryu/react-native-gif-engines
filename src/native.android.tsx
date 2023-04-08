import React from 'react';
import { requireNativeComponent, UIManager, Platform } from 'react-native';
// @ts-expect-error
import resolveAssetSource from 'react-native/Libraries/Image/resolveAssetSource';
import type { GifEnginesBaseProps, GifEnginesProps } from './types';

const LINKING_ERROR =
  `The package 'react-native-gif-engines' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

export const GlideView = getComponent('GlideView');
export const CoilView = getComponent('CoilView');
export const GIFDrawableView = getComponent('GIFDrawableView');
export const GifImageView = getComponent('GifImageView');

function getComponent(ComponentName: string) {
  return UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<GifEnginesBaseProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };
}

export const GifEngines = ({ androidEngine, ...props }: GifEnginesProps) => {
  const imageProps = { ...props, source: resolveAssetSource(props.source).uri };
  switch (androidEngine) {
    case 'glide':
      return <GlideView {...imageProps} />;
    case 'coil':
      return <CoilView {...imageProps} />;
    case 'gifDrawable':
      return <GIFDrawableView {...imageProps} />;
    case 'gifImageView':
      return <GifImageView {...imageProps} />;
    default:
      return <GlideView {...imageProps} />;
  }
};
