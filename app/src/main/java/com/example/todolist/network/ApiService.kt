package com.example.todoapp.network


import com.example.todoapp.model.Todo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("todos/")
    fun getTodos(): Call<List<Todo>>


    @GET("todos/{id}/")
    fun getTodoById(@Path("id") todoId: Int): Call<Todo>
}