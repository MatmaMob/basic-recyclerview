package com.example.staterecyclerview.features.main

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.staterecyclerview.data.Item
import com.example.staterecyclerview.data.db.AppDatabase
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainRepository(private val context: Context) {
    lateinit var job: CompletableJob

    fun getTasks(): LiveData<List<Item>> {
        job = Job()
        return object : LiveData<List<Item>>() {
            override fun onActive() {
                super.onActive()
                job.let { innerJob ->
                    CoroutineScope(IO + innerJob).launch {
                        val tasks = AppDatabase.getInstance(context).itemDAO().getItemsList()
                        withContext(Main) {
                            value = tasks
                            innerJob.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs() {
        job.cancel()
    }
}