package com.udemylearn.noteappproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udemylearn.noteappproject.R
import com.udemylearn.noteappproject.databinding.FragmentNewNoteBinding

class UpdateNoteFragment : Fragment() {

    private lateinit var binding: FragmentNewNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_update, container, false)
    }

}