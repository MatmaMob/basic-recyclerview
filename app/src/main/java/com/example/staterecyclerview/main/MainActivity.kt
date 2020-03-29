package com.example.staterecyclerview.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.staterecyclerview.data.Product
import com.example.staterecyclerview.adapter.ProductsAdapter
import com.example.staterecyclerview.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setProductsRecyclerView(createProducts())
    }

    private fun setProductsRecyclerView(products: List<Product>) {
        productsRecyclerView.layoutManager = LinearLayoutManager(this)
        productsRecyclerView.adapter = ProductsAdapter(products) {
            Toast.makeText(this, "Product ${it.name}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createProducts(): List<Product> {
        val products = ArrayList<Product>()
        for (i in 1..20) {
            products.add(Product("$i: milk", 4.0))
        }
        return products
    }
}
