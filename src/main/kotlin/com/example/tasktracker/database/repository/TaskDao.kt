package com.example.tasktracker.database.repository

import com.example.tasktracker.database.entity.Task
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskDao: CrudRepository<Task, Long> {
}