package com.gunder.mynoteapps.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.gunder.mynoteapps.db.DatabaseContract.NoteColumns.Companion.TABLE_NAME
import com.gunder.mynoteapps.db.DatabaseContract.NoteColumns.Companion._ID
import java.sql.SQLException


class NoteHelper(context: Context) {
    //    constructor class
    private var databaseHelper: DatabaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase

    companion object {
        private const val DATABASE_TABLE = TABLE_NAME
    }

    //    instance database
    private var INSTANCE: NoteHelper? = null
    fun getInstance(context: Context): NoteHelper =
        INSTANCE ?: synchronized(this) {
            INSTANCE ?: NoteHelper(context)
        }

    //    untuk controller databse(open/close database)
    @Throws(SQLException::class)
    fun open() {
        database = databaseHelper.writableDatabase
    }

    fun close() {
        database.close()
    }

    //    Method CRUD
//    get data
    fun queryAll(): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            null,
            null,
            null,
            null,
            "$_ID ASC"
        )
    }
}