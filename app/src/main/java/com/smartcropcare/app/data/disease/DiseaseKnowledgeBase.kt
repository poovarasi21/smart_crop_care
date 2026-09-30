package com.smartcropcare.app.data.disease

import com.smartcropcare.app.data.model.DiagnosisResult

data class DiseaseInfo(
    val englishName: String,
    val tamilName: String,
    val pathogen: String,
    val symptomsEn: List<String>,
    val symptomsTa: List<String>,
    val severity: String,
    val culturalOrganic: String,
    val biological: String,
    val chemicalTreatment: String,
    val prevention: String,
    val source: String = "TNAU Agritech Portal / ICAR-IIHR Guidelines"
)

object DiseaseKnowledgeBase {

    private const val KVK_DISCLAIMER = "Follow the current product label and local agricultural/KVK recommendation before application."

    val SUPPORTED_CROPS = listOf(
        "Rice",
        "Tomato",
        "Chilli",
        "Brinjal",
        "Groundnut",
        "Cotton",
        "Ladies Finger / Okra"
    )

    private val RICE_DISEASES = mapOf(
        "blast" to DiseaseInfo(
            englishName = "Rice Leaf Blast (Magnaporthe oryzae)",
            tamilName = "நெல் இலை கருகல் நோய் (பிளாஸ்ட்)",
            pathogen = "Fungal ascomycete active in cool night / high relative humidity (>90%)",
            symptomsEn = listOf(
                "Spindle-shaped or eye-shaped lesions with greyish center and dark brown margin",
                "Lesions coalesce causing drying of leaf blades"
            ),
            symptomsTa = listOf(
                "கண் வடிவ அல்லது கதிர் வடிவ பழுப்பு விளிம்பு புள்ளிகள்",
                "புள்ளிகள் இணைந்து இலைகள் காய்ந்து கருகும்"
            ),
            severity = "Stage 2: Moderate",
            culturalOrganic = "Avoid excess nitrogen fertilizer application. Split urea dosage. Seed treatment with Pseudomonas fluorescens @ 10g/kg seed.",
            biological = "Foliar spray of Pseudomonas fluorescens @ 5g/Litre or Trichoderma viride @ 5g/Litre.",
            chemicalTreatment = "Spray Tricyclazole 75% WP @ 0.6g/Litre or Isoprothiolane 40% EC @ 1.5ml/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Use certified blast-resistant seeds. Maintain uniform shallow water layer."
        ),
        "brown spot" to DiseaseInfo(
            englishName = "Rice Brown Spot (Bipolaris oryzae)",
            tamilName = "நெல் பழுப்பு புள்ளி நோய்",
            pathogen = "Fungal pathogen prevalent in nutrient-deficient and poorly drained soils",
            symptomsEn = listOf(
                "Small, oval to circular dark brown spots resembling sesame seeds on leaves and glumes",
                "Yellow chlorotic halo surrounds mature lesions"
            ),
            symptomsTa = listOf(
                "எள் போன்ற சிறிய முட்டை வடிவ பழுப்பு புள்ளிகள்",
                "புள்ளிகளைச் சுற்றி மஞ்சள் வளையம் காணப்படும்"
            ),
            severity = "Stage 1: Mild",
            culturalOrganic = "Apply balanced NPK with recommended potassium (potash) and zinc sulfate (25 kg/ha).",
            biological = "Seed treatment with Trichoderma harzianum @ 4g/kg seed.",
            chemicalTreatment = "Spray Mancozeb 75% WP @ 2g/Litre or Propiconazole 25% EC @ 1ml/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Soil testing, correcting potash and zinc deficiencies."
        ),
        "sheath blight" to DiseaseInfo(
            englishName = "Rice Sheath Blight (Rhizoctonia solani)",
            tamilName = "நெல் உறை அழுகல் நோய்",
            pathogen = "Soil-borne and water-borne fungal sclerotia favored by dense canopy and high humidity",
            symptomsEn = listOf(
                "Oval greenish-grey water-soaked lesions on leaf sheath near waterline",
                "Lesions coalesce and spread upwards with irregular brown margins"
            ),
            symptomsTa = listOf(
                "தண்ணீர் மட்டத்திற்கு மேல் இலையுறை பகுதியில் சாம்பல் நிற ஈர கறைகள்",
                "கறைகள் மேல்நோக்கி பரவி ஒழுங்கற்ற பழுப்பு நிற விளிம்புகளுடன் தோன்றும்"
            ),
            severity = "Stage 2: Moderate",
            culturalOrganic = "Wider planting spacing (20x15 cm) to improve air circulation. Avoid excessive nitrogen.",
            biological = "Soil application of Pseudomonas fluorescens @ 2.5 kg/ha mixed with 50 kg FYM.",
            chemicalTreatment = "Spray Hexaconazole 5% SC @ 2ml/Litre or Validamycin 3% L @ 2ml/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Deep summer ploughing to bury sclerotia."
        ),
        "bacterial leaf blight" to DiseaseInfo(
            englishName = "Rice Bacterial Leaf Blight (Xanthomonas oryzae pv. oryzae)",
            tamilName = "நெல் பாக்டீரியா இலை கருகல் நோய்",
            pathogen = "Vascular bacterial pathogen spread through irrigation water, typhoons, and wind-blown rain",
            symptomsEn = listOf(
                "Water-soaked to yellowish-white wavy stripes starting from leaf tips and margins",
                "Milky bacterial ooze droplets visible on infected leaves in early morning"
            ),
            symptomsTa = listOf(
                "இலை நுனியிலிருந்து தொடங்கும் அலை அலையான மஞ்சள் வெள்ளை கோடுகள்",
                "காலை நேரத்தில் இலைகளில் பால் போன்ற பாக்டீரியா துளிகள் காணப்படும்"
            ),
            severity = "Stage 3: Severe",
            culturalOrganic = "Drain excess water from field. Apply fresh cow dung extract supernatant (20%).",
            biological = "Foliar spray with Bacillus amyloliquefaciens @ 5ml/Litre.",
            chemicalTreatment = "Spray Streptocycline @ 0.1g/Litre + Copper Oxychloride 50% WP @ 2g/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Avoid clipping seedling tips during transplanting."
        )
    )

