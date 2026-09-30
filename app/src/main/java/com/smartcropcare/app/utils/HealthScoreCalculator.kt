package com.smartcropcare.app.utils

import java.util.Locale

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
        irrigationCount: Int = 1,
        fertilizerCount: Int = 1,
        hasRecordData: Boolean = true
    ): HealthAssessment? {
        if (!hasRecordData && soilMoisturePct <= 0 && irrigationCount == 0 && fertilizerCount == 0) {
            return null
        }

        var score = 100

        // Moisture deviation penalty (optimal: 55-75%)
        if (soilMoisturePct > 0) {
            if (soilMoisturePct !in 55..75) {
                val deviation = if (soilMoisturePct < 55) 55 - soilMoisturePct else soilMoisturePct - 75
                score -= (deviation * 0.7).toInt()
            }
        } else {
            score -= 5
        }

        // Pest penalty
        if (hasPestAlert) {
            score -= 15
        }

        // Active disease penalty
        score -= (activeDiseasesCount * 12)

        // Irrigation adherence
        if (irrigationCount == 0) {
            score -= 10
        }

        // Fertilizer adherence
        if (fertilizerCount == 0) {
            score -= 5
        }

        val finalScore = score.coerceIn(25, 98)
        val status = when {
            finalScore >= 80 -> "Healthy"
            finalScore >= 60 -> "Attention"
            else -> "Critical"
        }
        val grade = when {
            finalScore >= 80 -> "Grade A - Optimal Vigour"
            finalScore >= 60 -> "Grade B - Moderate"
            else -> "Grade C - Action Required"
        }
        val ndvi = (0.45 + (finalScore / 100.0) * 0.40).coerceIn(0.2, 0.95)

        return HealthAssessment(
            score = finalScore,
            status = status,
            grade = grade,
            ndviIndex = String.format(Locale.ROOT, "%.2f", ndvi).toDouble()
        )
    }
}
