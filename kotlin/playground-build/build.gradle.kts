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
        implementationClass = "com.playground.plugins.PlaygroundPlayPlugin"
    }
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
