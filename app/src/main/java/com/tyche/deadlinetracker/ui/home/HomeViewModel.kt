package com.tyche.deadlinetracker.ui.home

import android.app.Application
import android.security.identity.PersonalizationData
import androidx.lifecycle.*
import androidx.room.Room
import com.tyche.deadlinetracker.data.DeadlineDatabase
import com.tyche.deadlinetracker.data.PersonalDocumentEntity
import com.tyche.deadlinetracker.data.PersonalDocumentEntityMapper
import com.tyche.deadlinetracker.data.PersonalDocumentModelMapper
import com.tyche.deadlinetracker.repo.PersonalDocumentRepo
import com.tyche.deadlinetracker.repo.RepoProvider
import com.tyche.deadlinetracker.ui.model.PersonalDocumentModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel constructor(application: Application): AndroidViewModel(application) {

//    private val _modelLiveData = MutableLiveData<List<PersonalDocumentModel>>().apply {
//        value = listOf(
//            PersonalDocumentModel("Drivers License"),
//            PersonalDocumentModel("I-797"),
//            PersonalDocumentModel("I-20"),
//            PersonalDocumentModel("Passport")
//        )
//    }

//    private val personalDocumentRepo = PersonalDocumentRepo(application)

    private val applicationInstance = application

    private val _modelLiveData =
        RepoProvider.getPersonalDocumentRepo(application)?.getPersonalDocumentsFromCache()?.let {
            Transformations.map(it) {entities ->
                entities.map {entity->
                PersonalDocumentModel(entity.id, entity.name)
            }
        }
        }

    val modelLiveData: LiveData<List<PersonalDocumentModel>>? = _modelLiveData


    fun addPersonalDocument(personalDocumentModel: PersonalDocumentModel) {
        viewModelScope.launch(Dispatchers.IO) {
            RepoProvider.getPersonalDocumentRepo(applicationInstance)?.addPersonalDocument(PersonalDocumentEntityMapper(personalDocumentModel).mapToModel())
        }
    }






}