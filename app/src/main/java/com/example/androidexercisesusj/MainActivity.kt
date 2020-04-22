package com.example.androidexercisesusj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidexercisesusj.dao.SQLitePlayerDao
import com.example.androidexercisesusj.model.Player

class MainActivity : AppCompatActivity() {
    val dao: SQLitePlayerDao by lazy { init() } //The first time I call dao, the init() method will be called (because it has lazy initialization).
    fun init(): SQLitePlayerDao {
        val dao = SQLitePlayerDao()
        dao.setContext(this)
        return dao
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player = dao.insert(Player("1", "Messi", "F.C. Barcelona", 32))
        Log.i("Player from DB: ", player.toString())
        Log.i("List from DB: ", dao.findAll().toString())
    }
}
