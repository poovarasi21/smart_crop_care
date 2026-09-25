package com.smartcropcare.app.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/smartcropcare/app/data/local/dao/LogDao;", "", "getFertilizerDoseCount", "", "cropId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFertilizerLogs", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/smartcropcare/app/data/local/entity/FertilizerLogEntity;", "getIrrigationLogs", "Lcom/smartcropcare/app/data/local/entity/IrrigationLogEntity;", "getIrrigationSessionCount", "insertAllFertilizer", "", "logs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAllIrrigation", "insertFertilizerLog", "log", "(Lcom/smartcropcare/app/data/local/entity/FertilizerLogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertIrrigationLog", "(Lcom/smartcropcare/app/data/local/entity/IrrigationLogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface LogDao {
    
    @androidx.room.Query(value = "SELECT * FROM irrigation_logs WHERE cropId = :cropId ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.smartcropcare.app.data.local.entity.IrrigationLogEntity>> getIrrigationLogs(long cropId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertIrrigationLog(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.entity.IrrigationLogEntity log, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAllIrrigation(@org.jetbrains.annotations.NotNull()
    java.util.List<com.smartcropcare.app.data.local.entity.IrrigationLogEntity> logs, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM irrigation_logs WHERE cropId = :cropId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getIrrigationSessionCount(long cropId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM fertilizer_logs WHERE cropId = :cropId ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.smartcropcare.app.data.local.entity.FertilizerLogEntity>> getFertilizerLogs(long cropId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertFertilizerLog(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.entity.FertilizerLogEntity log, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAllFertilizer(@org.jetbrains.annotations.NotNull()
    java.util.List<com.smartcropcare.app.data.local.entity.FertilizerLogEntity> logs, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM fertilizer_logs WHERE cropId = :cropId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFertilizerDoseCount(long cropId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}