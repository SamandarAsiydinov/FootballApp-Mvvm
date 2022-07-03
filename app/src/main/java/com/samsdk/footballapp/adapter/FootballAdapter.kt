package com.samsdk.footballapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samsdk.footballapp.databinding.ItemLayoutBinding
import com.samsdk.footballapp.model.Data
import com.squareup.picasso.Picasso

class FootballAdapter : ListAdapter<Data, FootballAdapter.FootBallViewHolder>(DiffCallBack()) {

    lateinit var onItemClick: (Data) -> Unit

    private class DiffCallBack : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootBallViewHolder {
        return FootBallViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FootBallViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FootBallViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.apply {
                textName.text = data.name
                textAb.text = data.abbr

                Picasso.get()
                    .load(data.logos.light)
                    .into(binding.imageView)
            }
            itemView.setOnClickListener {
                onItemClick.invoke(data)
            }
        }
    }
}