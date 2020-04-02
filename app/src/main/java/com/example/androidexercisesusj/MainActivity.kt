package com.example.androidexercisesusj

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var count=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeNumber: Button = findViewById(R.id.btn_change_integer)
        btnChangeNumber.setOnClickListener {
            Toast.makeText(this, "Changing number", Toast.LENGTH_SHORT).show()
            count++
            val textView:TextView = findViewById(R.id.text_counter)
            textView.setText("It´s "+count)
        }
    }
}
