package com.example.lab6_todo_navfrgmnt_retrofit.API

import com.example.lab6_todo_navfrgmnt_retrofit.Model.Task
import retrofit2.Call
import retrofit2.http.*

public interface ApiService {
    @GET("todos/")
    fun getTasks(): Call<MutableList<Task>>

    @GET("todos/{id}/")
    fun getTaskById(@Path("id") todoId: Int): Call<Task>


}

