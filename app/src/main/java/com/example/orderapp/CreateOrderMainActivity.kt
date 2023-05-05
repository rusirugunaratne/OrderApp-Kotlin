package com.example.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CreateOrderMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_order_main)

        val next = findViewById<Button>(R.id.btn_create_order_main_next)
        next.setOnClickListener{
            val intent = Intent(this, CreateNewOrderActivity::class.java)
            intent.putExtra("type", "create")
            startActivity(intent)
        }
    }
}