package eu.tutorials.DailyDoserApp


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MedicineViewModel
) {
    val medicines by viewModel.medicineList.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Daily Doser",
                onBackClicked = {},
                showBackButton = false
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddEdit.route + "/0") },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Medicine", tint = Color.White)
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        if (medicines.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No medicines added yet.\nTap + to track your meds!",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(medicines, key = { it.id }) { med ->
                    MedicineCard(
                        medicine = med,
                        onClick = { navController.navigate(Screen.AddEdit.route + "/${med.id}") },
                        onDelete = {
                            viewModel.deleteMedicine(med)
                            scope.launch {
                                val result = snackbarHostState.showSnackbar(
                                    message = "${med.name} deleted",
                                    actionLabel = "Undo"
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    viewModel.addMedicine(med)
                                }
                            }
                        },
                        onUpdate = { updatedMed ->
                            viewModel.updateMedicine(updatedMed)
                        }
                    )
                }
            }
        }
    }
}