package com.example.android.wiki.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.wiki.databinding.PropertyItemBinding
import com.example.android.wiki.network.ModelProperty

class MyAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<ModelProperty, MyAdapter.MyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyViewHolder {
        return MyViewHolder(
            PropertyItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val mProperty = getItem(position)
        // onClick
        holder.itemView.setOnClickListener {
            onClickListener.onClick(mProperty)
        }
        holder.bind(mProperty)
    }

    // MyViewHolder
    class MyViewHolder(private var binding: PropertyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mProperty: ModelProperty) {
            binding.property = mProperty
            // немедленное обновление
            binding.executePendingBindings()
        }
    }


    // Diffutil
    companion object DiffCallback : DiffUtil.ItemCallback<ModelProperty>() {

        override fun areItemsTheSame(oldItem: ModelProperty, newItem: ModelProperty): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ModelProperty, newItem: ModelProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    // OnClick
    class OnClickListener(val clickListener: (mProperty: ModelProperty) -> Unit) {
        fun onClick(mProperty: ModelProperty) = clickListener(mProperty)
    }

}