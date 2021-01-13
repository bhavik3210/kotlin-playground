import org.amshove.kluent.`should be`
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeTrue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class UserTest {

    val user = User(1, "Jake")

    @Test
    fun `should be able to increase reputation`() {
        user.changeReputation(5)
        // Assertions.assertEquals(5, user.reputation) | Without Fluent

        // Equivalent to above with Assertions
        user.reputation.shouldBe(10)

        // Same as above but further refinement
        user.reputation.`should be`(10)

        // one more refinement with infix style
        user.reputation `should be` 10
    }

    @Test
    fun `should be able to decrease reputation`() {
        user.changeReputation(10)
        user.changeReputation(-5)

//        Assertions.assertEquals(5, user.reputation)

        // With Fluent
        user.reputation `should be` 5
    }
}