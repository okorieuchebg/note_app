package com.udemylearn.noteappproject.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udemylearn.noteappproject.R
import com.udemylearn.noteappproject.databinding.FragmentNoteUpdateBinding

class UpdateNoteFragment : Fragment(R.layout.fragment_note_update) {

    private var _binding: FragmentNoteUpdateBinding? = null
    private val binding = _binding!!

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

        binding.fabUpdateNote.setOnClickListener {
            it.findNavController().navigate(R.id.action_updateNoteFragment_to_noteHomeFragment)
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