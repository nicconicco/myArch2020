package com.nicco.myarchexample.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nicco.core.fake.Category
import com.nicco.myarchexample.R
import kotlinx.android.synthetic.main.item_pager_itau.view.*

class DiffUtilCategoryItemViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
    constructor(parent: ViewGroup) :
            this(LayoutInflater.from(parent.context).inflate(R.layout.item_pager_itau, parent, false))

    fun bind(category: Category) {
        itemView.title.text = category.name
    }
}