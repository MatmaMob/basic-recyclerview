package com.example.staterecyclerview.features.create

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.staterecyclerview.data.Item

class TaskCreateViewModel(context: Context) : ViewModel() {

    private val repository = TaskCreateRepository(context)

    fun createTask(task: Item, onCompleted: (Boolean) -> Unit) {
        onCompleted(repository.createTask(task))
    }
}