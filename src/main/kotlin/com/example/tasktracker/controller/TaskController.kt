package com.example.tasktracker.controller

import com.example.tasktracker.model.request.TaskRequest
import com.example.tasktracker.model.response.DeleteResponse
import com.example.tasktracker.model.response.TaskResponse
import com.example.tasktracker.service.TaskService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tasks")
class TaskController (
    val taskService: TaskService,
) {
    @GetMapping
    fun getAll() = taskService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = taskService.getById(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody task: TaskRequest) =
        taskService.update(id, task)

    @PostMapping
    fun onCreate(@RequestBody task: TaskRequest) = taskService.create(task)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long, response: HttpServletResponse): DeleteResponse = taskService.delete(id)
}