package com.example.androidexercisesusj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ActivityD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)

        val txtResultSend = findViewById<EditText>(R.id.txt_result_send)
        val btnSend = findViewById<Button>(R.id.btn_send)

        btnSend.setOnClickListener {
            var result = txtResultSend.text.toString() //get text from editText
            val intent= Intent(this, ActivityB::class.java) //Intent to start activity
            intent.putExtra("Result", result)
            startActivity(intent)
        }
    }
}
