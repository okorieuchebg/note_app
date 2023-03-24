package com.udemylearn.noteappproject.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.udemylearn.noteappproject.MainActivity
import com.udemylearn.noteappproject.R
import com.udemylearn.noteappproject.databinding.FragmentNoteUpdateBinding
import com.udemylearn.noteappproject.model.Note
import com.udemylearn.noteappproject.viewmodel.NoteViewModel

class UpdateNoteFragment : Fragment(R.layout.fragment_note_update) {

    private var _binding: FragmentNoteUpdateBinding? = null
    private val binding get () = _binding!!

    private lateinit var notesViewModel: NoteViewModel

    private val args : UpdateNoteFragmentArgs by navArgs()

    private lateinit var currentNote : Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding =  FragmentNoteUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesViewModel = (activity as MainActivity).noteViewModel

        currentNote = args.note!!

        binding.etUpdateNoteTitle.setText(currentNote.noteTitle)

        binding.etUpdateNoteBody.setText(currentNote.noteBody)

        binding.fabUpdateNote.setOnClickListener {

            val noteTitle = binding.etUpdateNoteTitle.text.toString().trim()

            val noteBody = binding.etUpdateNoteBody.text.toString().trim()

            if (noteTitle.isNotEmpty() || noteBody.isNotEmpty()){

                val note = Note(currentNote.id, noteTitle, noteBody)

                notesViewModel.updateNote(note)

                Toast.makeText(it.context, "Note updated", Toast.LENGTH_SHORT).show()

                it.findNavController().navigate(R.id.action_updateNoteFragment_to_noteHomeFragment)

            }else {
                Toast.makeText(it.context, "Note title and body cannot be empty", Toast.LENGTH_SHORT).show()
            }




        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.note_update_menu, menu)
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

}