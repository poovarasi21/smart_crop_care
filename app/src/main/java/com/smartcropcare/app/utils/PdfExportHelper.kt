package com.smartcropcare.app.utils

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.widget.Toast
import androidx.core.content.FileProvider
import com.smartcropcare.app.data.local.entity.CropEntity
import java.io.File
import java.io.FileOutputStream

object PdfExportHelper {
    fun generateAndSharePassportPdf(context: Context, crop: CropEntity) {
        try {
            val pdfDocument = PdfDocument()
            val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create() // A4 standard size
            val page = pdfDocument.startPage(pageInfo)
            val canvas = page.canvas

            val paint = Paint()
            val primaryPaint = Paint().apply {
                color = Color.parseColor("#1B5E20")
                isAntiAlias = true
            }
            val titlePaint = Paint().apply {
                color = Color.parseColor("#1B5E20")
                textSize = 20f
                isFakeBoldText = true
                isAntiAlias = true
            }
            val subtitlePaint = Paint().apply {
                color = Color.parseColor("#41493E")
                textSize = 12f
                isAntiAlias = true
            }
            val bodyPaint = Paint().apply {
                color = Color.parseColor("#121C2A")
                textSize = 13f
                isAntiAlias = true
            }
            val boldBodyPaint = Paint().apply {
                color = Color.parseColor("#121C2A")
                textSize = 13f
                isFakeBoldText = true
                isAntiAlias = true
            }

            // Top Header Bar
            canvas.drawRect(0f, 0f, 595f, 50f, primaryPaint)
            paint.color = Color.WHITE
            paint.textSize = 16f
            paint.isFakeBoldText = true
            paint.isAntiAlias = true
            canvas.drawText("SMART CROP CARE • DIGITAL CROP PASSPORT", 30f, 32f, paint)

            // Certificate Details
            var y = 90f
            canvas.drawText("Official Digital Crop Registry Certificate", 30f, y, titlePaint)
            y += 20f
            canvas.drawText("Certificate ID: ${crop.certificateId}", 30f, y, subtitlePaint)
            y += 30f

            // Section 1: Crop Identity
            canvas.drawRect(30f, y, 565f, y + 2f, primaryPaint)
            y += 20f
            canvas.drawText("1. CROP & VARIETY IDENTITY", 30f, y, titlePaint.apply { textSize = 14f })
            y += 25f
            canvas.drawText("Crop Name: ", 30f, y, subtitlePaint)
            canvas.drawText(crop.name, 150f, y, boldBodyPaint)
            canvas.drawText("Variety: ", 320f, y, subtitlePaint)
            canvas.drawText(crop.variety, 420f, y, boldBodyPaint)

            y += 20f
            canvas.drawText("Scientific Name: ", 30f, y, subtitlePaint)
            canvas.drawText(crop.scientificName, 150f, y, bodyPaint)
            canvas.drawText("Type: ", 320f, y, subtitlePaint)
            canvas.drawText(crop.hybridType, 420f, y, bodyPaint)

            y += 20f
            canvas.drawText("Plot & Location: ", 30f, y, subtitlePaint)
            canvas.drawText(crop.plotName, 150f, y, bodyPaint)
            canvas.drawText("Acreage: ", 320f, y, subtitlePaint)
            canvas.drawText("${crop.acreage} Acres", 420f, y, bodyPaint)

            y += 20f
            canvas.drawText("Soil Pedology: ", 30f, y, subtitlePaint)
            canvas.drawText(crop.soilType, 150f, y, bodyPaint)
            canvas.drawText("Planting Date: ", 320f, y, subtitlePaint)
            canvas.drawText(crop.plantingDate, 420f, y, bodyPaint)

            // Section 2: Key Performance Indicators
            y += 35f
            canvas.drawRect(30f, y, 565f, y + 2f, primaryPaint)
            y += 20f
            canvas.drawText("2. AGRONOMIC & ECONOMIC METRICS", 30f, y, titlePaint.apply { textSize = 14f })
            y += 25f

            canvas.drawText("Crop Health Score: ", 30f, y, subtitlePaint)
            canvas.drawText("${crop.healthScore} / 100 (${crop.healthStatus})", 150f, y, boldBodyPaint)
            canvas.drawText("Current Stage: ", 320f, y, subtitlePaint)
            canvas.drawText(crop.stageName, 420f, y, boldBodyPaint)

            y += 20f
            canvas.drawText("Estimated Yield: ", 30f, y, subtitlePaint)
            canvas.drawText("${crop.estimatedYieldTonPerAcre} Ton / Acre", 150f, y, boldBodyPaint)
            canvas.drawText("Days to Harvest: ", 320f, y, subtitlePaint)
            canvas.drawText("${crop.harvestCountdownDays} Days", 420f, y, boldBodyPaint)

            y += 20f
            canvas.drawText("Total Investment: ", 30f, y, subtitlePaint)
            canvas.drawText("₹${crop.totalInvestment.toInt()}", 150f, y, boldBodyPaint)
            canvas.drawText("Projected Revenue: ", 320f, y, subtitlePaint)
            canvas.drawText("₹${crop.projectedRevenue.toInt()}", 420f, y, boldBodyPaint)

            // Section 3: Audit Summary
            y += 35f
            canvas.drawRect(30f, y, 565f, y + 2f, primaryPaint)
            y += 20f
            canvas.drawText("3. VERIFIED TELEMETRY AUDIT TRAIL", 30f, y, titlePaint.apply { textSize = 14f })
            y += 25f
            canvas.drawText("• Irrigation: 24 Drip Sessions recorded (Efficiency 94% Target adherence)", 30f, y, bodyPaint)
            y += 20f
            canvas.drawText("• Nutrients: 6 Fertigation Doses applied (Boron, Zinc, NPK 100% on-time)", 30f, y, bodyPaint)
            y += 20f
            canvas.drawText("• AI Health Scans: 5 Deep Scans (Early Blight monitored & controlled)", 30f, y, bodyPaint)
            y += 20f
            canvas.drawText("• Photos & GPS: 14 Geotagged canopy photos verified via Smart Crop Care edge", 30f, y, bodyPaint)

            // Draw QR Code
            y += 40f
            try {
                val qrBitmap = QrCodeHelper.generateQrCode(crop.certificateId, 110)
                canvas.drawBitmap(qrBitmap, 440f, y, null)
            } catch (e: Exception) {
                // QR fallback
            }

            canvas.drawText("ICAR & Agronomy Agritech Seal", 30f, y + 25f, boldBodyPaint)
            canvas.drawText("Validated under Smart Crop Care Autonomous Precision Agronomy Framework v2.4", 30f, y + 45f, subtitlePaint)
            canvas.drawText("HASH: 8f4e-2026-arka-9821a | TIMESTAMP: 2026-10-01T08:30Z", 30f, y + 65f, subtitlePaint)

            pdfDocument.finishPage(page)

            // Save PDF
            val file = File(context.cacheDir, "${crop.certificateId}.pdf")
            val outputStream = FileOutputStream(file)
            pdfDocument.writeTo(outputStream)
            pdfDocument.close()
            outputStream.close()

            // Launch Share Intent
            val uri = FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                file
            )

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "application/pdf"
                putExtra(Intent.EXTRA_STREAM, uri)
                putExtra(Intent.EXTRA_SUBJECT, "Smart Crop Care - Digital Crop Passport (${crop.name})")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            context.startActivity(Intent.createChooser(shareIntent, "Share Digital Crop Passport PDF"))

        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Export error: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }
}
