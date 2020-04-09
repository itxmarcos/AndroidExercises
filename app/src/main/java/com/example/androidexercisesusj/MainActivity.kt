package com.example.androidexercisesusj

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var login: Button

    var textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            TODO("Not yet implemented")
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            login.setEnabled(!username.getText().toString().trim().isEmpty() && !password.getText().toString().trim().isEmpty())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username=findViewById(R.id.txt_username)
        password=findViewById(R.id.txt_password)
        login=findViewById(R.id.btn_login)

        //This keeps my app crashing all the time and I don´t know why
        //username.addTextChangedListener(textWatcher)
        //password.addTextChangedListener(textWatcher)

        login.setOnClickListener {
            val toast = Toast.makeText(this, "Logged as "+username.getText().toString(), Toast.LENGTH_LONG); toast.show()
            val intent = Intent(this, ActivityB::class.java); startActivity(intent)
        }
    }
}
