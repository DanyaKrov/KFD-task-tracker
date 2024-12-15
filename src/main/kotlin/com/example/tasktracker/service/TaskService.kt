package com.example.tasktracker.service

import com.example.tasktracker.model.request.TaskRequest
import com.example.tasktracker.model.response.DeleteResponse
import com.example.tasktracker.model.response.TaskResponse
import org.springframework.stereotype.Service

@Service
interface TaskService {
    fun getAll(): List<TaskResponse>
    fun getById(id: Long): TaskResponse
    fun create(task: TaskRequest): TaskResponse
    fun update(id: Long, task: TaskRequest): TaskResponse
    fun delete(id: Long): DeleteResponse
}