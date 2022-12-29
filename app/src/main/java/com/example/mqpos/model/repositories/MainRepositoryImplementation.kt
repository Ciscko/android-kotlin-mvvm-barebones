package com.example.qkpos.model.repositories

import com.example.mqpos.model.data.db.TodoEntity
import com.example.mqpos.model.data_classes.Todo
import com.example.qkpos.model.data.db.MainDataBase

class MainRepositoryImplementation(db : MainDataBase) : MainRepository(db) {

    override suspend fun getGreetings(): List<String> {
        return listOf("AWS", "Azure")
    }

    override suspend fun getTodos(): List<Todo> {
       val todosDao = db.todoDao.getAll()
        val todos : List<Todo> = todosDao.map {
            Todo(
                id = it.id, title = it.title,
                start_date = it.start_date,
                expected_completion_date = it.expected_completion_date,
                percentage_done = it.percentage_done
            )
        }
        return todos
    }

    override suspend fun getTodo(key : Int): Todo {
        val todoDao = db.todoDao.get(key)
        return Todo(
            id = todoDao.id, title = todoDao.title, percentage_done = todoDao.percentage_done,
            start_date = todoDao.start_date, expected_completion_date = todoDao.expected_completion_date
        )
    }

    override suspend fun insertTodo(todo: Todo) {
        db.todoDao.insert(todo = TodoEntity(
            id = null,
            title = todo.title,
            percentage_done = todo.percentage_done,
            start_date = todo.start_date,
            expected_completion_date = todo.expected_completion_date
        )
        )
    }

    override suspend fun deleteTodo(key: Int) {
        db.todoDao.delete(key)
    }

    override suspend fun updateTodo(todo: Todo) {
        db.todoDao.update(
            todo = TodoEntity(
                id = null,
                title = todo.title,
                percentage_done = todo.percentage_done,
                start_date = todo.start_date,
                expected_completion_date = todo.expected_completion_date
            )
        )
    }
}