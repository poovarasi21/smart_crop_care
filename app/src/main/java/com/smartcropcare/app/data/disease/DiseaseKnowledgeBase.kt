package com.smartcropcare.app.data.disease

import com.smartcropcare.app.data.model.DiagnosisResult

object DiseaseKnowledgeBase {

    val SUPPORTED_CROPS = listOf(
        "Tomato",
        "Ladies Finger / Okra",
        "Brinjal / Eggplant",
        "Chilli",
        "Potato",
        "Rice",
        "Cotton"
    )

    fun getDiagnosis(cropName: String, diseaseName: String, confidencePct: Double): DiagnosisResult {
        val cropKey = cropName.lowercase().trim()
        val diseaseKey = diseaseName.lowercase().trim()

        return when {
            cropKey.contains("tomato") -> getTomatoDiagnosis(diseaseKey, confidencePct)
            cropKey.contains("okra") || cropKey.contains("ladies finger") -> getOkraDiagnosis(diseaseKey, confidencePct)
            cropKey.contains("brinjal") || cropKey.contains("eggplant") -> getBrinjalDiagnosis(diseaseKey, confidencePct)
            cropKey.contains("chilli") -> getChilliDiagnosis(diseaseKey, confidencePct)
            cropKey.contains("potato") -> getPotatoDiagnosis(diseaseKey, confidencePct)
            cropKey.contains("rice") -> getRiceDiagnosis(diseaseKey, confidencePct)
            cropKey.contains("cotton") -> getCottonDiagnosis(diseaseKey, confidencePct)
            else -> getTomatoDiagnosis(diseaseKey, confidencePct)
        }
    }

    private fun getTomatoDiagnosis(diseaseKey: String, confidencePct: Double): DiagnosisResult {
        return when {
            diseaseKey.contains("late blight") -> DiagnosisResult(
                cropName = "Tomato",
                diseaseName = "Tomato Late Blight (Phytophthora infestans)",
                pathogen = "Oomycete pathogen active in cool, water-saturated leaves",
                confidencePct = confidencePct,
                severityStage = if (confidencePct > 85) "Stage 2: Moderate" else "Stage 1: Mild",
                observedSymptoms = listOf(
                    "Dark water-soaked lesions expanding rapidly on leaf tips",
                    "White cottony fungal growth on lower leaf surfaces during high humidity"
                ),
                organicTreatment = "Prune affected leaves. Spray Trichoderma viride @ 5g/Litre or Neem oil 3%.",
                chemicalTreatment = "Apply Cymoxanil + Mancozeb @ 2g/Litre or Metalaxyl-M @ 2g/Litre immediately.",
                isSafe = false,
                lesionTag = "Blight #1"
            )
            diseaseKey.contains("yellow leaf curl") -> DiagnosisResult(
                cropName = "Tomato",
                diseaseName = "Tomato Yellow Leaf Curl Virus (TYLCV)",
                pathogen = "Begomovirus vector-borne transmission via Whitefly (Bemisia tabaci)",
                confidencePct = confidencePct,
                severityStage = "Stage 2: Severe Stunting",
                observedSymptoms = listOf(
                    "Upward curling and yellowing of leaf margins",
                    "Stunted plant growth and significant reduction in fruit set"
                ),
                organicTreatment = "Install yellow sticky traps (15/acre). Spray Neem Seed Kernel Extract (NSKE 5%).",
                chemicalTreatment = "Control whiteflies using Imidacloprid 17.8% SL @ 0.3ml/Litre or Acetamiprid 20% SP @ 0.2g/Litre.",
                isSafe = false,
                lesionTag = "Curl #1"
            )
            diseaseKey.contains("healthy") -> DiagnosisResult(
                cropName = "Tomato",
                diseaseName = "Healthy Tomato Canopy",
                pathogen = "No pathological lesions detected",
                confidencePct = confidencePct,
                severityStage = "Healthy",
                observedSymptoms = listOf(
                    "Vibrant green leaf lamina without chlorosis or necrosis",
                    "Optimal turgor and healthy vascular structure"
                ),
                organicTreatment = "Maintain regular drip irrigation and balanced organic compost application.",
                chemicalTreatment = "No chemical intervention required.",
                isSafe = true,
                lesionTag = "Optimal"
            )
            else -> DiagnosisResult(
                cropName = "Tomato",
                diseaseName = "Tomato Early Blight (Alternaria solani)",
                pathogen = "Fungal pathogen prevalent in humid night / warm day thermal cycles",
                confidencePct = confidencePct,
                severityStage = "Stage 1: Mild Lesions",
                observedSymptoms = listOf(
                    "Concentric dark brown rings with 'target board' pattern on foliage",
                    "Chlorotic yellow halo surrounding brown necrotic spots"
                ),
                organicTreatment = "Prune infected lower foliage. Avoid overhead sprinkler irrigation to reduce leaf wetness.",
                chemicalTreatment = "Apply Mancozeb 75% WP @ 2g/Litre or Copper Oxychloride 50% WP @ 2.5g/Litre.",
                isSafe = false,
                lesionTag = "Target Spot"
            )
        }
    }

