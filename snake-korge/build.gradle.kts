import com.soywiz.korge.gradle.*

plugins {
	kotlin("multiplatform") version "1.4.10"
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
		classpath("com.soywiz.korlibs.korge.plugins:korge-gradle-plugin:2.0.0-alpha")
	}
}

apply<KorgeGradlePlugin>()

korge {
	id = "com.londogard.snake-korge"
	supportBox2d()
}