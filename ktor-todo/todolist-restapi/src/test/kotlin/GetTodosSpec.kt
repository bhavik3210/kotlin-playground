import io.ktor.config.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.amshove.kluent.`should be`
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import todo.module

object GetTodosSpec : Spek({

    describe("Get the Todos") {
        val engine = TestApplicationEngine(createTestEnvironment())
        engine.start(wait = false)
        with(engine) {
            (environment.config as MapApplicationConfig).apply {
                put("ktor.environment", "test")
            }
        }

        engine.application.module(true)

        with(engine) {
            it("should be OK to get the list of todos") {
                handleRequest(HttpMethod.Get, "/api/todos").apply {
                    response.status().`should be`(HttpStatusCode.OK)
                }
            }
        }
    }
})