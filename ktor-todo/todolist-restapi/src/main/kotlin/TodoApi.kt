package todo

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Routing.todoApi() {
    route("/api") {
//        header("Accept", "application/vnd.todoapi.v1+json") {
//            get("/todos") {
//                call.respond(todos)
//            }
//        } - equivalent to below
        accept(TodoContentV1) {
            get("/todos") {
                call.respond(todos)
            }
        }

        get("/todos") {
            call.respond(todos)
        }

        get("/todo/{id}") {
            val id = call.parameters["id"]
            id?.let {
                try {
                    val todo = todos[id.toInt()]
                    call.respond(todo)
                } catch (e: Throwable) {
                    call.respond(HttpStatusCode.NotFound)
                }
            } ?: call.respond(HttpStatusCode.BadRequest)
        }

        post("/todos") {
            val todo = call.receive<TodoItem>()
            val newItem = TodoItem(
                todos.size + 1,
                todo.title,
                todo.details,
                todo.assignedTo,
                todo.dueDate,
                todo.importance
            )

            todos = todos + newItem

            call.respond(HttpStatusCode.Created, todos)
        }

        patch("/todos/{id}") {
            val id = call.parameters["id"]
            id?.let {
                val todoItem = todos.getOrNull(id.toInt())
                todoItem?.let {
                    val todo = call.receive<TodoItem>()
                    todos = todos.filter { it.id != todo.id }
                    todos = todos + todo
                    call.respond(HttpStatusCode.NoContent)
                } ?: call.respond(HttpStatusCode.Unauthorized)
            } ?: call.respond(HttpStatusCode.BadRequest)
        }
    }
}