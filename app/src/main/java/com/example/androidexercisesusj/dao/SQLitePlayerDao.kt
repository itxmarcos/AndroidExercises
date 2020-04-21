package com.example.androidexercisesusj.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.androidexercisesusj.database.SoccerDatabaseHelper
import com.example.androidexercisesusj.model.Player

class SQLitePlayerDao: IDao<Player> {
    var helper: SoccerDatabaseHelper?= null
    lateinit var db: SQLiteDatabase
    var TABLE = "Players"

    fun setContext(context: Context){
        helper = SoccerDatabaseHelper(context, "SockerDB", null, 2)
    }

    override fun insert(element: Player): Player {
        db = helper!!.writableDatabase
        val soccerPlayer = ContentValues()
        soccerPlayer.put("id", element.id)
        soccerPlayer.put("age", element.age)
        soccerPlayer.put("team", element.team)
        soccerPlayer.put("name", element.name)
        db.insert(TABLE, null, soccerPlayer)
        db.close()
        return findOne(element.id)!!
    }

    override fun delete(element: Player): Int {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Player> {
        TODO("Not yet implemented")
    }

    override fun findOne(id: String): Player? {
        TODO("Not yet implemented")
    }

    override fun update(element: Player): Int {
        TODO("Not yet implemented")
    }

}