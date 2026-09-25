package com.smartcropcare.app.data.local.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\bH\b\u0087\b\u0018\u00002\u00020\u0001B\u00f7\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020\u0010\u00a2\u0006\u0002\u0010#J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0005H\u00c6\u0003J\t\u0010F\u001a\u00020\u0010H\u00c6\u0003J\t\u0010G\u001a\u00020\u0010H\u00c6\u0003J\t\u0010H\u001a\u00020\u0005H\u00c6\u0003J\t\u0010I\u001a\u00020\u0010H\u00c6\u0003J\t\u0010J\u001a\u00020\u0010H\u00c6\u0003J\t\u0010K\u001a\u00020\u0005H\u00c6\u0003J\t\u0010L\u001a\u00020\u0010H\u00c6\u0003J\t\u0010M\u001a\u00020\u0005H\u00c6\u0003J\t\u0010N\u001a\u00020\u0005H\u00c6\u0003J\t\u0010O\u001a\u00020\u0005H\u00c6\u0003J\t\u0010P\u001a\u00020\u0010H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010S\u001a\u00020\u001dH\u00c6\u0003J\t\u0010T\u001a\u00020\u0005H\u00c6\u0003J\t\u0010U\u001a\u00020\fH\u00c6\u0003J\t\u0010V\u001a\u00020\fH\u00c6\u0003J\t\u0010W\u001a\u00020\fH\u00c6\u0003J\t\u0010X\u001a\u00020\u0010H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0005H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0005H\u00c6\u0003J\t\u0010[\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0005H\u00c6\u0003J\t\u0010]\u001a\u00020\u0005H\u00c6\u0003J\t\u0010^\u001a\u00020\fH\u00c6\u0003J\t\u0010_\u001a\u00020\u0005H\u00c6\u0003J\u00a3\u0002\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010a\u001a\u00020\u001d2\b\u0010b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010c\u001a\u00020\u0010H\u00d6\u0001J\t\u0010d\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u001e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010\u001f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0011\u0010\u0019\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0011\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0011\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u00106R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u0011\u0010!\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010'R\u0011\u0010\"\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0011\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010)R\u0011\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010'R\u0011\u0010 \u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010'R\u0011\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010'R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010'\u00a8\u0006e"}, d2 = {"Lcom/smartcropcare/app/data/local/entity/CropEntity;", "", "id", "", "name", "", "variety", "scientificName", "hybridType", "plotName", "zoneBed", "acreage", "", "soilType", "plantingDate", "cropAgeDays", "", "currentStageIndex", "stageName", "stageCompletionPct", "healthScore", "healthStatus", "cycleProgressPct", "waterStatus", "fertilizerStatus", "harvestCountdownDays", "imageResName", "imageUri", "isActive", "", "certificateId", "estimatedYieldTonPerAcre", "totalInvestment", "projectedRevenue", "soilMoisturePct", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;IILjava/lang/String;IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;DDDI)V", "getAcreage", "()D", "getCertificateId", "()Ljava/lang/String;", "getCropAgeDays", "()I", "getCurrentStageIndex", "getCycleProgressPct", "getEstimatedYieldTonPerAcre", "getFertilizerStatus", "getHarvestCountdownDays", "getHealthScore", "getHealthStatus", "getHybridType", "getId", "()J", "getImageResName", "getImageUri", "()Z", "getName", "getPlantingDate", "getPlotName", "getProjectedRevenue", "getScientificName", "getSoilMoisturePct", "getSoilType", "getStageCompletionPct", "getStageName", "getTotalInvestment", "getVariety", "getWaterStatus", "getZoneBed", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "crops")
public final class CropEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String variety = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scientificName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String hybridType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String plotName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String zoneBed = null;
    private final double acreage = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String soilType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String plantingDate = null;
    private final int cropAgeDays = 0;
    private final int currentStageIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String stageName = null;
    private final int stageCompletionPct = 0;
    private final int healthScore = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String healthStatus = null;
    private final int cycleProgressPct = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String waterStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String fertilizerStatus = null;
    private final int harvestCountdownDays = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String imageResName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String imageUri = null;
    private final boolean isActive = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String certificateId = null;
    private final double estimatedYieldTonPerAcre = 0.0;
    private final double totalInvestment = 0.0;
    private final double projectedRevenue = 0.0;
    private final int soilMoisturePct = 0;
    
    public CropEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String variety, @org.jetbrains.annotations.NotNull()
    java.lang.String scientificName, @org.jetbrains.annotations.NotNull()
    java.lang.String hybridType, @org.jetbrains.annotations.NotNull()
    java.lang.String plotName, @org.jetbrains.annotations.NotNull()
    java.lang.String zoneBed, double acreage, @org.jetbrains.annotations.NotNull()
    java.lang.String soilType, @org.jetbrains.annotations.NotNull()
    java.lang.String plantingDate, int cropAgeDays, int currentStageIndex, @org.jetbrains.annotations.NotNull()
    java.lang.String stageName, int stageCompletionPct, int healthScore, @org.jetbrains.annotations.NotNull()
    java.lang.String healthStatus, int cycleProgressPct, @org.jetbrains.annotations.NotNull()
    java.lang.String waterStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String fertilizerStatus, int harvestCountdownDays, @org.jetbrains.annotations.NotNull()
    java.lang.String imageResName, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUri, boolean isActive, @org.jetbrains.annotations.NotNull()
    java.lang.String certificateId, double estimatedYieldTonPerAcre, double totalInvestment, double projectedRevenue, int soilMoisturePct) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVariety() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScientificName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHybridType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlotName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getZoneBed() {
        return null;
    }
    
    public final double getAcreage() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSoilType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlantingDate() {
        return null;
    }
    
    public final int getCropAgeDays() {
        return 0;
    }
    
    public final int getCurrentStageIndex() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStageName() {
        return null;
    }
    
    public final int getStageCompletionPct() {
        return 0;
    }
    
    public final int getHealthScore() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHealthStatus() {
        return null;
    }
    
    public final int getCycleProgressPct() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWaterStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFertilizerStatus() {
        return null;
    }
    
    public final int getHarvestCountdownDays() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImageResName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImageUri() {
        return null;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCertificateId() {
        return null;
    }
    
    public final double getEstimatedYieldTonPerAcre() {
        return 0.0;
    }
    
    public final double getTotalInvestment() {
        return 0.0;
    }
    
    public final double getProjectedRevenue() {
        return 0.0;
    }
    
    public final int getSoilMoisturePct() {
        return 0;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    public final int component14() {
        return 0;
    }
    
    public final int component15() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    public final int component17() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component20() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component22() {
        return null;
    }
    
    public final boolean component23() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component24() {
        return null;
    }
    
    public final double component25() {
        return 0.0;
    }
    
    public final double component26() {
        return 0.0;
    }
    
    public final double component27() {
        return 0.0;
    }
    
    public final int component28() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcropcare.app.data.local.entity.CropEntity copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String variety, @org.jetbrains.annotations.NotNull()
    java.lang.String scientificName, @org.jetbrains.annotations.NotNull()
    java.lang.String hybridType, @org.jetbrains.annotations.NotNull()
    java.lang.String plotName, @org.jetbrains.annotations.NotNull()
    java.lang.String zoneBed, double acreage, @org.jetbrains.annotations.NotNull()
    java.lang.String soilType, @org.jetbrains.annotations.NotNull()
    java.lang.String plantingDate, int cropAgeDays, int currentStageIndex, @org.jetbrains.annotations.NotNull()
    java.lang.String stageName, int stageCompletionPct, int healthScore, @org.jetbrains.annotations.NotNull()
    java.lang.String healthStatus, int cycleProgressPct, @org.jetbrains.annotations.NotNull()
    java.lang.String waterStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String fertilizerStatus, int harvestCountdownDays, @org.jetbrains.annotations.NotNull()
    java.lang.String imageResName, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUri, boolean isActive, @org.jetbrains.annotations.NotNull()
    java.lang.String certificateId, double estimatedYieldTonPerAcre, double totalInvestment, double projectedRevenue, int soilMoisturePct) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}