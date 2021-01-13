package main.kotlin

object Versions {
    const val KOTLIN = "1.4.20"
    const val COROUTINES = "1.4.1"
    const val JUNIT = "4.13"
}

object Dependencies {
    object Kotlin {
        const val kotlinJDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.JUNIT}"
    }
}