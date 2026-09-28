package com.smartcropcare.app.data.disease

import android.content.Context
import android.graphics.Bitmap
import com.smartcropcare.app.R
import com.smartcropcare.app.data.model.DiagnosisResult
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.FileChannel

class PlantDiseaseClassifier(private val context: Context) {

    private var interpreter: Interpreter? = null
    val MODEL_FILE_NAME = "plant_disease_model.tflite"
    val INPUT_DIMENSION = 224

    init {
        try {
            val assetFileDescriptor = context.assets.openFd(MODEL_FILE_NAME)
            val inputStream = FileInputStream(assetFileDescriptor.fileDescriptor)
            val fileChannel = inputStream.channel
            val startOffset = assetFileDescriptor.startOffset
            val declaredLength = assetFileDescriptor.declaredLength
            val modelBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
            interpreter = Interpreter(modelBuffer)
        } catch (e: Exception) {
            // Model file plant_disease_model.tflite is not yet present in assets/
            interpreter = null
        }
    }

    fun isModelAvailable(): Boolean = interpreter != null

    fun classifyImage(bitmap: Bitmap, selectedCropName: String): DiagnosisResult {
        val tflite = interpreter
        if (tflite == null) {
            val missingMsg = context.getString(R.string.ai_model_missing_msg)
            return DiagnosisResult(
                cropName = selectedCropName,
                diseaseName = context.getString(R.string.ai_low_confidence_title),
                pathogen = missingMsg,
                confidencePct = 0.0,
                severityStage = "--",
                observedSymptoms = listOf(missingMsg),
                organicTreatment = "N/A",
                chemicalTreatment = "N/A",
                isSafe = false,
                lesionTag = "N/A"
            )
        }

        try {
            // Preprocess input bitmap to 224x224 RGB FloatBuffer normalized [0.0, 1.0]
            val resizedBitmap = Bitmap.createScaledBitmap(bitmap, INPUT_DIMENSION, INPUT_DIMENSION, true)
            val imgData = ByteBuffer.allocateDirect(4 * INPUT_DIMENSION * INPUT_DIMENSION * 3)
            imgData.order(ByteOrder.nativeOrder())

            val intValues = IntArray(INPUT_DIMENSION * INPUT_DIMENSION)
            resizedBitmap.getPixels(intValues, 0, resizedBitmap.width, 0, 0, resizedBitmap.width, resizedBitmap.height)

            var pixel = 0
            for (i in 0 until INPUT_DIMENSION) {
                for (j in 0 until INPUT_DIMENSION) {
                    val value = intValues[pixel++]
                    imgData.putFloat(((value shr 16 and 0xFF) / 255.0f))
                    imgData.putFloat(((value shr 8 and 0xFF) / 255.0f))
                    imgData.putFloat(((value and 0xFF) / 255.0f))
                }
            }

            // Output logit tensor for supported classes
            val output = Array(1) { FloatArray(10) }
            tflite.run(imgData, output)

            // Extract top prediction class and probability
            val predictions = output[0]
            var maxIndex = 0
            var maxConf = predictions[0]
            for (k in 1 until predictions.size) {
                if (predictions[k] > maxConf) {
                    maxConf = predictions[k]
                    maxIndex = k
                }
            }

            val confidencePct = (maxConf * 100.0).coerceIn(0.0, 100.0)

            // Requirement 4 & 8: Low confidence threshold check (< 60.0%)
            if (confidencePct < 60.0) {
                val lowConfMsg = context.getString(R.string.ai_low_confidence_msg)
                return DiagnosisResult(
                    cropName = selectedCropName,
                    diseaseName = context.getString(R.string.ai_low_confidence_title),
                    pathogen = lowConfMsg,
                    confidencePct = confidencePct,
                    severityStage = "--",
                    observedSymptoms = listOf(lowConfMsg),
                    organicTreatment = "N/A",
                    chemicalTreatment = "N/A",
                    isSafe = false,
                    lesionTag = "Low Conf"
                )
            }

            // Map class index to Disease Knowledge Database
            val diseaseName = mapClassIndexToDiseaseName(maxIndex)
            val result = DiseaseKnowledgeBase.getDiagnosis(selectedCropName, diseaseName, confidencePct)
            
            // Requirement 7 & 8: Append safety disclaimer
            val disclaimer = context.getString(R.string.ai_safety_disclaimer)
            return result.copy(
                chemicalTreatment = "${result.chemicalTreatment}\n\n⚠️ $disclaimer"
            )

        } catch (e: Exception) {
            e.printStackTrace()
            val errorMsg = context.getString(R.string.ai_low_confidence_msg)
            return DiagnosisResult(
                cropName = selectedCropName,
                diseaseName = context.getString(R.string.ai_low_confidence_title),
                pathogen = e.localizedMessage ?: errorMsg,
                confidencePct = 0.0,
                severityStage = "--",
                observedSymptoms = listOf(errorMsg),
                organicTreatment = "N/A",
                chemicalTreatment = "N/A",
                isSafe = false,
                lesionTag = "Error"
            )
        }
    }

    private fun mapClassIndexToDiseaseName(classIndex: Int): String {
        return when (classIndex) {
            0 -> "Early Blight"
            1 -> "Late Blight"
            2 -> "Yellow Vein Mosaic Virus"
            3 -> "Shoot and Fruit Borer"
            4 -> "Chilli Leaf Curl Virus"
            5 -> "Anthracnose"
            6 -> "Powdery Mildew"
            7 -> "Bacterial Leaf Blight"
            8 -> "Rice Blast"
            else -> "Healthy"
        }
    }
}
