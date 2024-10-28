package com.example.myapplicationmvc.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.myapplicationmvc.R
import com.example.myapplicationmvc.model.Task

class AddTaskFragment(private val onSaveTask: (Task) -> Unit) : Fragment() {

    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)
        titleEditText = view.findViewById(R.id.titleEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)
        saveButton = view.findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            val title = titleEditText.text.toString().trim()
            val description = descriptionEditText.text.toString().trim()

            if (title.isNotEmpty() && description.isNotEmpty()) {
                val newTask = Task(id = (0..1000).random(), title = title, description = description)
                onSaveTask(newTask)
            }
        }
        return view
    }
}
