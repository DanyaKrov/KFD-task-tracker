package com.example.tasktracker.controller

import com.example.tasktracker.model.request.UserRequest
import com.example.tasktracker.model.response.DeleteResponse
import com.example.tasktracker.service.UserService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController (
    private val userService: UserService,
) {
    @GetMapping
    fun getAll() = userService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = userService.getById(id)

    @GetMapping("/{id}/tasks")
    fun getTasks(@PathVariable id: Long) = userService.getTasks(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: UserRequest) = userService.update(id, user)

    @PostMapping
    fun create(@RequestBody user: UserRequest) = userService.create(user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long, response: HttpServletResponse): DeleteResponse = userService.delete(id)
}