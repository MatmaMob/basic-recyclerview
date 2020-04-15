package com.example.staterecyclerview

import android.app.Application
import com.example.staterecyclerview.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class TodoApp : Application() {

    val applicationModule = module {
        viewModel { MainViewModel(applicationContext) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TodoApp)
            modules(applicationModule)
        }
    }
}