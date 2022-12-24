package com.example.mqpos.model.data.db

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface PersonDao {
    @Insert
    fun insert(person : PersonEntity)

    @Update
    fun update(person : PersonEntity)

    @Query("SELECT * FROM person WHERE id=:key")
    fun get(key : Int): PersonEntity?

    @Query("DELETE FROM person WHERE id =:key")
    fun delete(key : Int)

    @Query("SELECT * FROM person")
    fun getAll()
}