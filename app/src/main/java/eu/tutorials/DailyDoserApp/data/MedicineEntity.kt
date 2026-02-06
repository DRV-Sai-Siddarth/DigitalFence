package eu.tutorials.DailyDoserApp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicines")
data class MedicineEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "medicine_name")
    val name: String = "",

    @ColumnInfo(name = "remaining_doses")
    val doses: Int = 1,

    @ColumnInfo(name = "is_taken_today")
    val isTaken: Boolean = false,

    @ColumnInfo(name = "added_on")
    val addedDate: Long = System.currentTimeMillis()
)