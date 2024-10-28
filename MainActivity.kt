package com.example.myapplicationmvc.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationmvc.R
import com.example.myapplicationmvc.controller.TaskController
import com.example.myapplicationmvc.model.Task

class MainActivity : AppCompatActivity() {

    private val taskController = TaskController()
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuración del RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        taskAdapter = TaskAdapter(
            taskController.getTasks(),
            onTaskCompleted = { task -> updateTask(task) },
            onTaskDeleted = { task -> deleteTask(task) }
        )
        recyclerView.adapter = taskAdapter

        // Mostrar el fragmento para agregar una tarea
        findViewById<View>(R.id.addTaskButton).setOnClickListener {
            openFragment(AddTaskFragment { newTask -> addTask(newTask) })
        }
    }

    private fun addTask(task: Task) {
        taskController.addTask(task)
        taskAdapter.notifyDataSetChanged()
    }

    private fun updateTask(task: Task) {
        taskController.updateTask(task)
        taskAdapter.notifyDataSetChanged()
    }

    private fun deleteTask(task: Task) {
        taskController.deleteTask(task)
        taskAdapter.notifyDataSetChanged()
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}
