package com.example.staterecyclerview.features.main

import android.content.Context
import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.staterecyclerview.data.Item

class MainViewModel(context: Context) : ViewModel() {

    private val repository = MainRepository(context)

    fun getTasks(): LiveData<List<Item>> =
        Transformations.map(repository.getTasks()) { it -> it.filter { !it.isDone } }

    fun getDoneTasks(): LiveData<List<Item>> {
        return Transformations.map(repository.getTasks()) { it -> it.filter { it.isDone } }
    }

    fun markTaskAsDone(item: Item, onCompleted: (Boolean) -> Unit) {
        if (repository.updateTask(item)) onCompleted(true)
    }

    fun cancelJobs() {
        repository.cancelJobs()
    }
}