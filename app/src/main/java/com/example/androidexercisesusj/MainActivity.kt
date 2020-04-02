package com.example.androidexercisesusj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShowHiddenButton.setOnClickListener{
            tvHelloWorld.visibility = when(tvHelloWorld.visibility) {
                View.INVISIBLE -> View.VISIBLE
                View.VISIBLE -> View.INVISIBLE
                else -> View.VISIBLE
            }
        }
        btn2ndActivity.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        Log.v("CREATED: ", "${Date().time}")
    }
    override fun onStart(){
        super.onStart()
        Log.v("STARTED: ", "${Date().time}")
    }
    override fun onPause(){
        super.onPause()
        Log.v("PAUSED: ", "${Date().time}")
    }
    override fun onResume(){
        super.onResume()
        Log.v("RESUMED: ", "${Date().time}")
    }
    override fun onStop(){
        super.onStop()
        Log.v("STOPPED: ", "${Date().time}")
    }
    override fun onRestart(){
        super.onRestart()
        Log.v("RESTARTED: ", "${Date().time}")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.v("DESTROYED: ", "${Date().time}")
    }
}