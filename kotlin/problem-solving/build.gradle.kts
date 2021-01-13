import main.kotlin.Dependencies

plugins {
    id("configuration")
}

repositories {
    jcenter()
}

dependencies {
    implementation(Dependencies.Test.junit)
    implementation(Dependencies.Kotlin.coroutines)
}

kotlin.sourceSets.getByName("main").kotlin.srcDir("../configuration/src/main/kotlin")
