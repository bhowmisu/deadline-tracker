package com.tyche.deadlinetracker.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tyche.deadlinetracker.data.PersonalDocumentEntity
import com.tyche.deadlinetracker.ui.viewholder.PersonalDocumentViewHolder

class PersonalDocumentPageAdapter : RecyclerView.Adapter<PersonalDocumentViewHolder>() {
    var list: List<PersonalDocumentEntity> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalDocumentViewHolder {
        return PersonalDocumentViewHolder(parent)
    }
    override fun onBindViewHolder(holder: PersonalDocumentViewHolder, position: Int) {
        holder.bind(list[position])
    }
    fun setItem(list: List<PersonalDocumentEntity>) {
        this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = list.size
}