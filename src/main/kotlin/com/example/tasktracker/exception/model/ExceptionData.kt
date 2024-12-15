package com.example.tasktracker.exception.model

import java.time.LocalDateTime

data class ExceptionData(
    val timestamp: LocalDateTime,
    val message: String,
    val status: Int
    )
