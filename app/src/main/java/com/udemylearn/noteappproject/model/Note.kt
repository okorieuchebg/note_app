package com.udemylearn.noteappproject.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey
    var id :Int,
    var noteTitle :String,
    var noteBody :String
) :Parcelable
