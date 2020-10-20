package com.example.midterm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(val todoList: ArrayList<TodoList>, val context: Context): RecyclerView.Adapter<TodoListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false)

        return MyViewHolder(view)
}
    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, ID: Int) {
        val todoList : TodoList = todoList.get(ID)
        holder.titleText.text = todoList.title
        holder.statusText.text = todoList.status
        holder.categoryText.text = todoList.category

    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleText: TextView = view.findViewById(R.id.title)
        var statusText: TextView = view.findViewById(R.id.status)
        var categoryText: TextView = view.findViewById(R.id.category)
    }


}