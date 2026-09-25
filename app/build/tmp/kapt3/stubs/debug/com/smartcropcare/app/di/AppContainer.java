package com.smartcropcare.app.di;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/smartcropcare/app/di/AppContainer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "cropRepository", "Lcom/smartcropcare/app/data/repository/CropRepository;", "getCropRepository", "()Lcom/smartcropcare/app/data/repository/CropRepository;", "cropRepository$delegate", "Lkotlin/Lazy;", "database", "Lcom/smartcropcare/app/data/local/AppDatabase;", "getDatabase", "()Lcom/smartcropcare/app/data/local/AppDatabase;", "diseaseDetectionRepository", "Lcom/smartcropcare/app/data/repository/DiseaseDetectionRepository;", "getDiseaseDetectionRepository", "()Lcom/smartcropcare/app/data/repository/DiseaseDetectionRepository;", "diseaseDetectionRepository$delegate", "weatherRepository", "Lcom/smartcropcare/app/data/repository/WeatherRepository;", "getWeatherRepository", "()Lcom/smartcropcare/app/data/repository/WeatherRepository;", "weatherRepository$delegate", "app_debug"})
public final class AppContainer {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartcropcare.app.data.local.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy cropRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy weatherRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy diseaseDetectionRepository$delegate = null;
    
    public AppContainer(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcropcare.app.data.local.AppDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcropcare.app.data.repository.CropRepository getCropRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcropcare.app.data.repository.WeatherRepository getWeatherRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcropcare.app.data.repository.DiseaseDetectionRepository getDiseaseDetectionRepository() {
        return null;
    }
}