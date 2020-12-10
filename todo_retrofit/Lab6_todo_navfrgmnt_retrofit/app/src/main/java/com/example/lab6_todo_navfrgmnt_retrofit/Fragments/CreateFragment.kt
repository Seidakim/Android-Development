package com.example.lab6_todo_navfrgmnt_retrofit.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.lab6_todo_navfrgmnt_retrofit.MainActivity
import com.example.lab6_todo_navfrgmnt_retrofit.Model.Task
import com.example.lab6_todo_navfrgmnt_retrofit.R
import com.example.lab6_todo_navfrgmnt_retrofit.TaskListAdapter
import kotlinx.android.synthetic.main.fragment_create.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

            it.findNavController().navigate(R.id.action_createFragment_to_toDoListFragment)
        }
    }
}