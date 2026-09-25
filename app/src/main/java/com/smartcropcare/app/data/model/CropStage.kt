package com.smartcropcare.app.data.model

data class CropStage(
    val index: Int,
    val name: String,
    val isCompleted: Boolean,
    val isCurrent: Boolean,
    val isUpcoming: Boolean
) {
    companion object {
        val ALL_STAGES = listOf(
            "Seed",
            "Germinate",
            "Seedling",
            "Vegetative",
            "Flowering",
            "Fruiting",
            "Harvest"
        )
    }
}
