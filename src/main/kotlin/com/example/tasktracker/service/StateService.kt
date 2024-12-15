package com.example.tasktracker.service

import com.example.tasktracker.database.entity.State
import com.example.tasktracker.model.request.StateRequest
import com.example.tasktracker.model.response.DeleteResponse
import com.example.tasktracker.model.response.StateResponse
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service

@Service
interface StateService {
    fun getById(id: Long): State
    fun getAll(): List<StateResponse>
    fun create(stateRequest: StateRequest): StateResponse
    fun delete(id: Long): DeleteResponse
}