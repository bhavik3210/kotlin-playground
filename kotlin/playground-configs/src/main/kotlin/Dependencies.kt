package main.kotlin

object Versions {
    const val KOTLIN = "1.4.20"
    const val COROUTINES = "1.4.1"
    const val JUNIT4 = "4.13"
    const val JUNIT = "5.5.0"
    const val K_FLUENT = "1.50"
    const val MOCK = "1.9"
}

object Dependencies {
    object Kotlin {
        const val kotlinJDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN}"
    }

    object Test {
        const val junit4 = "junit:junit:${Versions.JUNIT4}"
        const val jUnit = "org.junit.jupiter:junit-jupiter:${Versions.JUNIT}"
        const val kFluent = "org.amshove.kluent:kluent:${Versions.K_FLUENT}"
        const val mock = "io.mockk:mockk:${Versions.MOCK}"
    }
}