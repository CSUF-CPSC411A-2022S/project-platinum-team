package com.example.currencyapplication.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GraphValue_table")
data class GraphValue (

    @PrimaryKey(autoGenerate = true)
    val Graph_id:Int

    )
