includeBuild("../playground-configs")
includeBuild("../playground-build")

pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
    }
}

buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
    }
    dependencies {
        classpath("com.google.code.gson:gson:2.8.6")
    }
}

includeBuild("../playground-build")
includeBuild("../playground-configs")
