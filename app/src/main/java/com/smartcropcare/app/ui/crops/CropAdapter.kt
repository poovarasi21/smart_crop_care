package com.smartcropcare.app.ui.crops

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartcropcare.app.R
import com.smartcropcare.app.data.local.entity.CropEntity
import com.smartcropcare.app.databinding.ItemActiveCropBinding

class CropAdapter(
    private val onCropClicked: (CropEntity) -> Unit
) : ListAdapter<CropEntity, CropAdapter.CropViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CropViewHolder {
        val binding = ItemActiveCropBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CropViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CropViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CropViewHolder(
        private val binding: ItemActiveCropBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(crop: CropEntity) {
            binding.tvCropName.text = crop.name
            binding.tvCropVariety.text = "(${crop.variety})"
            binding.tvCropStageDap.text = "${crop.stageName} • Day ${crop.cropAgeDays}"
            binding.tvProgressPct.text = "${crop.cycleProgressPct}%"
            binding.pbCycleProgress.progress = crop.cycleProgressPct
            binding.tvWaterStatus.text = crop.waterStatus
            binding.tvFertilizerStatus.text = crop.fertilizerStatus

            // Health status badge formatting
            if (crop.healthStatus.contains("Pest", ignoreCase = true) || crop.healthScore < 80) {
                binding.tvHealthScoreBadge.text = "${crop.healthScore}% Pest Alert"
                binding.tvHealthScoreBadge.setBackgroundResource(R.drawable.bg_pill_warning)
                binding.tvHealthScoreBadge.setTextColor(Color.parseColor("#7E4200"))
            } else if (crop.healthScore >= 90) {
                binding.tvHealthScoreBadge.text = "${crop.healthScore}% Excellent"
                binding.tvHealthScoreBadge.setBackgroundResource(R.drawable.bg_pill_optimal)
                binding.tvHealthScoreBadge.setTextColor(Color.parseColor("#1B5E20"))
            } else {
                binding.tvHealthScoreBadge.text = "${crop.healthScore}% Health"
                binding.tvHealthScoreBadge.setBackgroundResource(R.drawable.bg_pill_optimal)
                binding.tvHealthScoreBadge.setTextColor(Color.parseColor("#1B5E20"))
            }

            binding.root.setOnClickListener {
                onCropClicked(crop)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CropEntity>() {
        override fun areItemsTheSame(oldItem: CropEntity, newItem: CropEntity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CropEntity, newItem: CropEntity): Boolean =
            oldItem == newItem
    }
}
