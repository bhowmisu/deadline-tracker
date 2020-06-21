package com.tyche.deadlinetracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.*

open class ExpiringItem(expiryDate: Date) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id", typeAffinity = ColumnInfo.INTEGER)
    var mId: Long = 0
    @ColumnInfo(name = "expiry_date")
    open var expiryDate: Date = expiryDate
}

@Entity
class PersonalDocumentEntity constructor(
    name: String,
    expiryDate: Date
) : ExpiringItem(expiryDate) {
    @ColumnInfo(name = "name")
    var name: String = name
}

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}