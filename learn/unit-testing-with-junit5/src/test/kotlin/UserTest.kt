import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class UserTest {

    val user = User(1, "Jake")

    @Test
    fun `should be able to increase reputation`() {
        user.changeReputation(5)
        Assertions.assertEquals(5, user.reputation)
    }

    @Test
    fun `should be able to decrease reputation`() {
        user.changeReputation(10)
        user.changeReputation(-5)

        Assertions.assertEquals(5, user.reputation)
    }
}