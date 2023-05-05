package com.example.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText

class CreateNewOrderSkillsActivity : AppCompatActivity() {
    private lateinit var etSkill1: EditText
    private lateinit var etSkill2: EditText
    private lateinit var etSkill3: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_order_skills)

        val type = intent.getStringExtra("type")
        val projectName = intent.getStringExtra("name")
        val projectDescription = intent.getStringExtra("details")

        etSkill1 = findViewById(R.id.txt_add_skill1)
        etSkill2 = findViewById(R.id.txt_add_skill2)
        etSkill3 = findViewById(R.id.txt_add_skill3)

        if(type == "edit"){
            setValues()
        }

        val next = findViewById<Button>(R.id.btn_add_skill_next)
        next.setOnClickListener{
            finish()
            val intent = Intent(this, PayByHourActivity::class.java)
            intent.putExtra("skill1", etSkill1.text.toString())
            intent.putExtra("skill2", etSkill2.text.toString())
            intent.putExtra("skill3", etSkill3.text.toString())
            intent.putExtra("name", projectName)
            intent.putExtra("details", projectDescription)

            startActivity(intent)
        }
    }

    private fun setValues() {
        etSkill1.text = Editable.Factory.getInstance().newEditable(intent.getStringExtra("skill1"))
        etSkill2.text = Editable.Factory.getInstance().newEditable(intent.getStringExtra("skill2"))
        etSkill3.text = Editable.Factory.getInstance().newEditable(intent.getStringExtra("skill3"))
    }
}