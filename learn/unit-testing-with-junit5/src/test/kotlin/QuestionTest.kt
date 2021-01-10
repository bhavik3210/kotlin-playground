import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class QuestionTest {

    val user = User(1, "Derek")

    @Nested
    // equivalent (optional) inner class ` constructor should `
    inner class Constructor {
        @Test
        fun `should throw an exception if the title is empty`() {
            Assertions.assertThrows(QuestionException::class.java) {
                Question(1, user, "", "question?")
            }
        }

        @Test
        fun `should not throw exception if the question is valid`() {
            Assertions.assertDoesNotThrow {
                Question(1, user, "title", "question?")
            }
        }
    }
}