package com.example.staterecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.staterecyclerview.R
import com.example.staterecyclerview.data.Product
import kotlinx.android.synthetic.main.row_product.view.*

class ProductsAdapter(
    private var products: List<Product>,
    private val onProductClick: (Product) -> Unit

) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(product: Product) {
            with(itemView) {
                nameView.text = product.name
                priceView.text = product.price.toString()

                setOnClickListener {
                    onProductClick(product)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int = position

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