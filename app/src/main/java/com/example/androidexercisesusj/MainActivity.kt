package com.example.androidexercisesusj

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kotlin.run {
            // Write a message to the database
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("player")
            myRef.setValue(Player("1", "Cristiano Ronaldo"))
        }
        read()
    }

    //Read from the database
    fun read() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("player")

        // This method is called once with the initial value and again whenever data at this location is updated.
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(Player::class.java)
                Log.d("VAL: ", "Value is: $value")
            }

            //Failed to read value
            override fun onCancelled(error: DatabaseError) {
                Log.w("VAL: ", "Failed to read value.", error.toException())
            }
        })
    }
}

data class Player(val id: String, val name: String): Serializable {
    constructor(): this("", "") //It needs a constructor to be able to parse.

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Player

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}
