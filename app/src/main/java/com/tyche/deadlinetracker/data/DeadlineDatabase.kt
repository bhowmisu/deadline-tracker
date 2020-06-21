package com.tyche.deadlinetracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [PersonalDocumentEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class DeadlineDatabase : RoomDatabase() {
    abstract fun personalDocumentDao(): PersonalDocumentDao
}