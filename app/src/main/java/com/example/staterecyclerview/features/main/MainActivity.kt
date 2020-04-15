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

    fun setViewModel() {
        mainViewModel.getTasks().observe(this, Observer {
            setItemsRecyclerView(it)
        })
    }

    fun setUI() {
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

    fun setDateLayout() {

        DateUtil.getCurrentDay().let {
            dayView.text = it
        }

        DateUtil.getDate().let {
            dateView.text = it
        }
    }

    fun setItemsRecyclerView(list: List<Item>) {
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        divider.setDrawable(getDrawable(R.drawable.divider)!!)

        val adapter = ItemsAdapter(list) {}
        itemsRecyclerView.layoutManager = LinearLayoutManager(this)
        itemsRecyclerView.addItemDecoration(divider)
        itemsRecyclerView.adapter = adapter
    }

    override fun onStop() {
        super.onStop()
        mainViewModel.cancelJobs()
    }
}
