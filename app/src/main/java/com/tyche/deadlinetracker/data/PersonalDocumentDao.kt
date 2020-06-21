package com.tyche.deadlinetracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonalDocumentDao {
    @Query("SELECT * from personaldocumententity order by expiry_date asc")
    fun getAllPersonalDocumentEntity(): LiveData<List<PersonalDocumentEntity>>

    @Insert
    suspend fun addPersonalDocumentEntity(documentEntity: PersonalDocumentEntity)


}
