package com.playground.commons.models.design

interface Configuration {
  operator fun get(key: String): String
}

class MapConfiguration : Configuration {

  val configurationManager: ConfigurationManager = ConfigurationManager

  override fun get(key: String): String {
    return configurationManager[key]
  }

}