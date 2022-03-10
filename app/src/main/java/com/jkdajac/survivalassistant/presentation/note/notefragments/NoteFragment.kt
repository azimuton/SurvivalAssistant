package com.jkdajac.survivalassistant.presentation.note.notefragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jkdajac.survivalassistant.R
import com.jkdajac.survivalassistant.data.storage.AppDatabase
import com.jkdajac.survivalassistant.data.storage.Note
import com.jkdajac.survivalassistant.presentation.note.NoteActivity
import kotlinx.android.synthetic.main.fragment_note.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoteFragment : Fragment() {
    lateinit var noteDatabase: AppDatabase
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        noteDatabase = context?.let { AppDatabase.getDatabase(it as NoteActivity) }!!

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.btSaveNote?.setOnClickListener {
            if (etTitle.text.isNotEmpty() && etContent.text.isNotEmpty()) {
                val title: String = etTitle.text.toString()
                val content : String = etContent.text.toString()
                val note = Note(title = title, content = content)
                Toast.makeText(context,"Успешно сохранено!", Toast.LENGTH_SHORT).show()
                noteDatabase.noteDao().insertNote(note)
                val intent = Intent(activity?.applicationContext, NoteActivity::class.java)
                startActivity(intent)
                activity?.finish()
            } else {
                Toast.makeText(context,"Заполните поля!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NoteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NoteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}