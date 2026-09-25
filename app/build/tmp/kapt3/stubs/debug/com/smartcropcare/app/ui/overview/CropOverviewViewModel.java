package com.smartcropcare.app.ui.overview;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001&B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0017J\u001e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0019J\u001e\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0019R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\r0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b\u00a8\u0006'"}, d2 = {"Lcom/smartcropcare/app/ui/overview/CropOverviewViewModel;", "Landroidx/lifecycle/ViewModel;", "cropRepository", "Lcom/smartcropcare/app/data/repository/CropRepository;", "cropId", "", "(Lcom/smartcropcare/app/data/repository/CropRepository;J)V", "crop", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/smartcropcare/app/data/local/entity/CropEntity;", "getCrop", "()Lkotlinx/coroutines/flow/StateFlow;", "expenses", "", "Lcom/smartcropcare/app/data/local/entity/ExpenseEntity;", "getExpenses", "fertilizerLogs", "Lcom/smartcropcare/app/data/local/entity/FertilizerLogEntity;", "getFertilizerLogs", "irrigationLogs", "Lcom/smartcropcare/app/data/local/entity/IrrigationLogEntity;", "getIrrigationLogs", "addExpense", "", "category", "", "amount", "", "desc", "advanceStage", "logFertilizer", "nutrient", "dosage", "method", "logIrrigation", "liters", "", "duration", "Factory", "app_debug"})
public final class CropOverviewViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.smartcropcare.app.data.repository.CropRepository cropRepository = null;
    private final long cropId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.smartcropcare.app.data.local.entity.CropEntity> crop = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcropcare.app.data.local.entity.IrrigationLogEntity>> irrigationLogs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcropcare.app.data.local.entity.FertilizerLogEntity>> fertilizerLogs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcropcare.app.data.local.entity.ExpenseEntity>> expenses = null;
    
    public CropOverviewViewModel(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.repository.CropRepository cropRepository, long cropId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.smartcropcare.app.data.local.entity.CropEntity> getCrop() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcropcare.app.data.local.entity.IrrigationLogEntity>> getIrrigationLogs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcropcare.app.data.local.entity.FertilizerLogEntity>> getFertilizerLogs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcropcare.app.data.local.entity.ExpenseEntity>> getExpenses() {
        return null;
    }
    
    public final void advanceStage() {
    }
    
    public final void logIrrigation(int liters, int duration, @org.jetbrains.annotations.NotNull()
    java.lang.String method) {
    }
    
    public final void logFertilizer(@org.jetbrains.annotations.NotNull()
    java.lang.String nutrient, @org.jetbrains.annotations.NotNull()
    java.lang.String dosage, @org.jetbrains.annotations.NotNull()
    java.lang.String method) {
    }
    
    public final void addExpense(@org.jetbrains.annotations.NotNull()
    java.lang.String category, double amount, @org.jetbrains.annotations.NotNull()
    java.lang.String desc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/smartcropcare/app/ui/overview/CropOverviewViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "cropRepository", "Lcom/smartcropcare/app/data/repository/CropRepository;", "cropId", "", "(Lcom/smartcropcare/app/data/repository/CropRepository;J)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final com.smartcropcare.app.data.repository.CropRepository cropRepository = null;
        private final long cropId = 0L;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.smartcropcare.app.data.repository.CropRepository cropRepository, long cropId) {
            super();
        }
        
        @java.lang.Override()
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        @org.jetbrains.annotations.NotNull()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}