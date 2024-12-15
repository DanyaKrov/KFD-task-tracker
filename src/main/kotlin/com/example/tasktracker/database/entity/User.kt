package com.example.tasktracker.database.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "`user`")
class User (
    @Column(nullable = false)
    var name: String
): AbstractEntity() {
    @ManyToMany(mappedBy = "users")
    val tasks: List<Task> = listOf()
}