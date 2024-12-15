package com.example.tasktracker.database.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "state")
class State (
    @Column(unique = true, nullable = false)
    val name: String
): AbstractEntity() {}