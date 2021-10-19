package com.gunder.mynoteapps.db

import android.provider.BaseColumns

internal class DatabaseContract : BaseColumns {
    companion object {
        const val TABLE_NAME = "note"
        const val _ID = "_id"
        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val DATE = "date"
    }
}