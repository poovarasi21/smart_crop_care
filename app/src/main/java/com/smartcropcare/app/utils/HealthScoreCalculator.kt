package com.smartcropcare.app.utils

object HealthScoreCalculator {
    data class HealthAssessment(
        val score: Int,
        val status: String,
        val grade: String,
        val ndviIndex: Double
    )

    fun calculateHealth(
        soilMoisturePct: Int,
        activeDiseasesCount: Int,
        hasPestAlert: Boolean,
        irrigationAdherencePct: Int = 95
    ): HealthAssessment {
        var score = 100

        // Moisture deviation penalty
        if (soilMoisturePct !in 60..70) {
            val deviation = if (soilMoisturePct < 60) 60 - soilMoisturePct else soilMoisturePct - 70
            score -= (deviation * 0.8).toInt()
        }

        // Pest penalty
        if (hasPestAlert) {
            score -= 12
        }

        // Active disease penalty
        score -= (activeDiseasesCount * 6)

        // Adherence
        if (irrigationAdherencePct < 90) {
            score -= (90 - irrigationAdherencePct) / 2
        }

        val finalScore = score.coerceIn(30, 99)
        val status = when {
            finalScore >= 85 -> "Healthy"
            finalScore >= 75 -> "Attention"
            else -> "Critical"
        }
        val grade = when {
            finalScore >= 85 -> "Grade A - Prime Vigour"
            finalScore >= 75 -> "Grade B - Moderate"
            else -> "Grade C - Needs Action"
        }
        val ndvi = (0.50 + (finalScore / 100.0) * 0.35).coerceAtMost(0.92)

        return HealthAssessment(
            score = finalScore,
            status = status,
            grade = grade,
            ndviIndex = String.format("%.2f", ndvi).toDouble()
        )
    }
}
