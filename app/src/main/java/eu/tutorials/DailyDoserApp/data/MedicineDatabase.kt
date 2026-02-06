package eu.tutorials.DailyDoserApp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MedicineEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MedicineDatabase : RoomDatabase() {
    abstract fun medicineDao(): MedicineDao
}