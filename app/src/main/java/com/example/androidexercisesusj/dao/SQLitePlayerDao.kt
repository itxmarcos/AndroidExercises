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
        return element
        //return findOne(element.id)!!
    }

    override fun delete(element: Player): Int {
        db = helper!!.writableDatabase
        val result = db.delete(TABLE, "id = ?", arrayOf(element.id))
        db.close()
        return result
    }

    override fun findAll(): List<Player> {
        db = helper!!.readableDatabase
        var players = mutableListOf<Player>()
        val cursor = db.rawQuery("SELECT id, name, team, age FROM $TABLE", arrayOf())
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(0)
                val name = cursor.getString(1)
                val team = cursor.getString(2)
                val age = cursor.getInt(3)
                val player = Player(id, name, team, age = age)
                players.add(player)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return players!!
    }

    override fun findOne(id: String): Player? {
        db = helper!!.readableDatabase
        var player: Player? = null
        val cursor = db.rawQuery("SELECT id, name, team, age FROM $TABLE WHERE id = ", arrayOf(id))
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(0)
                val name = cursor.getString(1)
                val team = cursor.getString(2)
                val age = cursor.getInt(3)
                player = Player(id, name, team, age = age)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return player!!
    }

    override fun update(element: Player): Int {
        db = helper!!.writableDatabase
        val soccerPlayer = ContentValues()
        soccerPlayer.put("age", element.age)
        soccerPlayer.put("team", element.team)
        soccerPlayer.put("name", element.name)
        val result = db.update(TABLE, soccerPlayer, "id = ?", arrayOf("" + element.id))
        db.close()
        return result
    }

}