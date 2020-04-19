package com.example.staterecyclerview.features.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.staterecyclerview.R
import com.example.staterecyclerview.adapter.ItemsAdapter
import com.example.staterecyclerview.data.Item
import com.example.staterecyclerview.features.create.TaskCreateActivity
import com.example.staterecyclerview.utils.DateUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    /**
     * Todo app
     * Reminds you to build list every day
     * Works only for current day
     * Productivity reason
     * after click assign time to list element when task was finished
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewModel()
        setUI()
    }

    override fun onResume() {
        super.onResume()
        setViewModel()
    }

    private fun setViewModel() {
        mainViewModel.getTasks().observe(this, Observer {
            setItemsRecyclerView(it)
        })
    }

    private fun setUI() {
        createTaskBtn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    TaskCreateActivity::class.java
                )
            )
        }
        setDateLayout()
    }

    private fun setDateLayout() {

        DateUtil.getCurrentDay().let {
            dayView.text = it
        }

        DateUtil.getDate().let {
            dateView.text = it
        }
    }

    private fun setItemsRecyclerView(list: List<Item>) {
        val adapter = ItemsAdapter(list, this) {
            it.isDone = true
            mainViewModel.markTaskAsDone(it) {

            }
        }
        itemsRecyclerView.layoutManager = LinearLayoutManager(this)
        itemsRecyclerView.adapter = adapter
    }

    override fun onStop() {
        super.onStop()
        mainViewModel.cancelJobs()
    }
}
