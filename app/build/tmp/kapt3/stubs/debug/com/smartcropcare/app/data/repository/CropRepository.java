package com.smartcropcare.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0019J.\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e2\u0006\u0010&\u001a\u00020\u0017J\u0018\u0010'\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010$J\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u000f0\u000e2\u0006\u0010\u001b\u001a\u00020\u0017J\u0016\u0010*\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010$J\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u000f0\u000e2\u0006\u0010\u001b\u001a\u00020\u0017J\u0016\u0010.\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010$J\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000f0\u000e2\u0006\u0010\u001b\u001a\u00020\u0017J\u0016\u00101\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u00102\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u00105J.\u00106\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u0010:J8\u0010;\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020+2\u0006\u00109\u001a\u00020\u001d2\b\b\u0002\u0010>\u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u0010?J\u001e\u0010@\u001a\u00020#2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010A\u001a\u00020BH\u0086@\u00a2\u0006\u0002\u0010CR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/smartcropcare/app/data/repository/CropRepository;", "", "cropDao", "Lcom/smartcropcare/app/data/local/dao/CropDao;", "activityDao", "Lcom/smartcropcare/app/data/local/dao/FarmActivityDao;", "logDao", "Lcom/smartcropcare/app/data/local/dao/LogDao;", "diseaseRecordDao", "Lcom/smartcropcare/app/data/local/dao/DiseaseRecordDao;", "expenseDao", "Lcom/smartcropcare/app/data/local/dao/ExpenseDao;", "(Lcom/smartcropcare/app/data/local/dao/CropDao;Lcom/smartcropcare/app/data/local/dao/FarmActivityDao;Lcom/smartcropcare/app/data/local/dao/LogDao;Lcom/smartcropcare/app/data/local/dao/DiseaseRecordDao;Lcom/smartcropcare/app/data/local/dao/ExpenseDao;)V", "allActiveCrops", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/smartcropcare/app/data/local/entity/CropEntity;", "getAllActiveCrops", "()Lkotlinx/coroutines/flow/Flow;", "allActivities", "Lcom/smartcropcare/app/data/local/entity/FarmActivityEntity;", "getAllActivities", "addActivity", "", "activity", "(Lcom/smartcropcare/app/data/local/entity/FarmActivityEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addExpense", "cropId", "category", "", "amount", "", "description", "(JLjava/lang/String;DLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "advanceStage", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCropById", "id", "getCropByIdDirect", "getExpenses", "Lcom/smartcropcare/app/data/local/entity/ExpenseEntity;", "getFertilizerCount", "", "getFertilizerLogs", "Lcom/smartcropcare/app/data/local/entity/FertilizerLogEntity;", "getIrrigationCount", "getIrrigationLogs", "Lcom/smartcropcare/app/data/local/entity/IrrigationLogEntity;", "getScanCount", "getTotalExpense", "insertCrop", "crop", "(Lcom/smartcropcare/app/data/local/entity/CropEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logFertilizer", "nutrient", "dosage", "method", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logIrrigation", "liters", "duration", "notes", "(JIILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateActivityStatus", "isCompleted", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CropRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.smartcropcare.app.data.local.dao.CropDao cropDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartcropcare.app.data.local.dao.FarmActivityDao activityDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartcropcare.app.data.local.dao.LogDao logDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartcropcare.app.data.local.dao.DiseaseRecordDao diseaseRecordDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartcropcare.app.data.local.dao.ExpenseDao expenseDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.smartcropcare.app.data.local.entity.CropEntity>> allActiveCrops = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.smartcropcare.app.data.local.entity.FarmActivityEntity>> allActivities = null;
    
    public CropRepository(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.dao.CropDao cropDao, @org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.dao.FarmActivityDao activityDao, @org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.dao.LogDao logDao, @org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.dao.DiseaseRecordDao diseaseRecordDao, @org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.dao.ExpenseDao expenseDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.smartcropcare.app.data.local.entity.CropEntity>> getAllActiveCrops() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.smartcropcare.app.data.local.entity.FarmActivityEntity>> getAllActivities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.smartcropcare.app.data.local.entity.CropEntity> getCropById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCropByIdDirect(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.smartcropcare.app.data.local.entity.CropEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertCrop(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.entity.CropEntity crop, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object advanceStage(long cropId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateActivityStatus(long id, boolean isCompleted, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addActivity(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.entity.FarmActivityEntity activity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.smartcropcare.app.data.local.entity.IrrigationLogEntity>> getIrrigationLogs(long cropId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object logIrrigation(long cropId, int liters, int duration, @org.jetbrains.annotations.NotNull()
    java.lang.String method, @org.jetbrains.annotations.NotNull()
    java.lang.String notes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.smartcropcare.app.data.local.entity.FertilizerLogEntity>> getFertilizerLogs(long cropId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object logFertilizer(long cropId, @org.jetbrains.annotations.NotNull()
    java.lang.String nutrient, @org.jetbrains.annotations.NotNull()
    java.lang.String dosage, @org.jetbrains.annotations.NotNull()
    java.lang.String method, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.smartcropcare.app.data.local.entity.ExpenseEntity>> getExpenses(long cropId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addExpense(long cropId, @org.jetbrains.annotations.NotNull()
    java.lang.String category, double amount, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTotalExpense(long cropId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getIrrigationCount(long cropId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFertilizerCount(long cropId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getScanCount(long cropId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
}