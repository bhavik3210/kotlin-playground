@file:Suppress("ClassName")

import org.amshove.kluent.`should not throw`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class QuestionTest {

    val user = User(1, "Derek")

    @Nested
    // equivalent (optional) inner class ` constructor should `
    inner class Constructor {
        @Test
        fun `should throw an exception if the title is empty`() {
            // Without Fluent
//            Assertions.assertThrows(QuestionException::class.java) {
//                Question(1, user, "", "question?")
//            }

            // With Fluent and Equivalent test as above with Assertions
            invoking { Question(1, user, "", "question?") } `should throw` QuestionException::class
        }

        @Test
        fun `should not throw exception if the question is valid`() {
//            Assertions.assertDoesNotThrow {
//                Question(1, user, "title", "question?")
//            }

            invoking { Question(1, user, "title", "question?") } `should not throw` QuestionException::class
        }

        @ParameterizedTest
        @CsvSource(
                "' ', question",
                "'', question",
                "title, ''",
                "title, ' '")
        fun `throw an exception if title or question is invalid`(title: String, body: String) {
//            Assertions.assertThrows(QuestionException::class.java) {
//                Question(1, user, title, body)
//            }

            // example with Fluent (equivalent to above)
            invoking { Question(1, user, title, body) } `should throw` QuestionException::class
        }
    }

    // Commented Code below is the equivalent of the active code (uncommented) directly after that.
    // only difference is the uncommented code is NOT using the custom annotation while the bottom one is
//    @Nested
//    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
//    inner class `constructor should with method source` {
//
//        @Suppress("unused")
//        fun titlesAndQuestionsParameters() = listOf(
//                Arguments.of("", "questions"),
//                Arguments.of(" ", "questions"),
//                Arguments.of("title", ""),
//                Arguments.of("title", " ")
//        )
//
//        @ParameterizedTest
//        @MethodSource("titlesAndQuestionsParameters")
//        fun `throw an exception if title or question is invalid`(title: String, question: String) {
//            Assertions.assertThrows(QuestionException::class.java) {
//                Question(1, user, title, question)
//            }
//        }
//
//    }

    @Nested
    @KotlinParameterizedTests
    inner class `constructor should with method source` {

        @Suppress("unused")
        fun titlesAndQuestionsParameters() = listOf(
                Arguments.of("", "questions"),
                Arguments.of(" ", "questions"),
                Arguments.of("title", ""),
                Arguments.of("title", " ")
        )

        @ParameterizedTest
        @MethodSource("titlesAndQuestionsParameters")
        fun `throw an exception if title or question is invalid`(title: String, question: String) {
            Assertions.assertThrows(QuestionException::class.java) {
                Question(1, user, title, question)
            }
        }

    }
}