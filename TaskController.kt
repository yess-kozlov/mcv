package com.example.myapplicationmvc.controller

import com.example.myapplicationmvc.model.Task

class TaskController {

    private val tasks = mutableListOf<Task>()

    fun getTasks(): List<Task> {
        return tasks
    }

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun updateTask(updatedTask: Task) {
        val taskIndex = tasks.indexOfFirst { it.id == updatedTask.id }
        if (taskIndex != -1) {
            tasks[taskIndex] = updatedTask
        }
    }

    fun deleteTask(task: Task) {
        tasks.remove(task)
    }
}
