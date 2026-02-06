package eu.tutorials.DailyDoserApp


import eu.tutorials.DailyDoserApp.data.MedicineDao
import eu.tutorials.DailyDoserApp.data.MedicineEntity
import kotlinx.coroutines.flow.Flow

class MedicineRepository(private val medicineDao: MedicineDao) {
    val allMedicines: Flow<List<MedicineEntity>> = medicineDao.getAllMedicines()

    fun getMedicineById(id: Long): Flow<MedicineEntity> = medicineDao.getMedicineById(id)

    suspend fun add(medicine: MedicineEntity) = medicineDao.addMedicine(medicine)
    suspend fun update(medicine: MedicineEntity) = medicineDao.updateMedicine(medicine)
    suspend fun delete(medicine: MedicineEntity) = medicineDao.deleteMedicine(medicine)
}