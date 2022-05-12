package com.example.currencyapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.currencyapplication.database.GraphValue
import com.example.currencyapplication.database.GraphValueDao


@Database(entities = [GraphValue::class], version = 1, exportSchema = false)
abstract class GraphValueDatabase : RoomDatabase(){

    abstract val graphValueDao: GraphValueDao
    companion object {
        // Holds a reference to the database.
        @Volatile
        private var INSTANCE: GraphValueDatabase? = null // This class

        // Retrieve an instance of the database tied to the context (your application).
        fun getInstance(context: Context): GraphValueDatabase {
            // Multiple threads can ask for the database at the same time, ensure we only initialize
            // it once by using synchronized. Only one thread may enter a synchronized block at a
            // time.
            synchronized(this) {

                // Copy the current value of INSTANCE to a local variable so Kotlin can smart cast.
                // Smart cast is only available to local variables.
                var instance = INSTANCE

                // The first time the method is called, instance will be `null`, so we should create
                // a new database instance. The next time it is called, the database instance
                // already exists and does not need to be recreated.
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GraphValueDatabase::class.java, // Your database class
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                // Return database instance; smart cast to be non-null.
                return instance
            }
        }
    }
}