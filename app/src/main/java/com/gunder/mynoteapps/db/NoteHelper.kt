package com.gunder.mynoteapps.db

import android.content.ContentValues
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

    //    mengambil data dg id ttntu
    fun queryById(id: String): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            "$_ID = ?",
            arrayOf(id),
            null,
            null,
            null,
            null
        )
    }

    //    unutk menyimpan data
    fun insert(values: ContentValues): Long {
        return database.insert(DATABASE_TABLE, null, values)
    }

    //    untuk update data
    fun update(id: String, values: ContentValues): Int {
        return database.update(DATABASE_TABLE, values, "$_ID = ?", arrayOf(id))
    }
//    delete data
    fun delete(id: String): Int{
        return database.delete(DATABASE_TABLE, "$_ID = '$id'", null)
    }
}