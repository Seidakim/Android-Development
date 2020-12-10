package com.example.lab5_todo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab5_todo.R
import com.example.lab5_todo.TaskListAdapter
import kotlinx.android.synthetic.main.fragment_todolist.*

class ToDoListFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_todolist, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tasks_recycle_view.adapter = TaskListAdapter(view.context)
        tasks_recycle_view.layoutManager = LinearLayoutManager(view.context)

        start_creating_button.setOnClickListener {

            it.findNavController().navigate(R.id.action_toDoListFragment_to_createFragment)
        }
    }

}