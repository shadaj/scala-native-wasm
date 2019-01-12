# Scala Native on WebAssembly Demo
First, locally publish https://github.com/scala-native/scala-native/pull/1363 with `sbt rebuild_x32`.

Then, run the Scala Native linker with `sbt nativeLink`, this will produce errors during compilation and linking, but this is okay because we only care about the generated LLVM.

Finally, run [Emscripten](https://kripken.github.io/emscripten-site/index.html) to compile to WebAssembly:

```bash
emcc target/scala-2.11/native/lib/*.c target/scala-2.11/native/lib/gc/none/**.c target/scala-2.11/native/lib/*.cpp target/scala-2.11/native/*.ll -s WASM=1 -s ALLOW_MEMORY_GROWTH=1 -s ERROR_ON_UNDEFINED_SYMBOLS=0 -o index.html
```

Then open up `index.html` in a web browser (you may need to serve the directory as a local server due to security restrictions).
