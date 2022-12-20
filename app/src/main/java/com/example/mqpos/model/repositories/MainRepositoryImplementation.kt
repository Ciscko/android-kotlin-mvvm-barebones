package com.example.qkpos.model.repositories

import com.example.qkpos.model.data.db.MainDataBase

class MainRepositoryImplementation(db : MainDataBase) : MainRepository(db) {

    override suspend fun getGreetings(): List<String> {
        return db.getData()
    }

}