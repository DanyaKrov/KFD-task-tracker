package com.example.tasktracker.service

import com.example.tasktracker.database.entity.User
import com.example.tasktracker.model.request.TaskRequest
import com.example.tasktracker.model.request.UserRequest
import com.example.tasktracker.model.response.DeleteResponse
import com.example.tasktracker.model.response.TaskResponse
import com.example.tasktracker.model.response.UserResponse
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun getById(id: Long): User
    fun getAll(): List<UserResponse>
    fun update(id: Long, user: UserRequest): UserResponse
    fun getTasks(id: Long): List<TaskResponse>
    fun delete(id: Long): DeleteResponse
    fun create(task: UserRequest): UserResponse
}