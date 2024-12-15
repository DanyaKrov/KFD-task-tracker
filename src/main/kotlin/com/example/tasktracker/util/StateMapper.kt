package com.example.tasktracker.util

import com.example.tasktracker.database.entity.State
import com.example.tasktracker.model.response.StateResponse
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class StateMapper {
    fun entityToResponse(entity: State): StateResponse {
        return StateResponse (
            id = entity.id,
            name = entity.name,
            created_at = entity.createdAt
        )
    }
}