    private val TOMATO_DISEASES = mapOf(
        "early blight" to DiseaseInfo(
            englishName = "Tomato Early Blight (Alternaria solani)",
            tamilName = "தக்காளி ஆரம்பகால கருகல் நோய்",
            pathogen = "Fungal pathogen prevalent in humid warm climates with fluctuating rain",
            symptomsEn = listOf(
                "Dark brown circular spots with concentric target-board rings on lower foliage",
                "Yellow chlorotic halo surrounding necrotic spots causing leaf drop"
            ),
            symptomsTa = listOf(
                "கீழ் இலைகளில் வட்ட வடிவ அடர் பழுப்பு நிற இலக்கு போன்ற வளையப் புள்ளிகள்",
                "புள்ளிகளைச் சுற்றி மஞ்சள் வளையம் உருவாகி இலைகள் உதிரும்"
            ),
            severity = "Stage 1: Mild",
            culturalOrganic = "Prune infected bottom leaves. Mulch soil to prevent soil splash onto foliage.",
            biological = "Spray Trichoderma viride @ 5g/Litre or Neem seed kernel extract (NSKE 5%).",
            chemicalTreatment = "Spray Mancozeb 75% WP @ 2g/Litre or Chlorothalonil 75% WP @ 2g/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Crop rotation with non-solanaceous crops. Drip irrigation to minimize leaf wetness."
        ),
        "late blight" to DiseaseInfo(
            englishName = "Tomato Late Blight (Phytophthora infestans)",
            tamilName = "தக்காளி பிற்கால கருகல் நோய்",
            pathogen = "Destructive oomycete pathogen active in cool, foggy, water-saturated leaves",
            symptomsEn = listOf(
                "Rapidly expanding water-soaked greasy brown lesions on leaves and stems",
                "White cottony fungal growth on underside of leaves under humid conditions"
            ),
            symptomsTa = listOf(
                "இலை மற்றும் தண்டுகளில் வேகமாகப் பரவும் எண்ணெய் பசை போன்ற பழுப்பு கறைகள்",
                "அதிக ஈரப்பதத்தில் இலைகளின் அடிப்பகுதியில் வெள்ளை நிற பூஞ்சை வளர்ச்சி"
            ),
            severity = "Stage 3: Severe",
            culturalOrganic = "Immediately eradicate and bag severely blighted vines. Avoid overhead irrigation.",
            biological = "Preventive spray with Trichoderma harzianum @ 5g/Litre.",
            chemicalTreatment = "Spray Cymoxanil 8% + Mancozeb 64% WP @ 2g/Litre or Metalaxyl-M + Mancozeb @ 2.5g/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Plant certified resistant hybrids such as Arka Rakshak or Arka Abhed."
        ),
        "leaf curl" to DiseaseInfo(
            englishName = "Tomato Leaf Curl Virus (ToLCV)",
            tamilName = "தக்காளி இலை சுருட்டை வைரஸ் நோய்",
            pathogen = "Begomovirus transmitted exclusively by Whiteflies (Bemisia tabaci). Note: Viruses cannot be cured by fungicides/antibiotics.",
            symptomsEn = listOf(
                "Upward curling and puckering of leaf margins with thickened veins",
                "Severe stunting of bushes with bushy appearance and complete failure of fruit set"
            ),
            symptomsTa = listOf(
                "இலை விளிம்புகள் மேல்நோக்கி சுருண்டு தடிமனாதல்",
                "செடி வளர்ச்சி குன்றி புதர் போல் தோற்றமளித்தல் மற்றும் பூ பிடிப்பு நிற்றல்"
            ),
            severity = "Stage 2: Moderate Stunting",
            culturalOrganic = "Install yellow sticky traps (15/acre) to monitor whiteflies. Spray Neem oil (10,000 ppm) @ 2ml/Litre.",
            biological = "Release Chrysoperla carnea predators @ 10,000/ha.",
            chemicalTreatment = "Note: Chemicals cannot cure the virus; control whitefly vector: Spray Imidacloprid 17.8% SL @ 0.3ml/Litre or Acetamiprid 20% SP @ 0.2g/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Grow border crops like maize or sorghum as windbreaks/vector barriers."
        ),
        "spotted wilt" to DiseaseInfo(
            englishName = "Tomato Spotted Wilt Virus (TSWV / Groundnut Bud Necrosis)",
            tamilName = "தக்காளி புள்ளி வாடல் வைரஸ் நோய்",
            pathogen = "Tospovirus transmitted by Thrips (Frankliniella schultzei / Thrips palmi). Note: Viral pathogen.",
            symptomsEn = listOf(
                "Bronzing and purpling of terminal leaves with necrotic ring spots",
                "Terminal bud necrosis, wilting of top shoots, and chlorotic concentric rings on fruits"
            ),
            symptomsTa = listOf(
                "மேல் இலைகள் வெண்கல நிறமாக மாறி வளையப் புள்ளிகள் தோன்றுதல்",
                "நுனி மொட்டு காய்ந்து போதல் மற்றும் காய்களில் வளைய வடிவ புள்ளிகள்"
            ),
            severity = "Stage 3: Severe",
            culturalOrganic = "Uproot and bury infected plants immediately. Set up blue sticky traps (15/acre) for thrips.",
            biological = "Spray Lecanicillium lecanii @ 5g/Litre against thrips.",
            chemicalTreatment = "Note: Chemicals cannot cure virus; manage thrips vector: Spray Fipronil 5% SC @ 1.5ml/Litre or Spinetoram 11.7% SC @ 0.8ml/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Control weed hosts around field margins."
        )
    )

