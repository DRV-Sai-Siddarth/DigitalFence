package eu.tutorials.DailyDoserApp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Leu/tutorials/DailyDoserApp/MedicineViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Leu/tutorials/DailyDoserApp/MedicineRepository;", "(Leu/tutorials/DailyDoserApp/MedicineRepository;)V", "medicineList", "Lkotlinx/coroutines/flow/StateFlow;", "", "Leu/tutorials/DailyDoserApp/data/MedicineEntity;", "getMedicineList", "()Lkotlinx/coroutines/flow/StateFlow;", "addMedicine", "", "medicine", "deleteMedicine", "getMedicineById", "Lkotlinx/coroutines/flow/Flow;", "id", "", "updateMedicine", "app_debug"})
public final class MedicineViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final eu.tutorials.DailyDoserApp.MedicineRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<eu.tutorials.DailyDoserApp.data.MedicineEntity>> medicineList = null;
    
    public MedicineViewModel(@org.jetbrains.annotations.NotNull
    eu.tutorials.DailyDoserApp.MedicineRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<eu.tutorials.DailyDoserApp.data.MedicineEntity>> getMedicineList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<eu.tutorials.DailyDoserApp.data.MedicineEntity> getMedicineById(long id) {
        return null;
    }
    
    public final void addMedicine(@org.jetbrains.annotations.NotNull
    eu.tutorials.DailyDoserApp.data.MedicineEntity medicine) {
    }
    
    public final void updateMedicine(@org.jetbrains.annotations.NotNull
    eu.tutorials.DailyDoserApp.data.MedicineEntity medicine) {
    }
    
    public final void deleteMedicine(@org.jetbrains.annotations.NotNull
    eu.tutorials.DailyDoserApp.data.MedicineEntity medicine) {
    }
    
    public MedicineViewModel() {
        super();
    }
}