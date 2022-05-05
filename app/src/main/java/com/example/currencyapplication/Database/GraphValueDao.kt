package com.example.currencyapplication.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GraphValueDao {

    @Insert
    suspend fun insert(graphValue:GraphValue)

    @Update
    suspend fun update(graphValue: GraphValue)

    @Query("SELECT * from GraphValue_table WHERE Graph_id = :key")
    fun get(key: Long): LiveData<GraphValue>?

    @Query("SELECT * from GraphValue_table ORDER BY Graph_id DESC")
    fun getAllProfiles(): LiveData<List<GraphValue>>

    // Custom query for deleting all entities on a table in the database
    // We use suspend to run the function asynchronously (coroutine).
    @Query("DELETE from GraphValue_table")
    suspend fun clear()

}