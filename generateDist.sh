#!/bin/bash

DIR=~/tmp/spaceagencies

rm -rf $DIR

mkdir -p $DIR
cp README.md $DIR

#Copy sounds
mkdir -p $DIR/sounds
cp sounds/* $DIR/sounds


# Copy libs
mkdir -p $DIR/lib/lwjgl/native/linux
mkdir -p $DIR/lib/lwjgl/native/windows
cp lib/lwjgl/native/linux/*.so $DIR/lib/lwjgl/native/linux
cp lib/lwjgl/native/windows/*.dll $DIR/lib/lwjgl/native/windows

# Copy fonts
mkdir -p $DIR/fonts
cp fonts/*.ttf $DIR/fonts

# Copy assets
cp -r assets $DIR/assets

# Copy res
cp -r res $DIR/res
