package com.tyche.deadlinetracker.data

import com.tyche.deadlinetracker.ui.model.PersonalDocumentModel

class PersonalDocumentEntityMapper constructor(private val personalDocumentModel: PersonalDocumentModel) {
    fun mapToModel() = PersonalDocumentEntity (
        personalDocumentModel.id,
        personalDocumentModel.name
    )

}