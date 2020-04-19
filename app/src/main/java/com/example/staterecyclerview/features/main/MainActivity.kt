package com.example.staterecyclerview.features.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
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
    private lateinit var doneAdapter: ItemsAdapter
    private lateinit var adapter: ItemsAdapter

    private var doneCount = 0
    private lateinit var moveUpAnimation: Animation
    private lateinit var moveDownAnimation: Animation
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

        mainViewModel.getDoneTasks().observe(this, Observer {
            doneCount = it.size
            setDoneList(it)
        })
    }

    private fun setDoneDropdown() {
        doneTasksView.setOnClickListener {
            if (doneItemsRecyclerView.visibility == VISIBLE) {
                doneItemsRecyclerView.startAnimation(moveUpAnimation)
                doneItemsRecyclerView.visibility = GONE
            } else {
                doneItemsRecyclerView.visibility = VISIBLE
                doneItemsRecyclerView.startAnimation(moveDownAnimation)
            }
        }
    }

    private fun setUI() {

        moveUpAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_move_up)
        moveDownAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_move_down)

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

    private fun setDoneTitle(count: Int) {
        doneTasksView.text = "${resources.getString(R.string.done_task_title)} ($count)"
        setDoneDropdown()
    }
    private fun setDateLayout() {

        DateUtil.getCurrentDay().let {
            dayView.text = it
        }

        DateUtil.getDate().let {
            dateView.text = it
        }
    }

    private fun setDoneList(doneList: List<Item>) {
        setDoneTitle(doneCount)
        doneAdapter = ItemsAdapter(doneList, this) {

        }

        doneItemsRecyclerView.layoutManager = LinearLayoutManager(this)
        doneItemsRecyclerView.adapter = doneAdapter
    }

    private fun setItemsRecyclerView(list: List<Item>) {
        adapter = ItemsAdapter(list, this) {
            it.isDone = true
            doneCount++
            setDoneTitle(doneCount)
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
