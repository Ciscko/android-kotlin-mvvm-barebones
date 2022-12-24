package com.example.mqpos.model.data.db

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface TodoDao {
    @Insert
    fun insert(todo :  TodoEntity)

    @Update
    fun update(todo : TodoEntity)

    @Query("SELECT * FROM todo WHERE id=:key")
    fun get(key : Int)

    @Query("DELETE FROM todo WHERE id=:key")
    fun delete(key : Int)

    @Query("SELECT * FROM todo")
    fun getAll()

}