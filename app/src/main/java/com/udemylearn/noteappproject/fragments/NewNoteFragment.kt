package com.udemylearn.noteappproject.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udemylearn.noteappproject.MainActivity
import com.udemylearn.noteappproject.R
import com.udemylearn.noteappproject.databinding.FragmentNewNoteBinding
import com.udemylearn.noteappproject.model.Note
import com.udemylearn.noteappproject.viewmodel.NoteViewModel

class NewNoteFragment : Fragment(R.layout.fragment_new_note) {

    private var _binding : FragmentNewNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var notesViewModel: NoteViewModel

    private lateinit var mView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesViewModel = (activity as MainActivity).noteViewModel

        mView = view

    }

    private fun saveNote(view : View){

        val noteTitle = binding.etNewNoteTitle.text.toString().trim()
        val noteBody = binding.etNewNoteBody.text.toString().trim()

        if (noteTitle.isNotEmpty() || noteBody.isNotEmpty()){

            val note = Note(0, noteTitle,noteBody)

            notesViewModel.addNote(note)

            Toast.makeText(view.context, "Note Saved", Toast.LENGTH_SHORT).show()

            view.findNavController().navigate(
                R.id.action_newNoteFragment_to_noteHomeFragment)

            }else{
                Toast.makeText(view.context,
                    "Note title and body cannot be empty",
                    Toast.LENGTH_SHORT).show()

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.menu_save -> saveNote(mView)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.new_note_menu, menu)
    }


    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}