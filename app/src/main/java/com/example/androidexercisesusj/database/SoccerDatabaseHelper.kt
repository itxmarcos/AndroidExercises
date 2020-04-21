package com.example.androidexercisesusj.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Class for SQLite database management
class SoccerDatabaseHelper(context: Context?, database: String?, cursorFactory: SQLiteDatabase.CursorFactory?, version: Int): SQLiteOpenHelper(context, database, cursorFactory, version) {
    companion object {
        private const val CREATE_TABLE = "CREATE TABLE Players (id TEXT, name TEXT, team TEXT, age INTEGER)"
        private const val DROP_TABLE = "DROP TABLE IF EXISTS Players"
    }

    //Database creation method
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(CREATE_TABLE)
    }

    //Update schema for an existing database
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(DROP_TABLE)
        db!!.execSQL(CREATE_TABLE)
    }
}