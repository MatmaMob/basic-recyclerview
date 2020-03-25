package com.example.staterecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.staterecyclerview.data.Product
import com.example.staterecyclerview.R

class ProductsAdapter(private var products: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameView: TextView = view.findViewById(R.id.name)
        private val priceView: TextView = view.findViewById(R.id.price)

        fun bindData(product: Product) {
            nameView.text = product.name
            priceView.text = product.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ProductViewHolder = ProductViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.row_product, parent, false
        )
    )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bindData(product)
    }

    override fun getItemCount(): Int = products.size
}