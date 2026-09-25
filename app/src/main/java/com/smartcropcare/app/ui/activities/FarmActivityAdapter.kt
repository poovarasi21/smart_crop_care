package com.smartcropcare.app.ui.activities

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartcropcare.app.R
import com.smartcropcare.app.data.local.entity.FarmActivityEntity
import com.smartcropcare.app.databinding.ItemFarmActivityBinding

class FarmActivityAdapter(
    private val onActivityToggled: (FarmActivityEntity, Boolean) -> Unit
) : ListAdapter<FarmActivityEntity, FarmActivityAdapter.ActivityViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val binding = ItemFarmActivityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ActivityViewHolder(
        private val binding: ItemFarmActivityBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(activity: FarmActivityEntity) {
            binding.tvActivityTime.text = activity.time
            binding.tvActivityTag.text = activity.tag
            binding.tvActivityTitle.text = activity.title

            if (activity.isCompleted) {
                binding.btnCheckFrame.setBackgroundResource(R.drawable.bg_pill_optimal)
                binding.btnCheckFrame.backgroundTintList =
                    android.content.res.ColorStateList.valueOf(Color.parseColor("#1B5E20"))
                binding.ivCheckIcon.visibility = View.VISIBLE
                binding.tvActivityTitle.paintFlags =
                    binding.tvActivityTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                binding.tvActivityTitle.alpha = 0.6f
            } else {
                binding.btnCheckFrame.setBackgroundResource(R.drawable.bg_rounded_container_low)
                binding.btnCheckFrame.backgroundTintList = null
                binding.ivCheckIcon.visibility = View.GONE
                binding.tvActivityTitle.paintFlags =
                    binding.tvActivityTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                binding.tvActivityTitle.alpha = 1.0f
            }

            binding.root.setOnClickListener {
                onActivityToggled(activity, !activity.isCompleted)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FarmActivityEntity>() {
        override fun areItemsTheSame(oldItem: FarmActivityEntity, newItem: FarmActivityEntity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: FarmActivityEntity, newItem: FarmActivityEntity): Boolean =
            oldItem == newItem
    }
}
