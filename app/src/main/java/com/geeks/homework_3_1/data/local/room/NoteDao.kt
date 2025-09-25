package com.geeks.homework_3_1.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.geeks.homework_3_1.data.model.NoteModel

@Dao
interface NoteDao {
    @Insert
     fun insertItem(item : NoteModel)
    @Delete
     fun deleteItem(item: NoteModel)

    @Query("SELECT * FROM notes_list")
     fun getAllItems(): List<NoteModel>
}