    private fun getOkraDiagnosis(diseaseKey: String, confidencePct: Double): DiagnosisResult {
        return when {
            diseaseKey.contains("powdery mildew") -> DiagnosisResult(
                cropName = "Ladies Finger / Okra",
                diseaseName = "Okra Powdery Mildew (Erysiphe cichoracearum)",
                pathogen = "Ascomycete fungal spores multiplying under shade and dry atmospheric conditions",
                confidencePct = confidencePct,
                severityStage = "Stage 1: Mild",
                observedSymptoms = listOf(
                    "White powdery fungal patches on upper leaf surfaces",
                    "Premature yellowing and drying of lower canopy leaves"
                ),
                organicTreatment = "Spray wettable Sulphur 80% WP @ 3g/Litre or Cow milk spray (10% concentration).",
                chemicalTreatment = "Spray Dinocap 48% EC @ 1ml/Litre or Hexaconazole 5% EC @ 1ml/Litre.",
                isSafe = false,
                lesionTag = "Powder #1"
            )
            diseaseKey.contains("healthy") -> DiagnosisResult(
                cropName = "Ladies Finger / Okra",
                diseaseName = "Healthy Okra Canopy",
                pathogen = "No vector or fungal symptoms",
                confidencePct = confidencePct,
                severityStage = "Healthy",
                observedSymptoms = listOf("Normal green foliage with intact veinal architecture"),
                organicTreatment = "Regular weeding and soil aeration.",
                chemicalTreatment = "No chemical spray needed.",
                isSafe = true,
                lesionTag = "Healthy"
            )
            else -> DiagnosisResult(
                cropName = "Ladies Finger / Okra",
                diseaseName = "Yellow Vein Mosaic Virus (YVMV)",
                pathogen = "Begomovirus transmitted by Whiteflies",
                confidencePct = confidencePct,
                severityStage = "Stage 1: Mild",
                observedSymptoms = listOf(
                    "Bright yellow network of veins on foliage",
                    "Stunted plant growth and small yellowish fruits"
                ),
                organicTreatment = "Install yellow sticky traps (12/acre) and spray Neem oil 3000 ppm @ 3ml/Litre.",
                chemicalTreatment = "Spray Thiamethoxam 25% WG @ 0.3g/Litre or Dimethoate 30% EC @ 1.7ml/Litre.",
                isSafe = false,
                lesionTag = "Vein #1"
            )
        }
    }

    private fun getBrinjalDiagnosis(diseaseKey: String, confidencePct: Double): DiagnosisResult {
        return when {
            diseaseKey.contains("little leaf") -> DiagnosisResult(
                cropName = "Brinjal",
                diseaseName = "Brinjal Little Leaf (Phytoplasma)",
                pathogen = "Phytoplasma transmitted by Leafhoppers (Hishimonus phycitis)",
                confidencePct = confidencePct,
                severityStage = "Stage 2: Bushy Stunting",
                observedSymptoms = listOf(
                    "Exceedingly reduced leaf lamina size with bushy rosette appearance",
                    "Phyllody where floral parts transform into leaf-like structures"
                ),
                organicTreatment = "Uproot and destroy infected plants. Spray Neem oil @ 5ml/Litre.",
                chemicalTreatment = "Spray Dimethoate 30% EC @ 1.5ml/Litre to manage leafhopper vector.",
                isSafe = false,
                lesionTag = "Rosette"
            )
            diseaseKey.contains("healthy") -> DiagnosisResult(
                cropName = "Brinjal",
                diseaseName = "Healthy Brinjal Crop",
                pathogen = "No insect or bacterial infestation",
                confidencePct = confidencePct,
                severityStage = "Healthy",
                observedSymptoms = listOf("Intact purple-green foliage and healthy terminal shoots"),
                organicTreatment = "Maintain regular fertigation.",
                chemicalTreatment = "No action required.",
                isSafe = true,
                lesionTag = "Healthy"
            )
            else -> DiagnosisResult(
                cropName = "Brinjal",
                diseaseName = "Shoot and Fruit Borer (Leucinodes orbonalis)",
                pathogen = "Lepidopteran larvae internal boring inside shoots and fruits",
                confidencePct = confidencePct,
                severityStage = "Stage 2: Shoot Wilting",
                observedSymptoms = listOf(
                    "Withering and wilting of terminal shoots",
                    "Circular boreholes on fruits filled with larval frass"
                ),
                organicTreatment = "Clip and destroy infested shoots. Install pheromone traps with Lucinlure @ 12/acre.",
                chemicalTreatment = "Spray Chlorantraniliprole 18.5% SC @ 0.4ml/Litre or Emamectin Benzoate 5% SG @ 0.4g/Litre.",
                isSafe = false,
                lesionTag = "Borer Hole"
            )
        }
    }

