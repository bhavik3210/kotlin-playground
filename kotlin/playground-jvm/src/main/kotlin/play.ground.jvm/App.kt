package play.ground.jvm

import com.playground.commons.models.ext.printSeparatorTitle
import play.ground.jvm.classload.CustomClassLoader.printOutClassLoader

fun main() {
  println("Classloader App".printSeparatorTitle())
  printOutClassLoader()
}