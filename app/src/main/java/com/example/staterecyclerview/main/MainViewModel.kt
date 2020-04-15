package com.example.staterecyclerview.main

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.staterecyclerview.data.Item

class MainViewModel(context: Context) : ViewModel() {

    private val repository = MainRepository(context)

    fun getTasks(): LiveData<List<Item>> = repository.getTasks()

    fun cancelJobs() {
        repository.cancelJobs()
    }

}