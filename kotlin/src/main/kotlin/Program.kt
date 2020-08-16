import java.time.LocalDate
import kotlin.math.ceil
import kotlin.math.floor

fun main() {

   val decimalValue = 12.4
    val wholeValue = 12.0


    println("${decimalValue - floor(decimalValue)} : ${isWholeNumber(decimalValue)}")
    println("${wholeValue - floor(wholeValue)} : ${isWholeNumber(wholeValue)}")

    println()
    println(ceil(decimalValue))
    println(ceil(wholeValue))


}

fun isWholeNumber(amount: Double): Boolean {
    return amount - floor(amount) == 0.0
}