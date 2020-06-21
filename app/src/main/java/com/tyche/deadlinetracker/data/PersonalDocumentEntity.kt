package com.tyche.deadlinetracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

open class ExpiringItem() {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id", typeAffinity = ColumnInfo.INTEGER)
    var mId: Long = 0
}

@Entity
class PersonalDocumentEntity constructor(name: String) : ExpiringItem() {
    @ColumnInfo(name = "name")
    var name: String = name
}