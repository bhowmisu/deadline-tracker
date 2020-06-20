package com.tyche.deadlinetracker.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PersonalDocumentEntity::class), version = 1)
abstract class DeadlineDatabase : RoomDatabase() {
    abstract fun personalDocumentDao(): PersonalDocumentDao
}