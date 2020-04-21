package com.example.androidexercisesusj.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.androidexercisesusj.database.SoccerDatabaseHelper
import com.example.androidexercisesusj.model.Player
import com.example.androidexercisesusj.model.Team

class SQLiteTeamDao: IDao<Team> {
    override fun insert(element: Team): Team {
        TODO("Not yet implemented")
    }

    override fun delete(element: Team): Int {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Team> {
        TODO("Not yet implemented")
    }

    override fun findOne(id: String): Team? {
        TODO("Not yet implemented")
    }

    override fun update(element: Team): Int {
        TODO("Not yet implemented")
    }

}