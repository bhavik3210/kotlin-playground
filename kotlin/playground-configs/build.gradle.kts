plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    jcenter()
}

gradlePlugin {
    plugins.register("playground-configs") {
        id = "playground-configs"
        implementationClass = "main.kotlin.com.playground.plugins.PlaygroundConfigsPlugin"
    }
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
