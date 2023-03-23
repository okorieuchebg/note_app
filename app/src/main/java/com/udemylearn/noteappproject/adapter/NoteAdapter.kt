package com.udemylearn.noteappproject.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.udemylearn.noteappproject.databinding.NoteViewLayoutBinding
import com.udemylearn.noteappproject.fragments.NoteHomeFragmentDirections
import com.udemylearn.noteappproject.model.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(var itemBinding: NoteViewLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.noteBody == newItem.noteBody &&
                    oldItem.noteTitle == newItem.noteTitle
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteViewLayoutBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val currentList = differ.currentList[position]

        holder.itemBinding.tvLayoutNoteBody.text =
            currentList.noteBody

        holder.itemBinding.tvLayoutNoteTitle.text =
            currentList.noteTitle

        holder.itemView.setOnClickListener{
            val direction = NoteHomeFragmentDirections.actionNoteHomeFragmentToUpdateNoteFragment(currentList)
            it.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}