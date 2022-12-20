package com.example.qkpos.model.data.db

import android.content.Context

class MainDataBase(context: Context) {
    fun getData() : List<String> {
        return listOf("PL 900","Koding & Kahawa Data Science",  "AWS Practioner", "AWS Developer", "PMP", "UiARD")
    }
}