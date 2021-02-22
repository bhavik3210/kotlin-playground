plugins {
  `kotlin-dsl`
  `application`
  id("playground-configs")
  id("play-build")
}

repositories {
  jcenter()
}

application {
  // Define the main class for the application.
  mainClass.set("play.ground.app.AppKt")
}