package com.udemylearn.noteappproject.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.udemylearn.noteappproject.model.Note

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note : Note)

    @Update
    suspend fun updateNote(note :Note)

    @Delete
    suspend fun deleteNote(note :Note)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes() : LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE noteBody LIKE :query or noteTitle LIKE :query ORDER BY id DESC")
    fun searchNote(query:String?) : LiveData<List<Note>>
}