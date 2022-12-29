package com.example.mqpos.model.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PersonDao {

    @Insert
    fun insert(person : PersonEntity) : Unit

    @Update
    fun update(person : PersonEntity) : Unit

    @Query("SELECT * FROM person WHERE id=:key")
    fun get(key : Int): PersonEntity?

    @Query("DELETE FROM person WHERE id =:key")
    fun delete(key : Int) : Unit

    @Query("SELECT * FROM person")
    fun getAll() : List<PersonEntity>?
}