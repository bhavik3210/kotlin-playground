import java.time.LocalDate
import kotlin.math.ceil
import kotlin.math.floor

fun main() {

//    val decimalValue = 12.4
//    val wholeValue = 12.0
//
//
//    println("${decimalValue - floor(decimalValue)} : ${isWholeNumber(decimalValue)}")
//    println("${wholeValue - floor(wholeValue)} : ${isWholeNumber(wholeValue)}")
//
//    println()
//    println(ceil(decimalValue))
//    println(ceil(wholeValue))



    val decimalValue = listOf<String>("hello", "haha", "world", "!")

    val result = decimalValue.filter { it.contains("!") }
        .filter { it != "hello" }
        .map { it.capitalize() }

    print(result)
    val asdfsdf = "AFSDFasdfasdf AFDSFasdf"
    println(asdfsdf.toLowerCase())

}

fun isWholeNumber(amount: Double): Boolean {
    return amount - floor(amount) == 0.0
}