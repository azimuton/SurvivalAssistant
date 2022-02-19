package com.example.survivalassistant.domain.usecase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.survivalassistant.R
import com.example.survivalassistant.data.storage.Note
import com.example.survivalassistant.presentation.NoteActivity
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter(val contextA: Context,
                  val noteList: List<Note>,
                  val callback: NoteActivity
): ListAdapter<Note, NoteAdapter.ViewHolder>(NoteDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(contextA).inflate(R.layout.note_item, parent, false), contextA
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.text = getItem(position).title
        holder.content?.text = getItem(position).content
        holder.deleteItem?.setOnClickListener {
            callback.deleteItem(position)
        }
    }

    class ViewHolder(itemView : View, contextV: Context)  : RecyclerView.ViewHolder(itemView) {
        val context = contextV
        var title: TextView? = null
        var content: TextView? = null
        var deleteItem : ImageView? = null


        init{
            title = itemView.tvNoteItemTitle
            content = itemView.tvNoteItemContent
            deleteItem = itemView.ivDeleteNoteItem
        }
        interface ItemCallback {
            fun deleteItem(index: Int)
        }
    }
}