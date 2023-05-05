package com.example.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    private lateinit var dbRef: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var orderList: ArrayList<OrderModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.order_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        orderList = arrayListOf<OrderModel>()

        getOrders()

        val addOrder = findViewById<Button>(R.id.btn_add_order)
        addOrder.setOnClickListener{
            val intent = Intent(this, CreateOrderMainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getOrders() {
        recyclerView.visibility = View.GONE
        dbRef = FirebaseDatabase.getInstance().getReference("Orders")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                orderList.clear()
                if(snapshot.exists()){
                    for(order in snapshot.children){
                        val orderData = order.getValue(OrderModel::class.java)
                        orderList.add(orderData!!)
                    }
                    val orderAdapter = OrderAdapter(orderList)
                    recyclerView.adapter = orderAdapter

                    recyclerView.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}