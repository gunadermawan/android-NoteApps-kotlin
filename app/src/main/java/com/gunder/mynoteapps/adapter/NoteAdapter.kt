package com.gunder.mynoteapps.adapter

import android.provider.ContactsContract
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val onItemClickCallback: OnItemClickCallback) :
    RecyclerView.Adapter<NoteAdapter.NoteViewAdapter>() {
    var listNotes = ArrayList<ContactsContract.CommonDataKinds.Note>()
        set(listNotes) {
            if (listNotes.size > 0) {
                this.listNotes.clear()
            }
            this.listNotes.addAll(listNotes)
        }

    inner class NoteViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteViewAdapter {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewAdapter, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    interface OnItemClickCallback {
        fun onItemClicked(selectedNote: ContactsContract.CommonDataKinds.Note?, position: Int)
    }

    fun addItem(note: ContactsContract.CommonDataKinds.Note) {
        this.listNotes.add(note)
        notifyItemInserted(this.listNotes.size - 1)
    }

    fun updateItem(position: Int, note: ContactsContract.CommonDataKinds.Note) {
        this.listNotes[position] = note
        notifyItemChanged(position, note)
    }

    fun removeItem(position: Int) {
        this.listNotes.removeAt(position)
        notifyItemRemoved(position)
        notifyItemChanged(position, this.listNotes.size)
    }
}

