package eu.tutorials.DailyDoserApp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDao {

    @Query("SELECT * FROM medicines ORDER BY is_taken_today ASC, medicine_name ASC")
    fun getAllMedicines(): Flow<List<MedicineEntity>>

    @Query("SELECT * FROM medicines WHERE id = :id")
    fun getMedicineById(id: Long): Flow<MedicineEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMedicine(medicine: MedicineEntity)

    @Update
    suspend fun updateMedicine(medicine: MedicineEntity)

    @Delete
    suspend fun deleteMedicine(medicine: MedicineEntity)
}