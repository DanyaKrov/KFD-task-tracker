package com.example.tasktracker.service.impl

import com.example.tasktracker.database.entity.User
import com.example.tasktracker.database.repository.UserDao
import com.example.tasktracker.exception.NotFoundException
import com.example.tasktracker.model.request.UserRequest
import com.example.tasktracker.model.response.DeleteResponse
import com.example.tasktracker.model.response.TaskResponse
import com.example.tasktracker.model.response.UserResponse
import com.example.tasktracker.service.UserService
import com.example.tasktracker.util.TaskMapper
import com.example.tasktracker.util.UserMapper
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val dao: UserDao,
    val mapper: UserMapper,
    val taskMapper: TaskMapper,
): UserService {
    override fun getById(id: Long): User =
        dao.findById(id).orElseThrow {throw NotFoundException()}

    override fun getAll(): List<UserResponse> = dao.findAll().map { mapper.entityToResponse(it) }

    override fun update(id: Long, user: UserRequest): UserResponse {
        val entity = getById(id)
        entity.name = user.name
        return mapper.entityToResponse(dao.save(entity))
    }

    override fun getTasks(id: Long): List<TaskResponse> {
        val entity = dao.findById(id).orElseThrow {throw NotFoundException()}
        return entity.tasks.map {
            taskMapper.entityToResponse(it)
        }
    }

    override fun delete(id: Long): DeleteResponse {
        val entity = getById(id)
        dao.delete(entity)
        return DeleteResponse()
    }

    override fun create(task: UserRequest): UserResponse {
        val entity = User(name = task.name)
        return mapper.entityToResponse(dao.save(entity))
    }
}