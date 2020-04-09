package com.example.androidexercisesusj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityC : AppCompatActivity() {
    val txtID = findViewById<TextView>(R.id.txt_id)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        val intent=getIntent() //get intent object and data
        val id=intent.getStringExtra("ID")

        txtID.text="ID: "+id
    }
}
