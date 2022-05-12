package com.example.currencyapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HistoryDao {
    // Add an intersection entity to a table in the databases.
    // We use suspend to run the function asynchronously (coroutine).
    @Insert
    suspend fun insert(conversionHistory: History)

    // Update an intersection entity to a table in the databases. Often uses the primary key
    // We use suspend to run the function asynchronously (coroutine).
    @Update
    suspend fun update(conversionHistory: History)

    // Custom query for retrieving a single Intersection from a table in the databases using
    // its intersection id. We don't use suspend because LiveData objects are already designed
    // to work asynchronous.
    @Query("SELECT * from currencies_table WHERE currencyID = :key")
    fun get(key: Long): LiveData<History>?

    // Custom query for retrieving all Intersection entities from a table in the databases.
    // Data is stored to a List LiveData. We don't use suspend because LiveData objects
    // are already designed to work asynchronously.
    @Query("SELECT * from currencies_table ORDER BY currencyID DESC")
    fun getAllProfiles(): LiveData<List<History>>

    // Custom query for deleting all entities on a table in the databases
    // We use suspend to run the function asynchronously (coroutine).
    @Query("DELETE from currencies_table")
    suspend fun clear()
}