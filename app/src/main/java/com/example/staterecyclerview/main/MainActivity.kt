package com.example.staterecyclerview.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.staterecyclerview.data.Product
import com.example.staterecyclerview.adapter.ProductsAdapter
import com.example.staterecyclerview.R

class MainActivity : AppCompatActivity() {

    private lateinit var productsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productsRecyclerView = findViewById(R.id.products_recycler_view)

        setProductsRecyclerView(createProducts())
    }

    private fun setProductsRecyclerView(products: List<Product>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val adapter =
            ProductsAdapter(products)
        productsRecyclerView.layoutManager = layoutManager
        productsRecyclerView.adapter = adapter
    }

    private fun createProducts(): List<Product> {
        val products = ArrayList<Product>()
        products.add(Product("milk", 4.0))
        products.add(Product("water", 2.0))
        products.add(Product("eggs", 8.0))
        products.add(Product("ham", 12.0))
        products.add(Product("apple", 0.20))
        return products
    }
}
