apply(from = "../gradle/globalSettings.gradle.kts")

rootProject.name = "playground-app"

pluginManagement {
  repositories {
    gradlePluginPortal()
    jcenter()
  }
}
