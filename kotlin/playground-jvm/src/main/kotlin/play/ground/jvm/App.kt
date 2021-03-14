package play.ground.jvm

import com.playground.commons.models.ext.printSeparatorTitle
import play.ground.jvm.classload.CustomClassLoader.printOutClassLoader
import play.ground.jvm.classload.Delegation.printJava8DelegationForClassLoading

fun main() {
  println("Classloader App".printSeparatorTitle())
  printOutClassLoader()
  println("Classloader Delegations".printSeparatorTitle())
  printJava8DelegationForClassLoading()
}