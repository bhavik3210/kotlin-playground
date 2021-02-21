apply(from = "../gradle/globalSettings.gradle.kts")

rootProject.name = "play-app"

pluginManagement {
  repositories {
    gradlePluginPortal()
    jcenter()
  }
}
