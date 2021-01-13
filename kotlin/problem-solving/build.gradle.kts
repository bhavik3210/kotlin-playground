import main.kotlin.Dependencies

plugins {
    `kotlin-dsl`
//    `java-gradle-plugin`
//    `maven-publish`
    id("configs")
}

repositories {
    jcenter()
}

dependencies {
    implementation(Dependencies.Test.junit)
    compile(Dependencies.Kotlin.coroutines)
    implementation(Dependencies.Kotlin.kotlinJDK)
}

//kotlin.sourceSets.getByName("main").kotlin.srcDir("../problem-solving/src/main/kotlin")
