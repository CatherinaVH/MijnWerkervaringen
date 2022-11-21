package com.example.mijnwerkervaringen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mijnwerkervaringen.databinding.DetailErvaringInLijstBinding

class LijstErvaringenAdapter (val clickListener: ErvaringClickListener):
    ListAdapter<Ervaring, LijstErvaringenAdapter.ViewHolder>(ToDoDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: DetailErvaringInLijstBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            ervaring: Ervaring,
            clickListener: ErvaringClickListener
        ) {
            binding.ervaring = ervaring
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DetailErvaringInLijstBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}
class ToDoDiffCallback : DiffUtil.ItemCallback<Ervaring>() {

    override fun areItemsTheSame(oldItem: Ervaring, newItem: Ervaring): Boolean {
        return oldItem.school == newItem.school //&& oldItem.datumVan == newItem.datumVan
    }

    override fun areContentsTheSame(oldItem: Ervaring, newItem: Ervaring): Boolean {
        return oldItem == newItem
    }
}

class ErvaringClickListener(val clickListener: (ervaring: Ervaring) -> Unit) {
    fun onClick(ervaring: Ervaring) = clickListener(ervaring)
}