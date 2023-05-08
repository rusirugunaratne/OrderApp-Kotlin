package com.example.orderapp

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase

class OrderAdapter (private var orderList: ArrayList<OrderModel>): RecyclerView.Adapter<OrderAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = orderList[position]
        holder.name.text = currentItem.name
        holder.skills.text = currentItem.skills
        holder.deleteBtn.setOnClickListener {v ->
            currentItem.orderId?.let { it1 -> deleteItem(it1, v) }
        }
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    private fun deleteItem(orderId: String, v: View){
        val builder = AlertDialog.Builder(v.context)
        builder.setMessage("Are you sure you want to delete this item?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, id ->
                val dbRef = FirebaseDatabase.getInstance().getReference("Orders").child(orderId)
                val mTask = dbRef.removeValue()
            }
            .setNegativeButton("No") { dialog, id ->
                Toast.makeText(v.context, "Not Deleted", Toast.LENGTH_LONG).show()
            }
        val alert = builder.create()
        alert.show()
    }

    fun updateList(list: List<OrderModel>) {
        orderList = list as ArrayList<OrderModel>
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.item_order_name)
        val skills: TextView = itemView.findViewById(R.id.item_skills_list)
        val deleteBtn: Button = itemView.findViewById(R.id.btn_delete_order_item)
    }
}
