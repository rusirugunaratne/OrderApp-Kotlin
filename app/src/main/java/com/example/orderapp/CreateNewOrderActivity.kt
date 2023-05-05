package com.example.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CreateNewOrderActivity : AppCompatActivity() {
    private lateinit var etProjectName: EditText
    private lateinit var etProjectDescription: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_order)

        etProjectName = findViewById(R.id.add_project_name)
        etProjectDescription = findViewById(R.id.add_project_details)

        val type = intent.getStringExtra("type")

        if(type == "edit"){
            setValues()
        }

        val next = findViewById<Button>(R.id.btn_create_new_order_next)
        next.setOnClickListener{
            finish()
            val intent = Intent(this, CreateNewOrderSkillsActivity::class.java)
            intent.putExtra("name", etProjectName.text.toString())
            intent.putExtra("details", etProjectDescription.text.toString())
            intent.putExtra("type", type)
            startActivity(intent)
        }
    }

    private fun setValues() {
        
    }
}