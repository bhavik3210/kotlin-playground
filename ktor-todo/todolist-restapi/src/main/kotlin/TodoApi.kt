package todo

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*


fun Routing.todoApi() {
    route("/api") {
        get("/todos") {
            call.respond(todos)
        }

        get("/todo/{id}") {
            val id = call.parameters["id"]
            id?.let {
                try {
                    val todo = todos[id.toInt()]
                    call.respond(todo)
                } catch (e: Throwable){
                    call.respond(HttpStatusCode.NotFound)
                }
            } ?: call.respond(HttpStatusCode.NotFound)
        }

        post("/todos") {
            call.respond(HttpStatusCode.Unauthorized)
        }
    }
}