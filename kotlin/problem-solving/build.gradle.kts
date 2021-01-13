import main.kotlin.Dependencies

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
    id("playground-configs")
}

repositories {
    jcenter()
}

dependencies {
    implementation(Dependencies.Kotlin.gradlePlugin)
//    implementation(Dependencies.Kotlin.reflect)
    testImplementation(Dependencies.Test.junit)
    compile(Dependencies.Kotlin.coroutines)
    implementation(Dependencies.Kotlin.kotlinJDK)
}

//kotlin.sourceSets.getByName("main").kotlin.srcDir("../problem-solving/src/main/kotlin")