    private fun getChilliDiagnosis(diseaseKey: String, confidencePct: Double): DiagnosisResult {
        return when {
            diseaseKey.contains("anthracnose") || diseaseKey.contains("fruit rot") -> DiagnosisResult(
                cropName = "Chilli",
                diseaseName = "Chilli Anthracnose / Fruit Rot (Colletotrichum capsici)",
                pathogen = "Fungal pathogen favoured by high temperature and relative humidity >80%",
                confidencePct = confidencePct,
                severityStage = "Stage 2: Fruit Rot",
                observedSymptoms = listOf(
                    "Circular sunken dark necrotic spots on maturing chili pods",
                    "Concentric rings of black acervuli fructifications on fruit skin"
                ),
                organicTreatment = "Destroy infected fruits. Spray Pseudomonas fluorescens @ 10g/Litre.",
                chemicalTreatment = "Spray Azoxystrobin 23% SC @ 1ml/Litre or Difenoconazole 25% EC @ 0.5ml/Litre.",
                isSafe = false,
                lesionTag = "Fruit Rot"
            )
            diseaseKey.contains("healthy") -> DiagnosisResult(
                cropName = "Chilli",
                diseaseName = "Healthy Chilli Crop",
                pathogen = "No thrips or fungal rot detected",
                confidencePct = confidencePct,
                severityStage = "Healthy",
                observedSymptoms = listOf("Smooth green leaves without boat-shaped cupping"),
                organicTreatment = "Maintain proper spacing and moisture.",
                chemicalTreatment = "No chemical needed.",
                isSafe = true,
                lesionTag = "Healthy"
            )
            else -> DiagnosisResult(
                cropName = "Chilli",
                diseaseName = "Chilli Leaf Curl Virus (Begomovirus)",
                pathogen = "Transmitted by Thrips and Mites",
                confidencePct = confidencePct,
                severityStage = "Stage 1: Upward Curling",
                observedSymptoms = listOf(
                    "Upward curling and puckering of leaves (Boat-shaped cupping)",
                    "Shortened internodes and thickened stunted canopy"
                ),
                organicTreatment = "Spray Agniastra or Neem oil 10,000 ppm @ 2ml/Litre.",
                chemicalTreatment = "Spray Diafenthiuron 50% WP @ 1.2g/Litre or Fipronil 5% SC @ 1.5ml/Litre.",
                isSafe = false,
                lesionTag = "Curl #1"
            )
        }
    }

    private fun getPotatoDiagnosis(diseaseKey: String, confidencePct: Double): DiagnosisResult {
        return when {
            diseaseKey.contains("late blight") -> DiagnosisResult(
                cropName = "Potato",
                diseaseName = "Potato Late Blight (Phytophthora infestans)",
                pathogen = "Water mold oomycete multiplying rapidly under wet foggy conditions",
                confidencePct = confidencePct,
                severityStage = "Stage 2: Canopy Decay",
                observedSymptoms = listOf(
                    "Water-soaked black lesions rapidly spreading from leaf margins",
                    "White mildew bloom visible on the underside of leaves during morning hours"
                ),
                organicTreatment = "Ridge soil around tubers. Spray Trichoderma harzianum @ 5g/Litre.",
                chemicalTreatment = "Spray Mancozeb 75% WP @ 2.5g/Litre or Dimethomorph 50% WP @ 1g/Litre.",
                isSafe = false,
                lesionTag = "Late Blight"
            )
            diseaseKey.contains("healthy") -> DiagnosisResult(
                cropName = "Potato",
                diseaseName = "Healthy Potato Foliage",
                pathogen = "No blight or viral mottle",
                confidencePct = confidencePct,
                severityStage = "Healthy",
                observedSymptoms = listOf("Healthy dark green compound foliage"),
                organicTreatment = "Ensure balanced earthing up and potash fertilization.",
                chemicalTreatment = "No chemical needed.",
                isSafe = true,
                lesionTag = "Healthy"
            )
            else -> DiagnosisResult(
                cropName = "Potato",
                diseaseName = "Potato Early Blight (Alternaria solani)",
                pathogen = "Air-borne fungal conidia infecting senescing lower leaves",
                confidencePct = confidencePct,
                severityStage = "Stage 1: Mild Target Spots",
                observedSymptoms = listOf("Brown angular spots with target-like concentric rings"),
                organicTreatment = "Prune yellowing lower leaves.",
                chemicalTreatment = "Apply Chlorothalonil 75% WP @ 2g/Litre.",
                isSafe = false,
                lesionTag = "Early Blight"
            )
        }
    }

