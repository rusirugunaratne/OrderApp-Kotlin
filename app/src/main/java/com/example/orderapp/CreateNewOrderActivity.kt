package com.example.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText

class CreateNewOrderActivity : AppCompatActivity() {
    private lateinit var etProjectName: EditText
    private lateinit var etProjectDescription: EditText
    private lateinit var skill1: String
    private lateinit var skill2: String
    private lateinit var skill3: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_order)


        etProjectName = findViewById(R.id.add_project_name)
        etProjectDescription = findViewById(R.id.add_project_details)

        val type = intent.getStringExtra("type")

        skill1 = ""
        skill2 = ""
        skill3 = ""

        if(type == "edit"){
            setValues()
        }

        val next = findViewById<Button>(R.id.btn_create_new_order_next)
        next.setOnClickListener{
            finish()
            val intent = Intent(this, CreateNewOrderSkillsActivity::class.java)
            intent.putExtra("name", etProjectName.text.toString())
            intent.putExtra("details", etProjectDescription.text.toString())
            intent.putExtra("skill1", skill1)
            intent.putExtra("skill2", skill2)
            intent.putExtra("skill3", skill3)
            intent.putExtra("type", type)
            startActivity(intent)
        }
    }

    private fun setValues() {
        etProjectName.text = Editable.Factory.getInstance().newEditable(intent.getStringExtra("name"))
        etProjectDescription.text = Editable.Factory.getInstance().newEditable(intent.getStringExtra("details"))
        skill1 = intent.getStringExtra("skill1").toString()
        skill2 = intent.getStringExtra("skill2").toString()
        skill3 = intent.getStringExtra("skill3").toString()
    }
}