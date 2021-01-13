plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("org.jetbrains.kotlin.jvm") version "1.3.71"
}

repositories {
    jcenter()
}

gradlePlugin {
    plugins.register("configs") {
        id = "configs"
        implementationClass = "main.kotlin.com.kotlin.plugins.ConfigsPlugin"
    }
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
