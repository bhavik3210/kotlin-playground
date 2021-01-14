plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("playground-configs")
}

repositories {
    gradlePluginPortal()
    jcenter()
}

gradlePlugin {
    plugins.register("play-build") {
        id = "play-build"
        implementationClass = "main.kotlin.com.playground.plugins.PlaygroundPlayPlugin"
    }
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
