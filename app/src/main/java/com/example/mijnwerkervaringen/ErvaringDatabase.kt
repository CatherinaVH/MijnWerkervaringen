package com.example.mijnwerkervaringen

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Ervaring::class], version = 1, exportSchema = false)
abstract class ErvaringDatabase : RoomDatabase() {
    abstract val ervaringDatabaseDao: ErvaringDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: ErvaringDatabase? = null

        fun getInstance(context: Context): ErvaringDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ErvaringDatabase::class.java,
                        "ervaring_history_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}