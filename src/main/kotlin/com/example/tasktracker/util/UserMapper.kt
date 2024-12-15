package com.example.tasktracker.util

import com.example.tasktracker.database.entity.Task
import com.example.tasktracker.database.entity.User
import com.example.tasktracker.model.response.TaskResponse
import com.example.tasktracker.model.response.UserResponse
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun entityToResponse(entity: User): UserResponse {
        return UserResponse(
            id = entity.id,
            name = entity.name,
            created_at = entity.createdAt
        )

    }
}