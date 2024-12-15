package com.example.tasktracker.service.impl

import com.example.tasktracker.database.entity.Task
import com.example.tasktracker.database.repository.TaskDao
import com.example.tasktracker.exception.NotFoundException
import com.example.tasktracker.model.request.TaskRequest
import com.example.tasktracker.model.response.DeleteResponse
import com.example.tasktracker.model.response.TaskResponse
import com.example.tasktracker.service.StateService
import com.example.tasktracker.service.TaskService
import com.example.tasktracker.service.UserService
import com.example.tasktracker.util.TaskMapper
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl(
    val taskDao: TaskDao,
    val taskMapper: TaskMapper,
    val stateService: StateService,
    private val userService: UserService,
) : TaskService {
    override fun getAll(): List<TaskResponse> =
        taskDao.findAll().map { taskMapper.entityToResponse(it)
         }

    override fun getById(id: Long): TaskResponse =
        taskMapper.entityToResponse(taskDao.findById(id).orElseThrow {throw NotFoundException() })

    override fun create(task: TaskRequest): TaskResponse {
        val entity = Task (
            title = task.title,
            description = task.description,
        ).apply {
            state = stateService.getById(task.stateId)
            users = task.userIds.map { userService.getById(it) }
        }
        return taskMapper.entityToResponse(taskDao.save(entity))
    }

    override fun update(id: Long, task: TaskRequest): TaskResponse {
        val entity = taskDao.findById(id).orElseThrow {throw RuntimeException("") }
            .apply {
                title = task.title
                description = task.description
                state = stateService.getById(id)
                users = task.userIds.map { userService.getById(it) }
            }
        return taskMapper.entityToResponse(taskDao.save(entity))
    }

    override fun delete(id: Long): DeleteResponse {
        val entity = taskDao.findById(id).orElseThrow {throw RuntimeException("") }
        taskDao.delete(entity)
        return DeleteResponse()
    }
}