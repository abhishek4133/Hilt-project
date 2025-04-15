package com.coredata.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.coredata.myapplication.listConverter.ListStringConverter


@Database(
    entities = [University::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    ListStringConverter::class
)

abstract class UniversityDatabase: RoomDatabase() {
    abstract fun universityDao(): UniversityDao

    companion object {
        const val DATABASE_NAME = "university_db"
        @Volatile
        private var INSTANCE: UniversityDatabase? = null

        fun getInstance(context: Context): UniversityDatabase? {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UniversityDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}