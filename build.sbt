enablePlugins(ScalaNativePlugin)

name := "scala-native-wasm"

scalaVersion := "2.11.12"

nativeTargetArchitecture := TargetArchitecture.i386

import scala.scalanative.sbtplugin.ScalaNativePluginInternal.nativeTarget
nativeTarget in Compile := "i386-none-none"

nativeGC := "none"

nativeMode := "debug"
