package com.example.staterecyclerview.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.staterecyclerview.Constants
import com.example.staterecyclerview.data.Item

@Database(entities = arrayOf(Item::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDAO(): ItemDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE
            ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(
                        context
                    ).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            Constants.DATABASE_NAME
        )
            .fallbackToDestructiveMigration().build()
    }
}