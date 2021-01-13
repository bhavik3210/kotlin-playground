package main.kotlin

object Versions {
    const val KOTLIN_VERSION = "1.4.10"
    const val COROUTINES_VERSION = "1.3.7"
    const val JUNIT_VERSION = "4.13"
}

object Dependencies {
    object Kotlin {
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.JUNIT_VERSION}"
    }
}