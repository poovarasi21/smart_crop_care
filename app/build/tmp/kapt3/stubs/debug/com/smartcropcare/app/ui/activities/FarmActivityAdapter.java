package com.smartcropcare.app.ui.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0011\u0012B\u001f\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\u00072\n\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/smartcropcare/app/ui/activities/FarmActivityAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/smartcropcare/app/data/local/entity/FarmActivityEntity;", "Lcom/smartcropcare/app/ui/activities/FarmActivityAdapter$ActivityViewHolder;", "onActivityToggled", "Lkotlin/Function2;", "", "", "(Lkotlin/jvm/functions/Function2;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ActivityViewHolder", "DiffCallback", "app_debug"})
public final class FarmActivityAdapter extends androidx.recyclerview.widget.ListAdapter<com.smartcropcare.app.data.local.entity.FarmActivityEntity, com.smartcropcare.app.ui.activities.FarmActivityAdapter.ActivityViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<com.smartcropcare.app.data.local.entity.FarmActivityEntity, java.lang.Boolean, kotlin.Unit> onActivityToggled = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.smartcropcare.app.ui.activities.FarmActivityAdapter.DiffCallback DiffCallback = null;
    
    public FarmActivityAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.smartcropcare.app.data.local.entity.FarmActivityEntity, ? super java.lang.Boolean, kotlin.Unit> onActivityToggled) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.smartcropcare.app.ui.activities.FarmActivityAdapter.ActivityViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.smartcropcare.app.ui.activities.FarmActivityAdapter.ActivityViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/smartcropcare/app/ui/activities/FarmActivityAdapter$ActivityViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smartcropcare/app/databinding/ItemFarmActivityBinding;", "(Lcom/smartcropcare/app/ui/activities/FarmActivityAdapter;Lcom/smartcropcare/app/databinding/ItemFarmActivityBinding;)V", "bind", "", "activity", "Lcom/smartcropcare/app/data/local/entity/FarmActivityEntity;", "app_debug"})
    public final class ActivityViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.smartcropcare.app.databinding.ItemFarmActivityBinding binding = null;
        
        public ActivityViewHolder(@org.jetbrains.annotations.NotNull()
        com.smartcropcare.app.databinding.ItemFarmActivityBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.smartcropcare.app.data.local.entity.FarmActivityEntity activity) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/smartcropcare/app/ui/activities/FarmActivityAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/smartcropcare/app/data/local/entity/FarmActivityEntity;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.smartcropcare.app.data.local.entity.FarmActivityEntity> {
        
        private DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.smartcropcare.app.data.local.entity.FarmActivityEntity oldItem, @org.jetbrains.annotations.NotNull()
        com.smartcropcare.app.data.local.entity.FarmActivityEntity newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.smartcropcare.app.data.local.entity.FarmActivityEntity oldItem, @org.jetbrains.annotations.NotNull()
        com.smartcropcare.app.data.local.entity.FarmActivityEntity newItem) {
            return false;
        }
    }
}