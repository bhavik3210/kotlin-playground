package todo

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.cio.EngineMain.main(args)

val TodoContentV1 = ContentType("application", "vnd.todoapi.v1+json")

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Routing) {
        if (!testing) trace { application.log.trace(it.buildText()) }
        todoApi()
    }

    install(StatusPages) {
        this.exception<Throwable> { e ->
            call.respondText(e.localizedMessage, ContentType.Text.Plain)
            throw e
        }
    }

    install(ContentNegotiation) {
//        register(TodoContentV1, JacksonConverter()) - Equivalent to below
        jackson(TodoContentV1) {
            enable(SerializationFeature.INDENT_OUTPUT)
        }

        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
}

