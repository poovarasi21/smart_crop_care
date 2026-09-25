package com.smartcropcare.app.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH'J\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\b2\u0006\u0010\u000b\u001a\u00020\fH'J\u0018\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J&\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u001dJ6\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010#\u00a8\u0006$"}, d2 = {"Lcom/smartcropcare/app/data/local/dao/CropDao;", "", "deleteCrop", "", "crop", "Lcom/smartcropcare/app/data/local/entity/CropEntity;", "(Lcom/smartcropcare/app/data/local/entity/CropEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveCrops", "Lkotlinx/coroutines/flow/Flow;", "", "getCropById", "id", "", "getCropByIdDirect", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "crops", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCrop", "updateCrop", "updateHealth", "cropId", "healthScore", "", "healthStatus", "", "(JILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMoisture", "moisturePct", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStage", "stageIndex", "stageName", "completionPct", "daysToHarvest", "(JILjava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface CropDao {
    
    @androidx.room.Query(value = "SELECT * FROM crops WHERE isActive = 1 ORDER BY id ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.smartcropcare.app.data.local.entity.CropEntity>> getAllActiveCrops();
    
    @androidx.room.Query(value = "SELECT * FROM crops WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.smartcropcare.app.data.local.entity.CropEntity> getCropById(long id);
    
    @androidx.room.Query(value = "SELECT * FROM crops WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCropByIdDirect(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.smartcropcare.app.data.local.entity.CropEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCrop(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.entity.CropEntity crop, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.smartcropcare.app.data.local.entity.CropEntity> crops, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateCrop(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.entity.CropEntity crop, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteCrop(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.entity.CropEntity crop, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE crops SET currentStageIndex = :stageIndex, stageName = :stageName, stageCompletionPct = :completionPct, harvestCountdownDays = :daysToHarvest WHERE id = :cropId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateStage(long cropId, int stageIndex, @org.jetbrains.annotations.NotNull()
    java.lang.String stageName, int completionPct, int daysToHarvest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE crops SET healthScore = :healthScore, healthStatus = :healthStatus WHERE id = :cropId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateHealth(long cropId, int healthScore, @org.jetbrains.annotations.NotNull()
    java.lang.String healthStatus, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE crops SET soilMoisturePct = :moisturePct WHERE id = :cropId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateMoisture(long cropId, int moisturePct, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}