package com.example.staterecyclerview.features.create

import android.content.Context
import com.example.staterecyclerview.data.Item
import com.example.staterecyclerview.data.db.AppDatabase
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class TaskCreateRepository(private val context: Context) {

    fun createTask(task: Item): Boolean = CoroutineScope(IO).launch {
        AppDatabase.getInstance(context).itemDAO().insertItem(task)
    }.isCompleted
}