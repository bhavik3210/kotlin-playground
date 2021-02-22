plugins {
  `kotlin-dsl`
  id("playground-configs")
  id("play-build")
}

repositories {
  jcenter()
}

tasks.test {
  useJUnitPlatform()
}

dependencies {
  testImplementation(main.kotlin.Dependencies.Test.jUnit)
  testImplementation(main.kotlin.Dependencies.Test.kFluent)
  testImplementation(main.kotlin.Dependencies.Test.mock)
}