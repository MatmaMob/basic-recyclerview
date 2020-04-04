package com.example.staterecyclerview.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.staterecyclerview.data.Product
import com.example.staterecyclerview.adapter.ProductsAdapter
import com.example.staterecyclerview.R
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

        Log.d("tomek", "Today is: " + DateUtil.getCurrentDay())
        Log.d("tomek", "Today is: " + DateUtil.getDate())
    }

}
