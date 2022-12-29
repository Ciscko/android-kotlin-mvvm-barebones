package com.example.qkpos.model.repositories

import com.example.mqpos.model.data.db.TodoEntity
import com.example.mqpos.model.data_classes.Todo
import com.example.qkpos.model.data.db.MainDataBase

abstract class MainRepository(var db : MainDataBase) {
    abstract suspend fun getGreetings(): List<String>

    abstract suspend fun getTodos() : List<Todo>

    abstract suspend fun getTodo(key : Int) : Todo

    abstract suspend fun insertTodo(todo : Todo)

    abstract suspend fun deleteTodo(key : Int)

    abstract suspend fun updateTodo(todo : Todo)
}