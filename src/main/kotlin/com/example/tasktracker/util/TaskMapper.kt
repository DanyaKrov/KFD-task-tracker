package com.example.tasktracker.util

import com.example.tasktracker.database.entity.Task
import com.example.tasktracker.model.response.TaskResponse
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class TaskMapper {
    fun entityToResponse(entity: Task): TaskResponse {
        return TaskResponse(
            id = entity.id,
            description = entity.description,
            createdAt = entity.createdAt,
            title = entity.title,
            state = entity.state?.name ?: "",
            users = entity.users.map { user -> user.name }
        )
    }
}