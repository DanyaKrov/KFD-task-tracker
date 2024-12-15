package com.example.tasktracker.model.response

import java.time.LocalDateTime

data class StateResponse (
    val id: Long,
    val created_at: LocalDateTime,
    val name: String
)