package com.example.mqpos.model.data_classes

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Todo(

    var id : Int?,

    var title :String,

    var expected_completion_date : String,

    var start_date : String,

    var percentage_done: Float
)
