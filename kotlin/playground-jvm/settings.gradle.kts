apply(from = "../gradle/globalSettings.gradle.kts")

rootProject.name = "play-jvm"

pluginManagement {
  repositories {
    gradlePluginPortal()
    jcenter()
  }
}