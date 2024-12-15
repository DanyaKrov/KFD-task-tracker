package com.example.tasktracker.exception.controller

import com.example.tasktracker.exception.AlreadyExistsException
import com.example.tasktracker.exception.model.ExceptionData
import com.example.tasktracker.exception.NotFoundException
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class ExceptionResolver {
    @ExceptionHandler(AlreadyExistsException::class)
    fun alreadyExistsExceptionHandler(exception: Exception, response: HttpServletResponse): ExceptionData {
        response.status = 400
        return ExceptionData(
            LocalDateTime.now(),
            "Данный статус уже существует",
            400
        )
    }


    @ExceptionHandler(NotFoundException::class)
    fun notFoundExceptionHandler(exception: Exception, response: HttpServletResponse): ExceptionData {
        response.status = 404
        return ExceptionData(
            LocalDateTime.now(),
            "Данная ячейка не существует",
            404
        )
    }
    @ExceptionHandler(Exception::class)
    fun exceptionHandler(exception: Exception, response: HttpServletResponse): ExceptionData {
        response.status = 500
        return ExceptionData(
            LocalDateTime.now(),
            "Что-то пошло не так",
            500
        )
    }
}