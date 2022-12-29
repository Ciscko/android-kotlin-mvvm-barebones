package com.example.mqpos.model.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int?,

    @ColumnInfo(name = "title")
    var title :String,

    @ColumnInfo(name = "expected_completion_date")
    var expected_completion_date : String,

    @ColumnInfo(name = "start_date")
    var start_date : String,

    @ColumnInfo(name = "percentage_done")
    var percentage_done: Float

)
