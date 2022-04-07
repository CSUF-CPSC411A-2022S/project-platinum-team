package com.example.currencyapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies_table")
data class Currencies(

    @PrimaryKey(autoGenerate = true)
    var currencyID: Long = 0L,

    @ColumnInfo()
    var base: String = "",

    @ColumnInfo()
    var date: String = "",

    @ColumnInfo()
    var rates: () -> Unit = {}


)