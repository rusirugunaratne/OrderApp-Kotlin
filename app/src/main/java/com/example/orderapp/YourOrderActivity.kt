package com.example.orderapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class YourOrderActivity : AppCompatActivity() {
    private lateinit var dbRef: DatabaseReference
    private lateinit var etName: TextView
    private lateinit var etDescription: TextView
    private lateinit var etSkills: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_order)

        dbRef = FirebaseDatabase.getInstance().getReference("Orders")

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
            intent.putExtra("skill1", skill1)
            intent.putExtra("skill2", skill2)
            intent.putExtra("skill3", skill3)
            intent.putExtra("name", projectName)
            intent.putExtra("details", projectDescription)
            startActivity(intent)
        }

        val post = findViewById<Button>(R.id.btn_post_order)
        post.setOnClickListener{
            finish()
            addOrder()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addOrder(){
        val projectName = intent.getStringExtra("name")
        val projectDescription = intent.getStringExtra("details")
        val skill1 = intent.getStringExtra("skill1")
        val skill2 = intent.getStringExtra("skill2")
        val skill3 = intent.getStringExtra("skill3")

        val orderId = dbRef.push().key!!
        val order = OrderModel(orderId, projectName, projectDescription, "$skill1, $skill2, $skill3")
        dbRef.child(orderId).setValue(order).addOnCompleteListener{
            Toast.makeText(this, "Order Added Successfully", Toast.LENGTH_LONG).show()
        }.addOnFailureListener { err->
            Toast.makeText(this, "Error ${err.message} ", Toast.LENGTH_LONG).show()
        }
    }
}