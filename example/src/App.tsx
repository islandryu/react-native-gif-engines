import * as React from 'react';

import { ScrollView, StyleSheet, Text, View } from 'react-native';
import { GifEngines } from 'react-native-gif-engines';
import { Platform } from 'react-native';

export default function App() {
  return (
    <ScrollView style={styles.container}>
      {Platform.OS === 'android'
        ? (['glide', 'coil', 'gifDrawable', 'gifImageView'] as const).map(
            (engine) => (
              <View style={styles.item} key={engine}>
                <View style={styles.titleWrapper}>
                  <Text style={styles.title}>{engine}</Text>
                </View>
                <GifEngines
                  androidEngine={engine}
                  source={{
                    uri: 'https://www.easygifanimator.net/images/samples/eglite.gif',
                  }}
                  style={styles.box}
                />
              </View>
            )
          )
        : (['gifu', 'swiftGifOrigin', 'FLAnimatedImage'] as const).map(
            (engine) => (
              <View style={styles.item} key={engine}>
                <View style={styles.titleWrapper}>
                  <Text style={styles.title}>{engine}</Text>
                </View>
                <GifEngines
                  iosEngine={engine}
                  source={{
                    uri: 'https://www.easygifanimator.net/images/samples/eglite.gif',
                  }}
                  style={styles.box}
                />
              </View>
            )
          )}
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {},
  titleWrapper: {
    marginBottom: 10,
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
  },
  box: {
    marginVertical: 20,
    width: 100,
    height: 100,
  },
  item: {
    marginVertical: 20,
    alignItems: 'center',
  },
});
