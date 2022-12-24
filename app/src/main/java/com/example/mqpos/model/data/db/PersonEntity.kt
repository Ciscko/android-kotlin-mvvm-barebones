package com.example.mqpos.model.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int,

    @ColumnInfo(name = "name")
    var name : String
)