    private val CHILLI_DISEASES = mapOf(
        "leaf curl" to DiseaseInfo(
            englishName = "Chilli Leaf Curl Virus (Begomovirus)",
            tamilName = "மிளகாய் இலை சுருட்டை நோய்",
            pathogen = "Gemini virus transmitted by whiteflies and aggravated by thrips/mites infestation",
            symptomsEn = listOf(
                "Upward boat-shaped curling and puckering of leaf lamina",
                "Reduced leaf size, shortened internodes, and brittle foliage"
            ),
            symptomsTa = listOf(
                "இலைகள் படகு வடிவில் மேல்நோக்கி சுருண்டு கூடுதல்",
                "இலை அளவு குறைந்து கணுவிடை பகுதி சுருங்குதல்"
            ),
            severity = "Stage 2: Moderate",
            culturalOrganic = "Eradicate alternate weed hosts. Spray Agniastra or Neem seed kernel extract (NSKE 5%).",
            biological = "Spray Beauveria bassiana @ 5g/Litre.",
            chemicalTreatment = "Note: Vector control only: Spray Diafenthiuron 50% WP @ 1.2g/Litre or Cyantraniliprole 10.26% OD @ 1.2ml/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Raise nursery under 40-mesh nylon insect-proof net."
        ),
        "mosaic" to DiseaseInfo(
            englishName = "Chilli Mosaic Virus (Potyvirus / CMV)",
            tamilName = "மிளகாய் மொசைக் வைரஸ் நோய்",
            pathogen = "Plant virus transmitted by Aphids (Aphis gossypii / Myzus persicae)",
            symptomsEn = listOf(
                "Mottling with alternating dark and light green patches on leaves",
                "Filiform / shoe-string appearance of leaves with stunted canopy"
            ),
            symptomsTa = listOf(
                "இலைகளில் வெளிர் மற்றும் அடர் பச்சை நிற திட்டுகள் (மொசைக்)",
                "இலைகள் நூல் போல் சுருங்கி குறுகியதாக மாறுதல்"
            ),
            severity = "Stage 2: Moderate",
            culturalOrganic = "Intercrop with maize or cowpea as barrier crops. Spray 5% NSKE.",
            biological = "Spray Verticillium lecanii @ 5g/Litre against aphids.",
            chemicalTreatment = "Note: Vector control: Spray Dimethoate 30% EC @ 1.7ml/Litre or Thiamethoxam 25% WG @ 0.3g/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Use virus-free certified seedlings."
        ),
        "leaf spot" to DiseaseInfo(
            englishName = "Chilli Cercospora Leaf Spot & Anthracnose (Colletotrichum capsici)",
            tamilName = "மிளகாய் இலைப்புள்ளி மற்றும் பழ அழுகல் நோய்",
            pathogen = "Fungal pathogen causing fruit rot / die-back under high humidity and rains",
            symptomsEn = listOf(
                "Circular spots with light grey centers and dark brown margins on leaves",
                "Sunken circular necrotic patches on ripe chilli pods with black fruiting acervuli"
            ),
            symptomsTa = listOf(
                "சாம்பல் நிற மையமும் அடர் பழுப்பு விளிம்பும் கொண்ட இலைப்புள்ளிகள்",
                "பழுத்த மிளகாய் காய்களில் பள்ளமான கரும்புள்ளிகள் மற்றும் அழுகல்"
            ),
            severity = "Stage 2: Moderate",
            culturalOrganic = "Collect and burn infected fruit debris. Spray Pseudomonas fluorescens @ 10g/Litre.",
            biological = "Trichoderma viride seed treatment @ 4g/kg.",
            chemicalTreatment = "Spray Azoxystrobin 23% SC @ 1ml/Litre or Difenoconazole 25% EC @ 0.5ml/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Seed treatment with Thiram or Captan @ 2g/kg seed."
        )
    )

