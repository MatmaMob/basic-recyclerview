package com.example.staterecyclerview.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.staterecyclerview.R
import com.example.staterecyclerview.adapter.ItemsAdapter
import com.example.staterecyclerview.data.Item
import com.example.staterecyclerview.utils.DateUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * Todo app
     * Reminds you to build list every day
     * Works only for current day
     * Productivity reason
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDateLayout()
        setItemsRecyclerView()
    }

    fun setDateLayout() {

        DateUtil.getCurrentDay().let {
            dayView.text = it
        }

        DateUtil.getDate().let {
            dateView.text = it
        }
    }

    fun setItemsRecyclerView() {
        val list = ArrayList<Item>()
        list.add(Item("Buy Marmelad Candies", "", ""))
        list.add(Item("Meet With David", "", ""))
        list.add(Item("Finish The Landing Page", "", ""))
        list.add(Item("Video Conference", "", ""))
        list.add(Item("Design New Logo", "", ""))

        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(getDrawable(R.drawable.divider)!!)

        val adapter = ItemsAdapter(list) {}
        itemsRecyclerView.layoutManager = LinearLayoutManager(this)
        itemsRecyclerView.addItemDecoration(divider)
        itemsRecyclerView.adapter = adapter
    }
}
