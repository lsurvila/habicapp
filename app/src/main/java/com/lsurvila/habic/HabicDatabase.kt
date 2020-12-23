package com.lsurvila.habic

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoItemEntity::class], version = 1, exportSchema = false)
abstract class HabicDatabase : RoomDatabase() {

    abstract fun todoItemDao(): TodoItemDao

    companion object {

        @Volatile
        private var INSTANCE: HabicDatabase? = null

        fun getDatabase(context: Context): HabicDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HabicDatabase::class.java,
                    "habic_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
