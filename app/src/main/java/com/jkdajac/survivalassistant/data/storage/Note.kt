package com.jkdajac.survivalassistant.data.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
class Note(
    val title: String,
    val content: String
)

{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}