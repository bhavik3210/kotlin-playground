import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.ktor.config.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.amshove.kluent.`should be`
import org.amshove.kluent.shouldContain
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotBeNull
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import todo.Importance
import todo.TodoItem
import todo.module
import java.time.LocalDate

object GetTodosSpec : Spek({

    describe("Get the Todos") {
        val engine = TestApplicationEngine(createTestEnvironment())
        engine.start(wait = false)

        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())

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

            it("should get the todos") {
                with(handleRequest(HttpMethod.Get, "/api/todos")) {
                    response.content
                        .shouldNotBeNull()
                        .shouldContain("database")
                }
            }

            it("should get the todo if the id is set") {
                with(handleRequest(HttpMethod.Get, "/api/todos/1")) {
                    response.content
                        .shouldNotBeNull()
                        .shouldContain("database")
                }
            }

            it("should create a todo") {
                with(handleRequest(HttpMethod.Post, "/api/todos") {
                    addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                    setBody(mapper.writeValueAsString(todo))
                }) {
                    response.status().`should be`(HttpStatusCode.Created)
                }
            }

            it("should update the todos") {
                with(handleRequest(HttpMethod.Patch, "/api/todos/1") {
                    addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                    setBody(mapper.writeValueAsString(todo))
                }) {
                    response.status().`should be`(HttpStatusCode.NoContent)
                }
            }

            it("should delete the todos") {
                with(handleRequest(HttpMethod.Delete, "/api/todos/1")) {
                    response.status().`should be`(HttpStatusCode.NoContent)
                }
            }

            it("should return an error if the id is invalid") {
                with(handleRequest(HttpMethod.Get, "/api/todos/4")) {
                    response.status().shouldEqual(HttpStatusCode.NotFound)
                }
            }
        }
    }
})

val todo = TodoItem(
    1,
    "Add database processing",
    "Add backend support to this code",
    "Kevin",
    LocalDate.of(2018, 12, 18),
    Importance.LOW
)