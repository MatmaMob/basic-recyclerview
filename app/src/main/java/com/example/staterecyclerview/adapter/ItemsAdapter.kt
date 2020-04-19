package com.example.staterecyclerview.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.staterecyclerview.R
import com.example.staterecyclerview.data.Item
import kotlinx.android.synthetic.main.row_item.view.*

class ItemsAdapter(
    private var items: List<Item>,
    private val context: Context,
    private val onProductClick: (Item) -> Unit
) : RecyclerView.Adapter<ItemsAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(item: Item, position: Int) {
            with(itemView) {
                if (item.isDone) setDoneUI(titleView)

                titleView.text = item.title
                setOnClickListener {
                    onProductClick(item)
                    notifyItemChanged(position)
                }
            }
        }

        fun setDoneUI(view: TextView) {
            view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            view.setTextColor(context.resources.getColor(R.color.color_done_item_title_transparent))
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
        holder.bindData(item, position)
    }

    override fun getItemCount(): Int = items.size
}