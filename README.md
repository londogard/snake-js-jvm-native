# snake-js-jvm-native
A Snake implementation that works for JS, JVM &amp; Native targets.

Find the full blog [here](https://blog.londogard.com/gradle/kotlin/game/multiplatform/2020/11/07/snake-kotlin-multiplatform.html), with explanations and TODOs for implementing this from the bottom up yourself!

Download Zip [here](https://github.com/londogard/snake-js-jvm-native/archive/master.zip) or clone project from [github](https://github.com/londogard/snake-js-jvm-native).

Open with [IntelliJ Community](https://www.jetbrains.com/idea/download/) or [VS Code](https://code.visualstudio.com/) or online via GitPod.

Run JS: `./gradlew jsBrowserDevelopmentRun`
Run JVM: `./gradlew run`
Run Native: `./gradlew runDebugExecutableNative`

But it's **way** easier to run through IntelliJ.

### Native Installation of `ncurses`
Requires Linux or MacOS.

First of, grab ncurses!

```
    // sudo apt install libncurses5-dev
    // sudo apt install libncursesw5-dev
    // sudo apt install gcc-multilib 
```

// Snake sprite sheet is 64x64 px per item!