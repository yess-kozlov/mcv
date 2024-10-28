package com.example.myapplicationmvc.model

data class Task(
    val id: Int,
    var title: String,
    var description: String,
    var completed: Boolean = false
)