    private val BRINJAL_DISEASES = mapOf(
        "bacterial wilt" to DiseaseInfo(
            englishName = "Brinjal Bacterial Wilt (Ralstonia solanacearum)",
            tamilName = "கத்தரி பாக்டீரியா வாடல் நோய்",
            pathogen = "Soil-borne bacterium invading vascular bundles through root wounds",
            symptomsEn = listOf(
                "Rapid sudden wilting and collapse of entire green plant without prior yellowing",
                "Browning of vascular bundle; milky bacterial streaming when cut stem is placed in clear water"
            ),
            symptomsTa = listOf(
                "இலைகள் மஞ்சள் நிறமாக மாறாமல் திடீரென செடி முழுவதும் வாடுதல்",
                "தண்டின் உள்பகுதி பழுப்பு நிறமாதல்; வெட்டிய தண்டை தண்ணீரில் வைத்தால் வெள்ளை திரவம் வடிதல்"
            ),
            severity = "Stage 3: Severe",
            culturalOrganic = "Crop rotation with non-solanaceous crops (e.g. maize, paddy). Apply lime to acidic soil.",
            biological = "Soil drenching with Pseudomonas fluorescens @ 10g/Litre.",
            chemicalTreatment = "Soil drenching around root zone with Streptocycline @ 0.2g/Litre + Copper Oxychloride @ 2g/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Use resistant rootstocks or varieties like Pant Rituraj."
        ),
        "phomopsis" to DiseaseInfo(
            englishName = "Brinjal Phomopsis Blight & Fruit Rot (Phomopsis vexans)",
            tamilName = "கத்தரி போமோப்சிஸ் கருகல் மற்றும் காய் அழுகல் நோய்",
            pathogen = "Seed-borne and air-borne fungus prevalent in hot humid monsoon weather",
            symptomsEn = listOf(
                "Circular brown spots with pale centers on leaves and seedlings causing damping off",
                "Large watery sunken soft rot lesions on fruits covered with black pycnidia dots"
            ),
            symptomsTa = listOf(
                "இலைகளில் வெளிர் மையத்துடன் கூடிய வட்ட வடிவ பழுப்பு புள்ளிகள்",
                "காய்களில் நீர் ஊறிய பள்ளமான மென்மையான அழுகல் மற்றும் கருப்பு புள்ளிகள்"
            ),
            severity = "Stage 2: Moderate",
            culturalOrganic = "Destroy infected crop residue after harvest. Avoid flood irrigation.",
            biological = "Seed treatment with Trichoderma viride @ 4g/kg.",
            chemicalTreatment = "Spray Zineb 75% WP @ 2g/Litre or Mancozeb 75% WP @ 2.5g/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Hot water seed treatment at 50°C for 30 minutes."
        ),
        "little leaf" to DiseaseInfo(
            englishName = "Brinjal Little Leaf (Phytoplasma)",
            tamilName = "கத்தரி சிறு இலை நோய்",
            pathogen = "Phytoplasma vector transmitted by Leafhopper (Hishimonus phycitis)",
            symptomsEn = listOf(
                "Extreme reduction in leaf lamina size producing tiny crowded leaves with rosette bushy habit",
                "Floral parts phyllody turning into green leaf-like structures without fruiting"
            ),
            symptomsTa = listOf(
                "இலைகள் மிகச் சிறியதாக மாறி கொத்து கொத்தாக புதர் போல் தோற்றமளித்தல்",
                "பூக்கள் இலை போன்ற வடிவமாக மாறி காய் பிடிக்காமல் போதல்"
            ),
            severity = "Stage 2: Severe Stunting",
            culturalOrganic = "Rogue out and bury infected plants as soon as observed.",
            biological = "Neem oil spray @ 3ml/Litre.",
            chemicalTreatment = "Note: Phytoplasma has no direct chemical cure; manage leafhopper vector: Spray Dimethoate 30% EC @ 1.5ml/Litre or Monocrotophos 36% SL @ 1ml/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Control leafhoppers in nursery stage."
        )
    )

