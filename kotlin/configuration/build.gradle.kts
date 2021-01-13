plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
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
