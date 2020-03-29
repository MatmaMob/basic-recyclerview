package com.example.staterecyclerview.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.staterecyclerview.data.Product
import com.example.staterecyclerview.adapter.ProductsAdapter
import com.example.staterecyclerview.R

class MainActivity : AppCompatActivity(), ProductsAdapter.OnProductClickListener {

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
            ProductsAdapter(products, this)
        productsRecyclerView.layoutManager = layoutManager
        productsRecyclerView.adapter = adapter
    }

    private fun createProducts(): List<Product> {
        val products = ArrayList<Product>()
        for (i in 1..20) {
            products.add(Product("$i: milk", 4.0))
        }
        return products
    }

    override fun onProductClick(product: Product) {
        // do whatever you want here
    }
}
