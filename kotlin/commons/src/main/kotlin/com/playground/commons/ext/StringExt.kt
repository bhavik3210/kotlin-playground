package com.playground.commons.ext

fun String.printSeparatorTitle(): String {
  return "${50.separator()}\n $this \n${50.separator()}"
}