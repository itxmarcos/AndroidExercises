package com.example.androidexercisesusj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        btn_a.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_d.setOnClickListener {
            val intent= Intent(this, ActivityD::class.java)
            startActivity(intent)
        }

        //get data from intent in Activity D
        var intent = intent
        val result = intent.getStringExtra("Result")
        val txtResultReceive = findViewById<TextView>(R.id.txt_result_receive) //textView
        txtResultReceive.text=result //setText
    }

}
