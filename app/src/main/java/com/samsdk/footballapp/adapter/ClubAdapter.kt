package com.samsdk.footballapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samsdk.footballapp.databinding.ItemClubBinding
import com.samsdk.footballapp.model.Standing
import com.squareup.picasso.Picasso

class ClubAdapter : ListAdapter<Standing, ClubAdapter.TeamsViewHolder>(DiffCallBack()) {

    private class DiffCallBack : DiffUtil.ItemCallback<Standing>() {
        override fun areItemsTheSame(oldItem: Standing, newItem: Standing): Boolean {
            return oldItem.team == newItem.team
        }

        override fun areContentsTheSame(oldItem: Standing, newItem: Standing): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        return TeamsViewHolder(
            ItemClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(getItem(position), position.plus(1))
    }

    inner class TeamsViewHolder(private val binding: ItemClubBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Standing, position: Int) {
            try {
                binding.apply {
                    Picasso.get()
                        .load(data.team.logos[0].href)
                        .into(imageView)

                    tvRank.text = position.toString()
                    tvClub.text = data.team.name
                    tvP.text = data.stats[3].value.toString()
                    tvD.text = data.stats[2].value.toString()
                    tvL.text = data.stats[1].value.toString()
                    tvPts.text = data.stats[6].value.toString()
                    tvGd.text = data.stats[9].value.toString()
                    tvW.text = data.stats[0].value.toString()
                }
            } catch (e: Exception) {
                Log.d("@@@@@", e.stackTraceToString())
            }
        }
    }
}