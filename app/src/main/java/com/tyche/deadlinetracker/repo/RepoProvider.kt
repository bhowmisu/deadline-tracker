package com.tyche.deadlinetracker.repo

import android.app.Application


//TODO: Delete this when Dagger is implemented
object RepoProvider {

    private var personalDocumentRepo: PersonalDocumentRepo? = null

    fun getPersonalDocumentRepo(application: Application): PersonalDocumentRepo? {
        if (personalDocumentRepo == null) {
            personalDocumentRepo = PersonalDocumentRepo(application)
        }

        return personalDocumentRepo
    }
}