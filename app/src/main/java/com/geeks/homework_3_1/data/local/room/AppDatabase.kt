package com.geeks.homework_3_1.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.geeks.homework_3_1.data.model.NoteModel

@Database(
    entities = [NoteModel::class],
    version = 2
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "my_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}
