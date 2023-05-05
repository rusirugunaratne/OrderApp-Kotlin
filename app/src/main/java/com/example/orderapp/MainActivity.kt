package com.example.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addOrder = findViewById<Button>(R.id.btn_add_order)
        addOrder.setOnClickListener{
            val intent = Intent(this, CreateOrderMainActivity::class.java)
            startActivity(intent)
        }
    }
}