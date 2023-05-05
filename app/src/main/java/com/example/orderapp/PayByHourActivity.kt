package com.example.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PayByHourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_by_hour)

        val projectName = intent.getStringExtra("name")
        val projectDescription = intent.getStringExtra("details")
        val skill1 = intent.getStringExtra("skill1")
        val skill2 = intent.getStringExtra("skill2")
        val skill3 = intent.getStringExtra("skill3")

        val next = findViewById<Button>(R.id.btn_pay_by_hour_next)
        next.setOnClickListener{
            val intent = Intent(this, YourOrderActivity::class.java)
            intent.putExtra("skill1", skill1)
            intent.putExtra("skill2", skill2)
            intent.putExtra("skill3", skill3)
            intent.putExtra("name", projectName)
            intent.putExtra("details", projectDescription)
            startActivity(intent)
        }
    }
}