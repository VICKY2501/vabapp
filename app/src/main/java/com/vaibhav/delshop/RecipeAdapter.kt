package com.vaibhav.delshop

import Dataclasses.Hit
import Dataclasses.Recipe
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.vaibhav.delshop.databinding.RecyclerdataBinding

class RecipeAdapter(val listener: Rvlisten) :
    ListAdapter<Hit, RecipeAdapter.FoodPhotosViewHolder>(DiffCallback) {

    /**
     * The MarsPhotosViewHolder constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [MarsPhoto] information.
     */
    inner class FoodPhotosViewHolder(
        private var binding: RecyclerdataBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(foodPhoto: Hit) {
            binding.photo = foodPhoto.recipe
            binding.executePendingBindings()
            itemView.setOnClickListener {
                listener.onclicked(foodPhoto)
            }
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of
     * [MarsPhoto] has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.recipe == newItem.recipe
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.recipe.image == newItem.recipe.image
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodPhotosViewHolder {
        return FoodPhotosViewHolder(
            RecyclerdataBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: FoodPhotosViewHolder, position: Int) {
        val foodPhoto = getItem(position)
        holder.bind(foodPhoto)
    }
}

interface Rvlisten {
    fun onclicked(hit: Hit)
}
