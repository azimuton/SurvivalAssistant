package com.jkdajac.survivalassistant.presentation.note

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.jkdajac.survivalassistant.data.storage.Note

class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return  oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
       return oldItem == newItem
    }
}