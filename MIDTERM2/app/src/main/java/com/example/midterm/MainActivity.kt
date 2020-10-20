package com.example.midterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    val todoList = ArrayList<TodoList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoListAdapter = TodoListAdapter(todoList ,this)
        val layoutManager = LinearLayoutManager(this)



    }

    fun onClick(view: View) {
        val intent = Intent(this,DetailPage::class.java)
        startActivity(intent)

    }





}