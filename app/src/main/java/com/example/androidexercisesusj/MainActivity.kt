package com.example.androidexercisesusj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexercisesusj.dao.SQLitePlayerDao
import com.example.androidexercisesusj.model.Player

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SQLitePlayerDao()
        dao.setContext(this)
        dao.insert(Player("1", "Messi", "F.C. Barcelona", 32))
    }
}
