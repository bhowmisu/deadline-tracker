package com.tyche.deadlinetracker.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.tyche.deadlinetracker.data.PersonalDocumentEntity
import com.tyche.deadlinetracker.repo.RepoProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel constructor(application: Application): AndroidViewModel(application) {

//    private val personalDocumentRepo = PersonalDocumentRepo(application)

    private val applicationInstance = application

    private val _modelLiveData = RepoProvider.getPersonalDocumentRepo(application)?.getPersonalDocumentsFromCache()
    val modelLiveData: LiveData<List<PersonalDocumentEntity>>? = _modelLiveData

    fun addPersonalDocument(personalDocumentEntity: PersonalDocumentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            RepoProvider.getPersonalDocumentRepo(applicationInstance)?.addPersonalDocument(personalDocumentEntity)
        }
    }

}