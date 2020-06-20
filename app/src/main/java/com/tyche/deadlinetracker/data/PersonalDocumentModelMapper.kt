package com.tyche.deadlinetracker.data

import com.tyche.deadlinetracker.ui.model.PersonalDocumentModel

class PersonalDocumentModelMapper constructor(private val personalDocumentEntity: PersonalDocumentEntity) {
    fun mapToModel() = PersonalDocumentModel (
        personalDocumentEntity.id,
        personalDocumentEntity.name
    )

}