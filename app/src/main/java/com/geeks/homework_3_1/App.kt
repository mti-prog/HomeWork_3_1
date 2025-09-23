package com.geeks.homework_3_1

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.geeks.homework_3_1.data.local.room.AppDataBase

class App : Application() {

    companion object{
        lateinit var db : AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "notes_list").allowMainThreadQueries().build()
    }
}