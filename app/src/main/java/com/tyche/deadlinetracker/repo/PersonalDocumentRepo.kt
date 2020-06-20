package com.tyche.deadlinetracker.repo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.tyche.deadlinetracker.data.DeadlineDatabase
import com.tyche.deadlinetracker.data.PersonalDocumentEntity

class PersonalDocumentRepo constructor(application: Application) {
    private var deadlineDatabase: DeadlineDatabase =
        Room.databaseBuilder(application.applicationContext, DeadlineDatabase::class.java, "deadline").build()

    fun getPersonalDocumentsFromCache(): LiveData<List<PersonalDocumentEntity>> {
        return deadlineDatabase.personalDocumentDao().getAllPersonalDocumentEntity()
    }

    suspend fun addPersonalDocument(personalDocumentEntity: PersonalDocumentEntity) {
        deadlineDatabase.personalDocumentDao().addPersonalDocumentEntity(personalDocumentEntity)
    }


}