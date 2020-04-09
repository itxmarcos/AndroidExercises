package com.example.androidexercisesusj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityD : AppCompatActivity() {
    val txtName = findViewById<TextView>(R.id.txt_name)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)

        val intent=getIntent() //get intent object and data
        val name=intent.getStringExtra("Name")
        txtName.text="Name: "+name //insert data into TextView


    }
}
