package com.example.todoapp.network


import com.example.todolist.ToDo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("todos/")
    fun getTodos(): Call<List<ToDo>>

    @POST("todos/")
    fun postTodos(item:ToDo): Call<ToDo>


    @GET("todos/{id}/")
    fun getTodoById(@Path("id") todoId: Int): Call<ToDo>
}