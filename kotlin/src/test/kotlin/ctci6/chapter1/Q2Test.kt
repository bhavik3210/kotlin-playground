package ctci6.chapter1

import junit.framework.Assert.assertEquals
import org.junit.Test

class Q2Test {

    @Test
    fun `test if first string is a permutation of second string or vice versa`() {
        assertEquals(true, isPermutation("abc", "bca"))
        assertEquals(false, isPermutation("orange", "roanje"))
        assertEquals(true, isPermutation("orange", "roange"))
    }


}