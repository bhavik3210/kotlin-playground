package ctci.chapter1

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
fun hasUniqueCharacters(string: String): Boolean {
    //Using existing data structure
    val hashMap: MutableMap<Any, Any?> = mutableMapOf()
    string.forEach {
        if(hashMap.containsKey(it)) return false
        else hashMap.put(it, null)
    }
    return true
}

//suggested solution
fun hasUniqueChars(string: String): Boolean {
    if (string.length > 128) return false
    val allASCIICharacters = BooleanArray(128)
    for (i in 0 until string.length) {
        val value = string[i].toInt()
        if (allASCIICharacters[value] == true) {
            return false
        }
        allASCIICharacters[value] = true
    }
    return true
}
