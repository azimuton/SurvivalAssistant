package com.example.survivalassistant.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.survivalassistant.R
import com.example.survivalassistant.data.storage.AppDatabase
import com.example.survivalassistant.data.storage.Note
import com.example.survivalassistant.domain.usecase.adapter.NoteAdapter
import com.example.survivalassistant.presentation.fragments.NoteFragment
import kotlinx.android.synthetic.main.activity_note.*
import kotlinx.android.synthetic.main.fragment_note.*

class NoteActivity : AppCompatActivity(), NoteAdapter.ViewHolder.ItemCallback {
    lateinit var adapter: NoteAdapter
    lateinit var noteDatabase: AppDatabase
    private lateinit var notesList: ArrayList<Note>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_note)

        notesList = ArrayList<Note>()
        noteDatabase = AppDatabase.getDatabase(this)
        getData()
        adapter = NoteAdapter(this, notesList, this)
        rvNote.layoutManager = LinearLayoutManager(this)
        rvNote.adapter = adapter
        adapter.submitList(notesList)

        fabNoteAddd.setOnClickListener {
            flNoteFragment.visibility = View.VISIBLE
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flNoteFragment, NoteFragment.newInstance("a", "aa"))
                .commit()
        }
    }

    fun getData() {
        val noteFromDb: List<Note> = noteDatabase.noteDao().getAll()
        notesList.clear()
        notesList.addAll(noteFromDb)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun deleteItem(index: Int) {
        val addDialog = AlertDialog.Builder(this)
        addDialog
            .setMessage("Вы действительно хотите удалить запись?")
            .setPositiveButton("Ok") { dialog, _ ->
                val note = notesList[index]
                noteDatabase.noteDao().deleteNote(note)
                getData()
                adapter.submitList(notesList)
                overridePendingTransition(0, 0);
                startActivity(intent);
                overridePendingTransition(0, 0);
                Toast.makeText(this, "Запись удалена!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Отмена") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
    override fun onResume() {
        super.onResume()
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
    }
}