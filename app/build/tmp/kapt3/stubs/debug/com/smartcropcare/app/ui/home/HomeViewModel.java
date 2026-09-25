package com.smartcropcare.app.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nJ\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/smartcropcare/app/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "cropRepository", "Lcom/smartcropcare/app/data/repository/CropRepository;", "weatherRepository", "Lcom/smartcropcare/app/data/repository/WeatherRepository;", "(Lcom/smartcropcare/app/data/repository/CropRepository;Lcom/smartcropcare/app/data/repository/WeatherRepository;)V", "activeCrops", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/smartcropcare/app/data/local/entity/CropEntity;", "getActiveCrops", "()Lkotlinx/coroutines/flow/StateFlow;", "activities", "Lcom/smartcropcare/app/data/local/entity/FarmActivityEntity;", "getActivities", "weather", "Lcom/smartcropcare/app/data/model/WeatherData;", "getWeather", "addNewCrop", "", "crop", "toggleActivity", "id", "", "isCompleted", "", "Factory", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.smartcropcare.app.data.repository.CropRepository cropRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartcropcare.app.data.repository.WeatherRepository weatherRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcropcare.app.data.local.entity.CropEntity>> activeCrops = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcropcare.app.data.local.entity.FarmActivityEntity>> activities = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.smartcropcare.app.data.model.WeatherData> weather = null;
    
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.repository.CropRepository cropRepository, @org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.repository.WeatherRepository weatherRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcropcare.app.data.local.entity.CropEntity>> getActiveCrops() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcropcare.app.data.local.entity.FarmActivityEntity>> getActivities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.smartcropcare.app.data.model.WeatherData> getWeather() {
        return null;
    }
    
    public final void toggleActivity(long id, boolean isCompleted) {
    }
    
    public final void addNewCrop(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.data.local.entity.CropEntity crop) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/smartcropcare/app/ui/home/HomeViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "cropRepository", "Lcom/smartcropcare/app/data/repository/CropRepository;", "weatherRepository", "Lcom/smartcropcare/app/data/repository/WeatherRepository;", "(Lcom/smartcropcare/app/data/repository/CropRepository;Lcom/smartcropcare/app/data/repository/WeatherRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final com.smartcropcare.app.data.repository.CropRepository cropRepository = null;
        @org.jetbrains.annotations.NotNull()
        private final com.smartcropcare.app.data.repository.WeatherRepository weatherRepository = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.smartcropcare.app.data.repository.CropRepository cropRepository, @org.jetbrains.annotations.NotNull()
        com.smartcropcare.app.data.repository.WeatherRepository weatherRepository) {
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