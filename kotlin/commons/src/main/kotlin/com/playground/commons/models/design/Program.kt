package com.playground.commons.models.design

import design.NioFiles
import design.NioPaths

fun main() {
  val logger = Logger(MapConfiguration(), NioPaths(), NioFiles())

  // val filename = logger.createLog("./logs", "userlog");
  val filename = logger.createLog()
  println("Created: $filename")
}
