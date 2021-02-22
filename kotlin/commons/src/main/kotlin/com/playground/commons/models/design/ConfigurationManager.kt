package com.playground.commons.models.design

// Concrete class which is harder to test
object ConfigurationManager {

    private var configurationValues = HashMap<String, String>()

    init {
        configurationValues["logDirectory"] = "./logs"
        configurationValues["logBaseName"] = "userlog"
    }

    operator fun get(key: String): String {
        return configurationValues.getOrDefault(key, "")
    }
}
