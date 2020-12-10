package com.example.lab5_todo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.lab5_todo.MainActivity
import com.example.lab5_todo.R
import com.example.lab5_todo.TaskListAdapter
import com.example.lab5_todo.model.Task
import kotlinx.android.synthetic.main.fragment_create.*
import kotlinx.android.synthetic.main.fragment_todolist.*

class CreateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        create_task_button.setOnClickListener {
            val task = Task()
            task.title = create_title.editText!!.text.toString()
            task.status = create_status.editText!!.text.toString()
            task.description = create_description.editText!!.text.toString()
            task.category = create_category.editText!!.text.toString()
            task.duration = create_duration.editText!!.text.toString()
            MainActivity.taskDao.insert(task)
            MainActivity.tasks.add(task)

            it.findNavController().navigate(R.id.action_createFragment_to_toDoListFragment)
        }
    }
}