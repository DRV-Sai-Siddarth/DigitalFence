package eu.tutorials.DailyDoserApp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\tH\'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\f\u001a\u00020\rH\'J\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Leu/tutorials/DailyDoserApp/data/MedicineDao;", "", "addMedicine", "", "medicine", "Leu/tutorials/DailyDoserApp/data/MedicineEntity;", "(Leu/tutorials/DailyDoserApp/data/MedicineEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMedicine", "getAllMedicines", "Lkotlinx/coroutines/flow/Flow;", "", "getMedicineById", "id", "", "updateMedicine", "app_debug"})
@androidx.room.Dao
public abstract interface MedicineDao {
    
    @androidx.room.Query(value = "SELECT * FROM medicines ORDER BY is_taken_today ASC, medicine_name ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<eu.tutorials.DailyDoserApp.data.MedicineEntity>> getAllMedicines();
    
    @androidx.room.Query(value = "SELECT * FROM medicines WHERE id = :id")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<eu.tutorials.DailyDoserApp.data.MedicineEntity> getMedicineById(long id);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addMedicine(@org.jetbrains.annotations.NotNull
    eu.tutorials.DailyDoserApp.data.MedicineEntity medicine, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateMedicine(@org.jetbrains.annotations.NotNull
    eu.tutorials.DailyDoserApp.data.MedicineEntity medicine, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteMedicine(@org.jetbrains.annotations.NotNull
    eu.tutorials.DailyDoserApp.data.MedicineEntity medicine, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}