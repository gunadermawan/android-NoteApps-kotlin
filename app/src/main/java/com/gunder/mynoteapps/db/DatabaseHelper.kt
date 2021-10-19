package com.gunder.mynoteapps.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.gunder.mynoteapps.db.DatabaseContract.NoteColumns.Companion.TABLE_NAME
import com.gunder.mynoteapps.db.DatabaseContract.NoteColumns

internal class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABSE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "dbnoteapp"
        private const val DATABSE_VERSION = 1
        private const val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME" +
                "(${NoteColumns._ID}) INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${NoteColumns.TITLE} TEXT NOT NULL," +
                "${NoteColumns.DESCRIPTION} TEXT NOT NULL,"+
                "${NoteColumns.DATE} TEXT NOT NULL)"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}