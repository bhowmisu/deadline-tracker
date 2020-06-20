package com.tyche.deadlinetracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonalDocumentEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String
)