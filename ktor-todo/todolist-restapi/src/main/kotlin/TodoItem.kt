package todo

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import java.time.LocalDate

data class TodoItem(
        val title: String,
        val details: String,
        val assignedTo: String,
        @JsonSerialize(using = ToStringSerializer::class)
        @JsonDeserialize(using = LocalDateDeserializer::class)
        val dueDate: LocalDate,
        val importance: Int
)

val todo1 = TodoItem(
        "Add RestAPI Data Access",
        "Add database support",
        "Me",
        LocalDate.of(2018, 12, 18),
        1
)

val todo2 = TodoItem(
        "Add RestAPI Service",
        "Add a service to get the data",
        "Me",
        LocalDate.of(2018, 12, 18),
        1
)