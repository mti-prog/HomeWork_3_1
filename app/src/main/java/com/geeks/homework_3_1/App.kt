package com.geeks.homework_3_1

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.geeks.homework_3_1.data.local.room.AppDataBase

class App : Application() {

    companion object{
        lateinit var db : AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        val migration1to2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE users ADD COLUMN age INTEGER NOT NULL DEFAULT 0")
            }
        }
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "notes_list").allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }
}