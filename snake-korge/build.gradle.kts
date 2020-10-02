import com.soywiz.korge.gradle.*

plugins {
	kotlin("multiplatform") version "1.3.72"
}

buildscript {
	repositories {
		mavenLocal()
		maven { url = uri("https://dl.bintray.com/korlibs/korlibs") }
		maven { url = uri("https://plugins.gradle.org/m2/") }
		mavenCentral()
		google()
	}
	dependencies {
		classpath("com.soywiz.korlibs.korge.plugins:korge-gradle-plugin:1.15.0.0")
	}
}

apply<KorgeGradlePlugin>()

korge {
	id = "com.londogard.snake-korge"
	supportBox2d()
}