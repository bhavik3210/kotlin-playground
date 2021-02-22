package com.playground.training.ctci.chapter1

import junit.framework.Assert.assertEquals
import org.junit.Test

class Q1Test {

    private val testStrings = arrayOf(
        "apple",
        "orange",
        "The quick brown fox jumps over the lazy dog",
        "abcdefghi",
        "abc def ghi"
    )

    @Test
    fun `test and compare unique characters result from both solutions`() {
        testStrings.forEach {
            assertEquals(it.hasUniqueChars(), it.hasUniqueCharacters())
        }
    }


}