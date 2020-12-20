import java.time.LocalDate
import kotlin.math.ceil
import kotlin.math.floor

fun main() {




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