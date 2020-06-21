package com.tyche.deadlinetracker.ui.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tyche.deadlinetracker.R
import com.tyche.deadlinetracker.data.PersonalDocumentEntity
import kotlinx.android.synthetic.main.personal_document_item.view.*

class PersonalDocumentViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup) :
            this(LayoutInflater.from(parent.context).inflate(R.layout.personal_document_item, parent, false))
    fun bind(personalDocumentEntity: PersonalDocumentEntity) {
        itemView.document_name.text = personalDocumentEntity.name
        itemView.document_date.text = personalDocumentEntity.expiryDate.toString()
    }
}