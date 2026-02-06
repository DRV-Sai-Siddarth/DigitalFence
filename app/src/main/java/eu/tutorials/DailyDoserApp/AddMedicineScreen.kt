package eu.tutorials.DailyDoserApp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import eu.tutorials.DailyDoserApp.data.MedicineEntity
import kotlinx.coroutines.launch

@Composable
fun AddMedicineScreen(
    id: Long,
    navController: NavController,
    viewModel: MedicineViewModel
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState= remember { SnackbarHostState() }

    var name by remember { mutableStateOf("") }
    var doses by remember { mutableStateOf("1") }
    var isTaken by remember { mutableStateOf(false) }

    LaunchedEffect(id) {
        if (id != 0L) {
            viewModel.getMedicineById(id).collect { med ->
                name= med.name
                doses= med.doses.toString()
                isTaken= med.isTaken
            }
        }
    }

    Scaffold(
        topBar= {
            AppTopBar(
                title= if (id!= 0L) "Edit Medicine" else "Add Medicine",
                onBackClicked = { navController.navigateUp() }
            )
        },
        snackbarHost= { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier= Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value= name,
                onValueChange= { name = it },
                label= { Text("Medicine Name") },
                modifier= Modifier.fillMaxWidth(),
                singleLine= true
            )

            Spacer(modifier= Modifier.height(16.dp))

            OutlinedTextField(
                value= doses,
                onValueChange= {
                    if (it.all { char -> char.isDigit() }) {
                        doses= it
                    }
                },
                label = { Text("Remaining Doses") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = isTaken, onCheckedChange = { isChecked ->
                    isTaken = isChecked
                    if(isChecked) {
                        doses = "0"
                    }
                })
                Text("Dose taken today?")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (name.isNotBlank() && doses.isNotBlank()) {
                        val finalDoses = doses.toIntOrNull() ?: 0

                        val finalIsTaken = if (finalDoses == 0) true else isTaken
                        val adjustedDoses = if (finalIsTaken) 0 else finalDoses

                        val medicine = MedicineEntity(
                            id= if (id != 0L) id else 0L,
                            name= name.trim(),
                            doses= adjustedDoses,
                            isTaken= finalIsTaken,
                            addedDate= System.currentTimeMillis()
                        )

                        if (id != 0L) viewModel.updateMedicine(medicine)
                        else viewModel.addMedicine(medicine)

                        navController.navigateUp()
                    } else {
                        scope.launch {
                            snackbarHostState.showSnackbar("Enter Vaild one")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (id != 0L) "Update Medicine" else "Save Medicine")
            }
        }
    }
}