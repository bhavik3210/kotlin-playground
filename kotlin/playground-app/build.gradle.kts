plugins {
  `kotlin-dsl`
  `application`
  id("playground-configs")
  id("play-build")
}

repositories {
  jcenter()
}

dependencies {
  testImplementation(main.kotlin.Dependencies.Test.jUnit)
  testImplementation(main.kotlin.Dependencies.Test.kFluent)
  testImplementation(main.kotlin.Dependencies.Test.mock)
}

application {
  // Define the main class for the application.
  mainClass.set("play.ground.app.AppKt")
}