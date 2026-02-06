package eu.tutorials.DailyDoserApp


import android.content.Context
import androidx.room.Room
import eu.tutorials.DailyDoserApp.data.MedicineDatabase

object Graph {
    lateinit var database: MedicineDatabase

    val repository by lazy {
        MedicineRepository(medicineDao = database.medicineDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context,
            MedicineDatabase::class.java,
            "dailydoser.db"
        ).build()
    }
}