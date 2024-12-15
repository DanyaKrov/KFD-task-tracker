package com.example.tasktracker.database.repository

import com.example.tasktracker.database.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao: CrudRepository<User, Long> {
    fun getById(id: Long): MutableList<User>
}