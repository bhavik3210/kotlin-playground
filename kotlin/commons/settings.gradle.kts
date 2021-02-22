apply(from = "../gradle/globalSettings.gradle.kts")

rootProject.name = "commons"

pluginManagement {
  repositories {
    gradlePluginPortal()
    jcenter()
  }
}