    private val GROUNDNUT_DISEASES = mapOf(
        "tikka" to DiseaseInfo(
            englishName = "Groundnut Tikka / Cercospora Leaf Spot (Cercospora arachidicola / C. personata)",
            tamilName = "நிலக்கடலை டிக்கா இலைப்புள்ளி நோய்",
            pathogen = "Air-borne and soil-borne fungal spores active during warm rainy spells",
            symptomsEn = listOf(
                "Early leaf spot: reddish-brown circular spots with prominent yellow halo on upper surface",
                "Late leaf spot: carbon-black circular spots without prominent halo mostly on lower leaf surface"
            ),
            symptomsTa = listOf(
                "ஆரம்ப இலைப்புள்ளி: மஞ்சள் வளையத்துடன் கூடிய செம்பழுப்பு நிற வட்ட வடிவ புள்ளிகள்",
                "பிற்கால இலைப்புள்ளி: மஞ்சள் வளையமில்லாத அடர் கருப்பு புள்ளிகள், இலை உதிர்தல்"
            ),
            severity = "Stage 2: Moderate",
            culturalOrganic = "Collect and burn crop trash. Spray 3% neem oil or 5% NSKE.",
            biological = "Foliar spray with Pseudomonas fluorescens @ 5g/Litre.",
            chemicalTreatment = "Spray Carbendazim 12% + Mancozeb 63% WP @ 2g/Litre or Tebuconazole 25.9% EC @ 1ml/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Crop rotation with sorghum, pearl millet, or maize."
        ),
        "rust" to DiseaseInfo(
            englishName = "Groundnut Rust (Puccinia arachidis)",
            tamilName = "நிலக்கடலை துரு நோய்",
            pathogen = "Fungal rust producing orange-brown pustules on lower leaf surface",
            symptomsEn = listOf(
                "Small, orange-brown pustules (uredinia) on lower epidermis of leaves",
                "Leaves curl, turn brown, and dry up prematurely while remaining attached to stem"
            ),
            symptomsTa = listOf(
                "இலைகளின் அடிப்பகுதியில் சிறிய ஆரஞ்சு-பழுப்பு நிற துரு கொப்புளங்கள்",
                "இலைகள் காய்ந்து பழுப்பு நிறமாக மாறி உதிராமல் செடியிலேயே ஒட்டியிருத்தல்"
            ),
            severity = "Stage 2: Moderate",
            culturalOrganic = "Intercrop groundnut with pearl millet or sorghum (4:1 ratio).",
            biological = "Spray Verticillium chlamydosporium @ 5g/Litre.",
            chemicalTreatment = "Spray Chlorothalonil 75% WP @ 2g/Litre or Hexaconazole 5% EC @ 1ml/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Early sowing before monsoon peak to avoid severe infection."
        ),
        "collar rot" to DiseaseInfo(
            englishName = "Groundnut Stem / Collar Rot (Sclerotium rolfsii / Aspergillus niger)",
            tamilName = "நிலக்கடலை தண்டு / கழுத்து அழுகல் நோய்",
            pathogen = "Soil-borne fungal pathogen attacking groundnut seedlings and collar region",
            symptomsEn = listOf(
                "Water-soaked brown lesion at collar region near soil line covered by white mycelial fan",
                "Mustard-seed-like brown sclerotia bodies on stem base and rapid wilting of branches"
            ),
            symptomsTa = listOf(
                "மண்ணை ஒட்டிய தண்டுப் பகுதியில் வெள்ளை நிற பூஞ்சை இழைகளுடன் கூடிய அழுகல்",
                "கடுகு போன்ற பழுப்பு நிற பூஞ்சை மணிகள் மற்றும் செடிகள் திடீரென வாடுதல்"
            ),
            severity = "Stage 3: Severe",
            culturalOrganic = "Deep summer ploughing to expose sclerotia. Apply Trichoderma enriched neem cake.",
            biological = "Soil application of Trichoderma viride @ 4 kg/ha mixed with 250 kg FYM.",
            chemicalTreatment = "Seed treatment with Carbendazim @ 2g/kg seed or soil drenching with Captan 50% WP @ 2g/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Ensure proper soil drainage and avoid deep sowing."
        )
    )

