package com.example.lab5_todo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.lab5_todo.MainActivity
import com.example.lab5_todo.R
import com.example.lab5_todo.TaskListAdapter
import com.example.lab5_todo.model.Task
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_todolist.*

class DetailFragment(): Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val taskId = arguments?.getInt("taskId")!!

        val task = MainActivity.tasks[taskId]

        view.findViewById<TextInputLayout>(R.id.edit_title).editText!!.setText(task.title)
        view.findViewById<TextInputLayout>(R.id.edit_description).editText!!.setText(task.description)
        view.findViewById<TextInputLayout>(R.id.edit_category).editText!!.setText(task.category)
        view.findViewById<TextInputLayout>(R.id.edit_status).editText!!.setText(task.status)
        view.findViewById<TextInputLayout>(R.id.edit_duration).editText!!.setText(task.duration)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val taskId = arguments?.getInt("taskId")!!
        val task = MainActivity.tasks[taskId]
        save_task_button.setOnClickListener{
            val updatedTask = Task()
            updatedTask.title = edit_title.editText!!.text.toString()
            updatedTask.status = edit_status.editText!!.text.toString()
            updatedTask.description = edit_description.editText!!.text.toString()
            updatedTask.category = edit_category.editText!!.text.toString()
            updatedTask.duration = edit_duration.editText!!.text.toString()
            updatedTask.id = taskId
            MainActivity.tasks.remove(task)
            MainActivity.tasks.add(updatedTask)

            it.findNavController().navigate(R.id.action_detailFragment_to_toDoListFragment)
        }

        delete_task_button.setOnClickListener{
            MainActivity.taskDao.delete(task)
            MainActivity.tasks.remove(task)

            it.findNavController().navigate(R.id.action_detailFragment_to_toDoListFragment)
        }
    }
}