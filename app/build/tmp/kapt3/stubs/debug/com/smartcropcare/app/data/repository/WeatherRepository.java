package com.smartcropcare.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/smartcropcare/app/data/repository/WeatherRepository;", "", "()V", "_currentWeather", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/smartcropcare/app/data/model/WeatherData;", "currentWeather", "Lkotlinx/coroutines/flow/Flow;", "getCurrentWeather", "()Lkotlinx/coroutines/flow/Flow;", "refreshWeatherTelemetry", "", "location", "", "app_debug"})
public final class WeatherRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.smartcropcare.app.data.model.WeatherData> _currentWeather = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.smartcropcare.app.data.model.WeatherData> currentWeather = null;
    
    public WeatherRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.smartcropcare.app.data.model.WeatherData> getCurrentWeather() {
        return null;
    }
    
    public final void refreshWeatherTelemetry(@org.jetbrains.annotations.NotNull()
    java.lang.String location) {
    }
}