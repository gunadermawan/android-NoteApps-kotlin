package com.gunder.mynoteapps.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.gunder.mynoteapps.db.DatabaseContract.NoteColumns.Companion.TABLE_NAME


class NoteHelper(context: Context) {
    private var databaseHelper: DatabaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase
    companion object{
        private const val DATABASE_TABLE = TABLE_NAME
    }
}