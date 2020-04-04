package com.example.staterecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.staterecyclerview.R
import com.example.staterecyclerview.data.Item
import kotlinx.android.synthetic.main.row_item.view.*

class ItemsAdapter(
    private var items: List<Item>,
    private val onProductClick: (Item) -> Unit

) : RecyclerView.Adapter<ItemsAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(item: Item) {
            with(itemView) {
                titleView.text = item.title
            }
        }
    }

    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ProductViewHolder = ProductViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.row_item, parent, false
        )
    )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = items[position]
        holder.bindData(item)
    }

    override fun getItemCount(): Int = items.size
}