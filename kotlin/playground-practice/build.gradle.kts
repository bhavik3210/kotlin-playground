import main.kotlin.Dependencies

plugins {
  `kotlin-dsl`
  id("playground-configs")
  id("play-build")
}

repositories {
  jcenter()
}

dependencies {
  implementation(Dependencies.Kotlin.gradlePlugin)
  testImplementation(Dependencies.Test.junit4)
  implementation(Dependencies.Kotlin.coroutines)
  implementation(Dependencies.Kotlin.kotlinJDK)
}

//kotlin.sourceSets.getByName("main").kotlin.srcDir("../problem-solving/src/main/kotlin")
