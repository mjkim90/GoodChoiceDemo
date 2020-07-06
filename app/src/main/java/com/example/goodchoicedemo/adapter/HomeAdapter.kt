package com.example.goodchoicedemo.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.goodchoicedemo.DetailActivity
import com.example.goodchoicedemo.R
import com.example.goodchoicedemo.model.MainListResponse
import com.example.goodchoicedemo.model.ResProductListModel
import com.example.goodchoicedemo.util.ImageUtil
import com.example.goodchoicedemo.util.RecyclerViewHolder
import com.example.goodchoicedemo.util.WLog
import kotlinx.android.synthetic.main.list_item_main.view.*

class HomeAdapter(private val activity: Activity) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private val items = ArrayList<ResProductListModel>()

    fun putItems(items: ArrayList<ResProductListModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearAdapter() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.itemView.run {
            items[holder.bindingAdapterPosition].run model@{
                txt_name.text = data.productList[position].name
                rating.rating = data.productList[position].rate
                ImageUtil.loadImage(activity, data.productList[position].thumbnail, img_thumbnail)

                setOnClickListener {
                    DetailActivity.startActivity(
                        activity,
                        data.productList[position].name,
                        data.productList[position].rate,
                        data.productList[position].thumbnail
                    )
                }
            }
        }
    }
}