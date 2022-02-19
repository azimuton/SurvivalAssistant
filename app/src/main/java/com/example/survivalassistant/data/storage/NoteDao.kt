package com.example.survivalassistant.data.storage

import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

//    @Transaction
//    @Query("INSERT INTO learnedwords SELECT * FROM word")
//    fun copy()

    @Query("DELETE FROM note")
    fun deleteAll()

    @Insert
    fun insertNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query(" SELECT * FROM Note WHERE id = :id")
    fun getNoteById(id: Int): Note?

}
