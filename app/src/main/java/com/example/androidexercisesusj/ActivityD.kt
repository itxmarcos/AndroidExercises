package com.example.androidexercisesusj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

class ActivityD : AppCompatActivity() {
    val txtName = findViewById<TextView>(R.id.txt_name)
    val txtWeight=findViewById<TextView>(R.id.txt_weight)

    var weight1=0
    var weight2=0
    var weight3=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)

        val intent=getIntent() //get intent object and data
        val name=intent.getStringExtra("Name")
        txtName.text="Name: "+name //insert data into TextView

        txtWeight.text="Weight: "+(weight1+weight2+weight3)+"kg"
    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkBox1->
                    if (checked) {
                        weight1=1
                    }

                R.id.checkBox2 ->
                    if (checked) {
                        weight2=2
                    }

                R.id.checkBox3->
                    if(checked){
                        weight3
                    }
            }
        }
    }
}
