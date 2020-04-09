package com.example.androidexercisesusj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class ActivityB : AppCompatActivity() {
    lateinit var txt1: EditText
    lateinit var txt2: EditText
    lateinit var btnInitOperation: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        txt1=findViewById(R.id.txt_1)
        txt2=findViewById(R.id.txt_2)
        btnInitOperation=findViewById(R.id.btn_init_operation)
    }

    fun ButtonClicked(view: View) {
        if (view is RadioButton) {
            //Variable to save 1º EditText data
            val data=txt1.text.toString()
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rbtn_company ->
                    if (checked) {
                        txt1.hint="Company ID"
                        txt2.hint="Country (Spinner)"
                        btnInitOperation.setOnClickListener {
                            val intent= Intent(this, ActivityC::class.java)
                            intent.putExtra("ID", data)
                            startActivity(intent)
                        }
                    }
                R.id.rbtn_citizen ->
                    if (checked) {
                        txt1.hint="Name"
                        txt2.hint="Surname"
                        btnInitOperation.setOnClickListener {
                            val intent= Intent(this, ActivityD::class.java)
                            intent.putExtra("Name", data)
                            startActivity(intent)
                        }
                    }
            }
        }
    }
}
