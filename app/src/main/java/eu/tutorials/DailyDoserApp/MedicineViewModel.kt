package eu.tutorials.DailyDoserApp


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.DailyDoserApp.data.MedicineEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MedicineViewModel(
    private val repository: MedicineRepository = Graph.repository
) : ViewModel() {

    val medicineList: StateFlow<List<MedicineEntity>> = repository.allMedicines
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun getMedicineById(id: Long): Flow<MedicineEntity> {
        return repository.getMedicineById(id)
    }

    fun addMedicine(medicine: MedicineEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.add(medicine)
        }
    }

    fun updateMedicine(medicine: MedicineEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(medicine)
        }
    }

    fun deleteMedicine(medicine: MedicineEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(medicine)
        }
    }
}