package com.gunder.mynoteapps.dbHelper

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entity(
    var id: Int = 0,
    var title: String? = null,
    var description: String? = null,
    var date: String? = null
) : Parcelable