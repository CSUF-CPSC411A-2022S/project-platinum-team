package com.example.currencyapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "GraphValue_table")
data class GraphValue (

    @PrimaryKey(autoGenerate = true)
    val Graph_id:Long = 0L,

    // @ColumnInfo()
    // var date: Date = Date(),

    @ColumnInfo()
    var rub: Double = 0.0,

    @ColumnInfo()
    var yen: Double = 0.0,

    @ColumnInfo()
    var rup: Double = 0.0,

    )
