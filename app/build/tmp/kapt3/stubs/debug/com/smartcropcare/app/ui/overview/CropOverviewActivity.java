package com.smartcropcare.app.ui.overview;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/smartcropcare/app/ui/overview/CropOverviewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/smartcropcare/app/databinding/ActivityCropOverviewBinding;", "cropId", "", "viewModel", "Lcom/smartcropcare/app/ui/overview/CropOverviewViewModel;", "getViewModel", "()Lcom/smartcropcare/app/ui/overview/CropOverviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bindCropData", "", "crop", "Lcom/smartcropcare/app/data/local/entity/CropEntity;", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "renderStageTrack", "currentStageIndex", "", "setupClickListeners", "setupToolbar", "app_debug"})
public final class CropOverviewActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.smartcropcare.app.databinding.ActivityCropOverviewBinding binding;
    private long cropId = 1L;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public CropOverviewActivity() {
        super();
    }
    
    private final com.smartcropcare.app.ui.overview.CropOverviewViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void bindCropData(com.smartcropcare.app.data.local.entity.CropEntity crop) {
    }
    
    private final void renderStageTrack(int currentStageIndex) {
    }
}