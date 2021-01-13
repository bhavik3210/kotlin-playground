plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
    jcenter()
}

gradlePlugin {
    plugins.register("configuration") {
        id = "configuration"
        implementationClass = "ConfigurationPlugin.kt"
    }
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
