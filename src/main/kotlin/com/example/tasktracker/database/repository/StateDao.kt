package com.example.tasktracker.database.repository

import com.example.tasktracker.database.entity.State
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StateDao: CrudRepository<State, Long> {
}