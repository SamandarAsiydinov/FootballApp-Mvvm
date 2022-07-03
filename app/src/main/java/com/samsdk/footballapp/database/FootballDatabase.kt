package com.samsdk.footballapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.samsdk.footballapp.model.Data

@Database(entities = [Data::class], version = 2, exportSchema = false)
abstract class FootballDatabase : RoomDatabase() {
    abstract fun dao(): FootballDao

    companion object {
        @Volatile
        private var instance: FootballDatabase? = null

        operator fun invoke(context: Context) = instance ?: synchronized(Any()) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context,
            FootballDatabase::class.java,
            "football.db"
        ).fallbackToDestructiveMigration().build()
    }
}