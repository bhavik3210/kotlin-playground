package main.kotlin

import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigurationPlugin : Plugin<Project>{
    override fun apply(target: Project) {
        println("=".repeat(50))
        println("Configuration Plugin creating")
        println("=".repeat(50))
    }
}