    private val COTTON_DISEASES = mapOf(
        "alternaria" to DiseaseInfo(
            englishName = "Cotton Alternaria Leaf Blight (Alternaria macrospora)",
            tamilName = "பருத்தி ஆல்டர்நேரியா இலைக்கருகல் நோய்",
            pathogen = "Air-borne and seed-borne fungal pathogen prevalent in humid rainy periods",
            symptomsEn = listOf(
                "Pale brown circular to irregular spots with concentric rings on leaves",
                "Spots coalesce forming large necrotic patches and shot-hole appearance"
            ),
            symptomsTa = listOf(
                "இலைகளில் வளையங்களுடன் கூடிய வெளிர் பழுப்பு வட்ட வடிவ புள்ளிகள்",
                "புள்ளிகள் இணைந்து பெரிய கருகல் மற்றும் இலைகளில் துளைகள் விழுதல்"
            ),
            severity = "Stage 2: Moderate",
            culturalOrganic = "Remove and burn crop residue after picking. Spray 5% NSKE.",
            biological = "Foliar spray with Pseudomonas fluorescens @ 5g/Litre.",
            chemicalTreatment = "Spray Mancozeb 75% WP @ 2g/Litre or Propiconazole 25% EC @ 1ml/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Acid delinting of cotton seeds before planting."
        ),
        "fusarium wilt" to DiseaseInfo(
            englishName = "Cotton Fusarium Wilt (Fusarium oxysporum f. sp. vasinfectum)",
            tamilName = "பருத்தி பியூசாரியம் வாடல் நோய்",
            pathogen = "Soil-borne fungus invading xylem vessels in black cotton soils",
            symptomsEn = listOf(
                "Yellowing and browning starting along leaf margins, followed by dropping of foliage",
                "Dark brown vascular discoloration inside split stem; plant wilts from base upward"
            ),
            symptomsTa = listOf(
                "இலை விளிம்புகளில் மஞ்சள் நிறம் தோன்றி உதிர்ந்து போதல்",
                "தண்டை பிளந்து பார்த்தால் உள்பகுதியில் கருமை நிற வாஸ்குலார் திசுக்கள் காணப்படுதல்"
            ),
            severity = "Stage 3: Severe",
            culturalOrganic = "Crop rotation with non-host crops like sorghum or bajra for 3 years.",
            biological = "Soil application of Trichoderma viride @ 5 kg/ha with FYM.",
            chemicalTreatment = "Seed treatment with Carboxin + Thiram @ 2.5g/kg seed; drench collar with Copper Oxychloride @ 3g/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Grow wilt-resistant cotton cultivars."
        ),
        "bacterial blight" to DiseaseInfo(
            englishName = "Cotton Bacterial Blight / Black Arm (Xanthomonas citri pv. malvacearum)",
            tamilName = "பருத்தி பாக்டீரியா இலைக்கருகல் / கருந்தண்டு நோய்",
            pathogen = "Seed-borne and rain-splashed bacterium causing angular spots and black arm symptoms",
            symptomsEn = listOf(
                "Water-soaked angular leaf spots delimited by leaf veinlets",
                "Elongated black lesions on petiole and stem (Black Arm), causing breaking of branches"
            ),
            symptomsTa = listOf(
                "நரம்புகளால் கட்டுப்படுத்தப்பட்ட கோண வடிவ நீர் ஊறிய புள்ளிகள்",
                "தண்டு மற்றும் இலைக்காம்பில் நீண்ட கருப்பு நிற புண்கள் (கருந்தண்டு)"
            ),
            severity = "Stage 2: Moderate",
            culturalOrganic = "Collect and burn plant debris. Early thinning of dense stands.",
            biological = "Seed treatment with Pseudomonas fluorescens @ 10g/kg.",
            chemicalTreatment = "Spray Streptocycline @ 0.1g/Litre + Copper Oxychloride 50% WP @ 2g/Litre.\n\n⚠️ $KVK_DISCLAIMER",
            prevention = "Seed delinting with concentrated Sulphuric acid (100ml/kg seed)."
        )
    )

