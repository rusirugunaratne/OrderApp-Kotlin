package com.example.orderapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class YourOrderActivity : AppCompatActivity() {
    private lateinit var etName: TextView
    private lateinit var etDescription: TextView
    private lateinit var etSkills: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_order)

        etName = findViewById(R.id.you_order_order_name)
        etDescription = findViewById(R.id.you_order_order_description)
        etSkills = findViewById(R.id.you_order_order_skills)

        val projectName = intent.getStringExtra("name")
        val projectDescription = intent.getStringExtra("details")
        val skill1 = intent.getStringExtra("skill1")
        val skill2 = intent.getStringExtra("skill2")
        val skill3 = intent.getStringExtra("skill3")

        etName.text = projectName
        etDescription.text = projectDescription
        etSkills.text = "$skill1, $skill2, $skill3"

        val delete = findViewById<Button>(R.id.btn_delete_order)
        delete.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val edit = findViewById<Button>(R.id.btn_edit_order)
        edit.setOnClickListener{
            val intent = Intent(this, CreateNewOrderActivity::class.java)
            intent.putExtra("type", "edit")
            startActivity(intent)
        }

        val post = findViewById<Button>(R.id.btn_post_order)
        edit.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addOrder(){

    }
}