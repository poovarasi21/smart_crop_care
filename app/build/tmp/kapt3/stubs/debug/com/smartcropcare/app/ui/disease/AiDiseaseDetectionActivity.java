package com.smartcropcare.app.ui.disease;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0013H\u0014J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/smartcropcare/app/ui/disease/AiDiseaseDetectionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/smartcropcare/app/databinding/ActivityAiDiseaseDetectionBinding;", "laserAnimator", "Landroid/animation/ObjectAnimator;", "pickImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "takePhotoLauncher", "Landroid/content/Intent;", "viewModel", "Lcom/smartcropcare/app/ui/disease/DiseaseDetectionViewModel;", "getViewModel", "()Lcom/smartcropcare/app/ui/disease/DiseaseDetectionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bindDiagnosisResult", "", "result", "Lcom/smartcropcare/app/data/model/DiagnosisResult;", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupCaptureButtons", "setupCropChips", "setupToolbar", "startLaserScanAnimation", "app_debug"})
public final class AiDiseaseDetectionActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.smartcropcare.app.databinding.ActivityAiDiseaseDetectionBinding binding;
    @org.jetbrains.annotations.Nullable()
    private android.animation.ObjectAnimator laserAnimator;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> takePhotoLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> pickImageLauncher = null;
    
    public AiDiseaseDetectionActivity() {
        super();
    }
    
    private final com.smartcropcare.app.ui.disease.DiseaseDetectionViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupCropChips() {
    }
    
    private final void setupCaptureButtons() {
    }
    
    private final void startLaserScanAnimation() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void bindDiagnosisResult(com.smartcropcare.app.data.model.DiagnosisResult result) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}