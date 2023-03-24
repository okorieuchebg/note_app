package com.udemylearn.noteappproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.udemylearn.noteappproject.database.NoteDatabase
import com.udemylearn.noteappproject.databinding.ActivityMainBinding
import com.udemylearn.noteappproject.repository.NoteRepository
import com.udemylearn.noteappproject.viewmodel.NoteViewModel
import com.udemylearn.noteappproject.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()

    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))

        val viewModelFactory = NoteViewModelFactory(application, noteRepository)

        noteViewModel = ViewModelProvider(this, viewModelFactory).
        get(NoteViewModel::class.java)
    }
}