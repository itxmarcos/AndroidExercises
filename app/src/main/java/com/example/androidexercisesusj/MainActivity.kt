package com.example.androidexercisesusj

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_b.setOnClickListener {
            val intent= Intent(this, ActivityB::class.java)
            startActivity(intent)
        }

        btn_c.setOnClickListener {
            val intent= Intent(this, ActivityC::class.java)
            startActivity(intent)
        }
    }
}