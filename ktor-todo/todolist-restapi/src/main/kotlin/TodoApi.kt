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

        get("/todos/{id}") {
            val id = call.parameters["id"]
            id?.let { idToBeFound ->
                try {
                    val todo = todos.firstOrNull { it.id == idToBeFound.toInt() }
                    todo?.let {
                        call.respond(todo)
                    } ?: call.respond(HttpStatusCode.NotFound)
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
            id?.let { idToBePatched ->
                val todoItem = todos.firstOrNull { it.id == idToBePatched.toInt() }
                todoItem?.let {
                    val todo = call.receive<TodoItem>()
                    todos = todos.filter { it.id != todoItem.id }
                    todos = todos + todo.copy(id = todoItem.id)
                    call.respond(HttpStatusCode.NoContent)
                } ?: call.respond(HttpStatusCode.Unauthorized)
            } ?: call.respond(HttpStatusCode.BadRequest)
        }

        delete("/todos/{id}") {
            val id = call.parameters["id"]
            id?.let { idToBeDeleted ->
                val todoItem = todos.firstOrNull { it.id == idToBeDeleted.toInt() }
                todoItem?.let {
                    todos = todos.filter { it.id != todoItem.id }
                    todos = todos
                    call.respond(HttpStatusCode.NoContent)
                }
            }
        }
    }
}