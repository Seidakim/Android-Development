package com.example.lab5_todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5_todo.dao.TaskDao
import com.example.lab5_todo.fragments.CreateFragment
import com.example.lab5_todo.fragments.DetailFragment
import com.example.lab5_todo.fragments.ToDoListFragment
import com.example.lab5_todo.model.Task
import kotlinx.android.synthetic.main.fragment_create.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.singletask_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MyApplication.instance.getDatabase()!!
        taskDao = db.TaskDao()

        tasks = taskDao.getAll()

    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host_fragment).navigateUp()

    companion object {
        lateinit var tasks: MutableList<Task>
        lateinit var db: AppDatabase
        lateinit var taskDao: TaskDao
        lateinit var instance: MainActivity

    }
}