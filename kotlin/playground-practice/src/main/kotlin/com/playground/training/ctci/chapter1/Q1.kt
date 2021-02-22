package com.playground.training.ctci.chapter1

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
fun String.hasUniqueCharacters(): Boolean {
  //Using existing data structure
  val hashMap: MutableMap<Any, Any?> = mutableMapOf()
  this.forEach {
    if (hashMap.containsKey(it)) return false
    else hashMap.put(it, null)
  }
  return true
}

//suggested solution
fun String.hasUniqueChars(): Boolean {
  if (this.length > 128) return false
  val allASCIICharacters = BooleanArray(128)
  for (element in this) {
    val value = element.toInt()
    if (allASCIICharacters[value]) {
      return false
    }
    allASCIICharacters[value] = true
  }
  return true
}