    private fun getRiceDiagnosis(diseaseKey: String, confidencePct: Double): DiagnosisResult {
        return when {
            diseaseKey.contains("bacterial") -> DiagnosisResult(
                cropName = "Rice",
                diseaseName = "Rice Bacterial Leaf Blight (Xanthomonas oryzae)",
                pathogen = "Vascular bacterial pathogen spread by rain wind splashing",
                confidencePct = confidencePct,
                severityStage = "Stage 2: Kresek / Blight",
                observedSymptoms = listOf(
                    "Wavy translucent yellow to white stripes expanding along leaf margins",
                    "Bacterial ooze droplets visible on young leaf lesions during damp morning"
                ),
                organicTreatment = "Apply fresh cow dung extract (20%) or Bleaching powder @ 2kg/acre.",
                chemicalTreatment = "Spray Streptocycline @ 0.1g/Litre + Copper Oxychloride @ 2g/Litre.",
                isSafe = false,
                lesionTag = "Bacterial Blight"
            )
            diseaseKey.contains("healthy") -> DiagnosisResult(
                cropName = "Rice",
                diseaseName = "Healthy Paddy Crop",
                pathogen = "No blast or bacterial blight spots",
                confidencePct = confidencePct,
                severityStage = "Healthy",
                observedSymptoms = listOf("Uniform green erect leaf blades without spindle lesions"),
                organicTreatment = "Maintain water depth at 2-5cm and split Nitrogen dosage.",
                chemicalTreatment = "No chemical needed.",
                isSafe = true,
                lesionTag = "Healthy"
            )
            else -> DiagnosisResult(
                cropName = "Rice",
                diseaseName = "Rice Leaf Blast (Magnaporthe oryzae)",
                pathogen = "Ascomycete fungus active under high relative humidity (>90%) and cool nights",
                confidencePct = confidencePct,
                severityStage = "Stage 1: Spindle Lesions",
                observedSymptoms = listOf("Eye-shaped or spindle-shaped lesions with reddish-brown margins and ash center"),
                organicTreatment = "Spray Pseudomonas fluorescens @ 10g/Litre as seed & foliar treatment.",
                chemicalTreatment = "Spray Tricyclazole 75% WP @ 0.6g/Litre or Isoprothiolane 40% EC @ 1.5ml/Litre.",
                isSafe = false,
                lesionTag = "Blast Eye"
            )
        }
    }

    private fun getCottonDiagnosis(diseaseKey: String, confidencePct: Double): DiagnosisResult {
        return when {
            diseaseKey.contains("curl") -> DiagnosisResult(
                cropName = "Cotton",
                diseaseName = "Cotton Leaf Curl Virus (CLCuV)",
                pathogen = "Begomovirus vector transmitted by Whitefly",
                confidencePct = confidencePct,
                severityStage = "Stage 2: Enation & Curling",
                observedSymptoms = listOf(
                    "Upward or downward cupping of leaves with leaf-like enations on lower veins",
                    "Thickened dark green veins and severe crop stunting"
                ),
                organicTreatment = "Remove infected plants. Spray Neem oil @ 5ml/Litre.",
                chemicalTreatment = "Spray Afidopyropen 50g/L SC @ 2ml/Litre or Flonicamid 50% WG @ 0.3g/Litre.",
                isSafe = false,
                lesionTag = "Enation"
            )
            diseaseKey.contains("healthy") -> DiagnosisResult(
                cropName = "Cotton",
                diseaseName = "Healthy Cotton Canopy",
                pathogen = "No bacterial angular spots",
                confidencePct = confidencePct,
                severityStage = "Healthy",
                observedSymptoms = listOf("Broad lobed green leaves without water-soaked angular lesions"),
                organicTreatment = "Soil drenching with bio-fertilizers.",
                chemicalTreatment = "No chemical needed.",
                isSafe = true,
                lesionTag = "Healthy"
            )
            else -> DiagnosisResult(
                cropName = "Cotton",
                diseaseName = "Cotton Angular Leaf Spot / Bacterial Blight (Xanthomonas citri pv. malvacearum)",
                pathogen = "Seed-borne bacterial pathogen causing black arm symptoms",
                confidencePct = confidencePct,
                severityStage = "Stage 1: Angular Spots",
                observedSymptoms = listOf("Small dark brown angular water-soaked spots bounded by leaf veins"),
                organicTreatment = "Spray Copper Hydroxide @ 2g/Litre.",
                chemicalTreatment = "Spray Streptocycline @ 0.1g/Litre + Copper Oxychloride 50% WP @ 2g/Litre.",
                isSafe = false,
                lesionTag = "Angular Spot"
            )
        }
    }
}
