package com.udemylearn.noteappproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.udemylearn.noteappproject.MainActivity
import com.udemylearn.noteappproject.R
import com.udemylearn.noteappproject.databinding.FragmentNoteHomeBinding
import com.udemylearn.noteappproject.viewmodel.NoteViewModel

class NoteHomeFragment : Fragment(R.layout.fragment_note_home) {

    private var _binding : FragmentNoteHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var notesViewModel: NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNoteHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesViewModel = (activity as MainActivity).noteViewModel

        binding.fabNewNote.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_noteHomeFragment_to_newNoteFragment
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}