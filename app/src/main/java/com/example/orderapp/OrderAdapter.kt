package com.example.orderapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter (private var orderList: ArrayList<OrderModel>): RecyclerView.Adapter<OrderAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = orderList[position]
        holder.name.text = currentItem.name
        holder.skills.text = currentItem.skills
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    fun updateList(list: List<OrderModel>) {
        orderList = list as ArrayList<OrderModel>
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.item_order_name)
        val skills: TextView = itemView.findViewById(R.id.item_skills_list)
    }
}
