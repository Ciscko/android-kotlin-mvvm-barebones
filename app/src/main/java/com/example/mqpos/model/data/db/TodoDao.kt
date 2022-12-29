package com.example.mqpos.model.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {
    @Insert
    fun insert(todo :  TodoEntity) : Unit

    @Update
    fun update(todo : TodoEntity) : Unit

    @Query("SELECT * FROM todo WHERE id=:key")
    fun get(key : Int) : TodoEntity

    @Query("DELETE FROM todo WHERE id=:key")
    fun delete(key : Int) : Unit

    @Query("SELECT * FROM todo")
    fun getAll() : List<TodoEntity>

}