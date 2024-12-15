package com.example.tasktracker.controller

import com.example.tasktracker.model.request.StateRequest
import com.example.tasktracker.model.response.DeleteResponse
import com.example.tasktracker.service.StateService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/states")
class StateController (
    val stateService: StateService,
) {
    @GetMapping
    fun getAll() = stateService.getAll()
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = stateService.getById(id)
    @PostMapping
    fun create(@RequestBody stateRequest: StateRequest) = stateService.create(stateRequest)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long, response: HttpServletResponse): DeleteResponse = stateService.delete(id)
}