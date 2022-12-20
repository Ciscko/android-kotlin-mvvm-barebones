package com.example.qkpos.model.repositories

import com.example.qkpos.model.data.db.MainDataBase

abstract class MainRepository(var db : MainDataBase) {
    abstract suspend fun getGreetings(): List<String>
}