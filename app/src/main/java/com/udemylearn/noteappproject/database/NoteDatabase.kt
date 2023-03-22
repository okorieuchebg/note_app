package com.udemylearn.noteappproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udemylearn.noteappproject.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase :RoomDatabase() {

    abstract fun getNoteDao() : NoteDAO

    companion object{
        @Volatile
        private var instance : NoteDatabase? = null
        private var lock = Any()

        operator fun invoke(context :Context) = instance?: synchronized(lock){
            instance?: createDatabase(context).apply {
                instance = this
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                NoteDatabase::class.java,
                "note_db").build()

    }
}