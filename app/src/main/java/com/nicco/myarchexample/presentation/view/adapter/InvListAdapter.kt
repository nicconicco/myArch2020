package com.nicco.myarchexample.presentation.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.View.OnClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nicco.myarchexample.R
import com.nicco.myarchexample.presentation.model.InvModel
import kotlinx.android.synthetic.main.inv_item.view.*

class InvListAdapter() :
    ListAdapter<InvModel, InvListAdapter.InvViewHolder>(
        InvModelDC()
    ) {

    var interaction: Interaction? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = InvViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.inv_item, parent, false), interaction
    )

    override fun onBindViewHolder(holder: InvViewHolder, position: Int) =
        holder.bind(getItem(position))

    fun swapData(data: List<InvModel>) {
        submitList(data.toMutableList())
    }

    inner class InvViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView), OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            if (adapterPosition == RecyclerView.NO_POSITION) return

            val clicked = getItem(adapterPosition)

            interaction?.InvClicked(clicked)
        }

        fun bind(item: InvModel) = with(itemView) {
            tvTitle.text = item.title
            tvBody.text = item.description
        }
    }

    interface Interaction {
        fun InvClicked(inv: InvModel)
    }

    private class InvModelDC : DiffUtil.ItemCallback<InvModel>() {
        override fun areItemsTheSame(
            oldItem: InvModel,
            newItem: InvModel
        ): Boolean = oldItem.title == newItem.title

        override fun areContentsTheSame(
            oldItem: InvModel,
            newItem: InvModel
        ): Boolean = oldItem == newItem
    }
}