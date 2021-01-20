[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/londogard/snake-js-jvm-native)

# snake-js-jvm-native
A Snake implementation that works for JS, JVM &amp; Native targets.

Find the full blog [here](https://blog.londogard.com/gradle/kotlin/game/multiplatform/2020/11/07/snake-kotlin-multiplatform.html), with explanations and TODOs for implementing this from the bottom up yourself!

Download Zip [here](https://github.com/londogard/snake-js-jvm-native/archive/master.zip) or clone project from [github](https://github.com/londogard/snake-js-jvm-native).

Open with [IntelliJ Community](https://www.jetbrains.com/idea/download/).

Run JS: `./gradlew jsBrowserDevelopmentRun`
JVM/Native is definiately easiest to run through IntelliJ.

### Native Installation of `ncurses`
Requires Linux or MacOS.

First of, grab ncurses!

```
    // sudo apt install libncurses5-dev
    // sudo apt install libncursesw5-dev
    // sudo apt install gcc-multilib 
```

// Snake sprite sheet is 64x64 px per item!