    fun getDiagnosis(cropName: String, diseaseName: String, confidencePct: Double): DiagnosisResult {
        val cropKey = cropName.lowercase().trim()
        val diseaseKey = diseaseName.lowercase().trim()

        val info: DiseaseInfo = when {
            cropKey.contains("rice") || cropKey.contains("paddy") -> findDisease(RICE_DISEASES, diseaseKey, RICE_DISEASES["blast"]!!)
            cropKey.contains("tomato") -> findDisease(TOMATO_DISEASES, diseaseKey, TOMATO_DISEASES["early blight"]!!)
            cropKey.contains("chilli") || cropKey.contains("chili") -> findDisease(CHILLI_DISEASES, diseaseKey, CHILLI_DISEASES["leaf curl"]!!)
            cropKey.contains("brinjal") || cropKey.contains("eggplant") -> findDisease(BRINJAL_DISEASES, diseaseKey, BRINJAL_DISEASES["bacterial wilt"]!!)
            cropKey.contains("groundnut") || cropKey.contains("peanut") -> findDisease(GROUNDNUT_DISEASES, diseaseKey, GROUNDNUT_DISEASES["tikka"]!!)
            cropKey.contains("cotton") -> findDisease(COTTON_DISEASES, diseaseKey, COTTON_DISEASES["alternaria"]!!)
            else -> findDisease(TOMATO_DISEASES, diseaseKey, TOMATO_DISEASES["early blight"]!!)
        }

        return DiagnosisResult(
            cropName = cropName,
            diseaseName = info.englishName,
            diseaseNameTamil = info.tamilName,
            pathogen = info.pathogen,
            confidencePct = confidencePct,
            severityStage = info.severity,
            observedSymptoms = info.symptomsEn,
            observedSymptomsTamil = info.symptomsTa,
            culturalManagement = info.culturalOrganic,
            biologicalManagement = info.biological,
            chemicalTreatment = info.chemicalTreatment,
            organicTreatment = info.culturalOrganic,
            prevention = info.prevention,
            sourceReference = info.source,
            isSafe = false,
            lesionTag = "Verified ICAR/TNAU"
        )
    }

    private fun findDisease(map: Map<String, DiseaseInfo>, query: String, default: DiseaseInfo): DiseaseInfo {
        for ((key, value) in map) {
            if (query.contains(key) || key.contains(query)) {
                return value
            }
        }
        return default
    }
}
