package com.faustinodegroot.sportunity.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import coil.load
import com.faustinodegroot.sportunity.R
import com.faustinodegroot.sportunity.databinding.FragmentEventItemBinding
import com.faustinodegroot.sportunity.domain.model.Event
import com.faustinodegroot.sportunity.util.Utils

class EventListAdapter(
    private val listener: OnEventClickedListener,
) : PagingDataAdapter<Event, EventListAdapter.ViewHolder>(REPO_COMPARATOR) {

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Event>() {
            override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentEventItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = getItem(position)
        holder.bind(event)
    }

    inner class ViewHolder(private val binding: FragmentEventItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Event?) {
            if (item != null) {
                binding.eventImage.load(R.drawable.placeholder_event)
                binding.name.text = item.name
                binding.city.text = item.city
                binding.date.text = binding.root.context.getString(
                    R.string.date_range,
                    Utils.formatDate(item.dateFrom),
                    Utils.formatDate(item.dateTo)
                )
                binding.root.setOnClickListener { listener.onEventClicked(item) }
            }
        }

    }

    interface OnEventClickedListener {
        fun onEventClicked(event: Event)
    }

}
