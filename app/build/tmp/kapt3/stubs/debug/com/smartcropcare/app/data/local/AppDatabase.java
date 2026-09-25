package com.smartcropcare.app.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/smartcropcare/app/data/local/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "cropDao", "Lcom/smartcropcare/app/data/local/dao/CropDao;", "diseaseRecordDao", "Lcom/smartcropcare/app/data/local/dao/DiseaseRecordDao;", "expenseDao", "Lcom/smartcropcare/app/data/local/dao/ExpenseDao;", "farmActivityDao", "Lcom/smartcropcare/app/data/local/dao/FarmActivityDao;", "logDao", "Lcom/smartcropcare/app/data/local/dao/LogDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.smartcropcare.app.data.local.entity.CropEntity.class, com.smartcropcare.app.data.local.entity.FarmActivityEntity.class, com.smartcropcare.app.data.local.entity.IrrigationLogEntity.class, com.smartcropcare.app.data.local.entity.FertilizerLogEntity.class, com.smartcropcare.app.data.local.entity.DiseaseRecordEntity.class, com.smartcropcare.app.data.local.entity.ExpenseEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.smartcropcare.app.data.local.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.smartcropcare.app.data.local.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartcropcare.app.data.local.dao.CropDao cropDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartcropcare.app.data.local.dao.FarmActivityDao farmActivityDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartcropcare.app.data.local.dao.LogDao logDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartcropcare.app.data.local.dao.DiseaseRecordDao diseaseRecordDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartcropcare.app.data.local.dao.ExpenseDao expenseDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/smartcropcare/app/data/local/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/smartcropcare/app/data/local/AppDatabase;", "getDatabase", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "AppDatabaseCallback", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.smartcropcare.app.data.local.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        kotlinx.coroutines.CoroutineScope scope) {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0082@\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/smartcropcare/app/data/local/AppDatabase$Companion$AppDatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "populateInitialData", "database", "Lcom/smartcropcare/app/data/local/AppDatabase;", "(Lcom/smartcropcare/app/data/local/AppDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
        static final class AppDatabaseCallback extends androidx.room.RoomDatabase.Callback {
            @org.jetbrains.annotations.NotNull()
            private final kotlinx.coroutines.CoroutineScope scope = null;
            
            public AppDatabaseCallback(@org.jetbrains.annotations.NotNull()
            kotlinx.coroutines.CoroutineScope scope) {
                super();
            }
            
            @java.lang.Override()
            public void onCreate(@org.jetbrains.annotations.NotNull()
            androidx.sqlite.db.SupportSQLiteDatabase db) {
            }
            
            private final java.lang.Object populateInitialData(com.smartcropcare.app.data.local.AppDatabase database, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
                return null;
            }
        }
    }
}