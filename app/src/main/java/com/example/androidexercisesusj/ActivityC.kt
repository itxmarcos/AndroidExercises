package com.example.androidexercisesusj

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.android.synthetic.main.activity_b.btn_a
import kotlinx.android.synthetic.main.activity_c.*

class ActivityC : AppCompatActivity() {
    val phoneNumber = "123456"
    val REQUEST_PHONE_CALL=1
    val emailAddress = "tulipano@gmail.org"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        btn_a.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_call.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)
            } else {
                startCall()
            }
        }

        btn_mail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/html"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(emailAddress))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Email subject")
            intent.putExtra(Intent.EXTRA_TEXT, "The email body")
            startActivity(intent)
        }
    }

    @SuppressLint("MissingPermission")
    private fun startCall() {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.setData(Uri.parse("tel:" + phoneNumber))
        startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == REQUEST_PHONE_CALL) startCall()
    }
}
