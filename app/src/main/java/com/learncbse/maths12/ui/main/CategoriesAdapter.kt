package com.learncbse.maths12.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.learncbse.maths12.R
import com.learncbse.maths12.data.Category

/**
 * Created by Pedro Massango on 1/16/18.
 */
class CategoriesAdapter(val context: Context, val categories: ArrayList<Any>, val itemClick: ItemClick) : RecyclerView.Adapter<CategoriesAdapter.ItemVH>() {
    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = categories[position]
        holder.bindViews(item)
    }

    override fun getItemCount(): Int = categories.size

    override fun getItemViewType(position: Int): Int {
        return when (categories[position] is Category) {
            true -> R.layout.row_category
            false -> R.layout.row__category_title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        return ItemVH(LayoutInflater.from(context).inflate(viewType, parent, false))
    }

    interface ItemClick {
        fun itemClickListener(item: Any)
    }

    inner class ItemVH(view: View) : RecyclerView.ViewHolder(view) {

        fun bindViews(item: Any) {
            val tv = itemView.findViewById<TextView>(R.id.tv_title)
            val tvIcon = itemView.findViewById<ImageView>(R.id.tv_title_icon)
            tv.setOnClickListener { itemClick.itemClickListener(item) }
//            if(item is Category &&
//                    adapterPosition == DataSource.categories.size || adapterPosition == DataSource.categories.size-2){
//                when(adapterPosition == DataSource.categories.size-2){
//                    true -> {
//                        // send email clicked
//                    }
//                    false ->{
//                        // share clicked
//                        Toast.makeText(itemView.context, "Share with Friends", Toast.LENGTH_SHORT).show()
//                    }
//
//                }
//                return
//            }
            when ((item is Category)) {
                true -> {
                    tv.text = (item.title)
                    tvIcon.background = context.resources.getDrawable(item.itemsIcon)
                }
                false -> tv.text = (item).toString()
            }
        }
    }

}