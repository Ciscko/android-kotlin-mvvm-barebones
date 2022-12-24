package com.example.qkpos.model.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mqpos.model.data.db.PersonDao
import com.example.mqpos.model.data.db.PersonEntity
import com.example.mqpos.model.data.db.TodoDao
import com.example.mqpos.model.data.db.TodoEntity

@Database(
    entities = [PersonEntity::class, TodoEntity::class],
    version = 1,
    exportSchema = false
    )
abstract class MainDataBase: RoomDatabase(){
    abstract val todoDao : TodoDao
    abstract val personDao : PersonDao

    companion object {

        @Volatile
        private var databaseInstance : MainDataBase? = null

        fun getDatabaseInstance(context : Context) : MainDataBase {
            synchronized(this){
                    var instance = databaseInstance
                    if(instance == null){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            MainDataBase::class.java,
                            "main_database"
                        ).fallbackToDestructiveMigration().build()
                    }
                    return instance
            }
        }


    }
}