package eu.tutorials.DailyDoserApp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import eu.tutorials.DailyDoserApp.data.MedicineEntity

@Composable
fun MedicineCard(
    medicine: MedicineEntity,
    onClick: () -> Unit,
    onDelete: () -> Unit,
    onUpdate: (MedicineEntity) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (medicine.isTaken) Color(0xFFE8F5E9) else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = medicine.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (medicine.isTaken) "Status: Taken Today!!!" else "Status: Pending !!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (medicine.isTaken) Color(0xFF2E7D32) else Color(0xFFC62828)
                    )
                }
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Doses: ", style = MaterialTheme.typography.bodyMedium)

                    IconButton(
                        onClick = {
                            if (medicine.doses > 0) {
                                val newDose = medicine.doses - 1

                                val shouldBeTaken = if (newDose == 0) true else medicine.isTaken
                                onUpdate(medicine.copy(doses = newDose, isTaken = shouldBeTaken))
                            }
                        },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(Icons.Default.Remove, "Decrease")
                    }

                    Text(
                        text = "${medicine.doses}",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = MaterialTheme.typography.titleMedium
                    )

                    IconButton(
                        onClick = {

                            onUpdate(medicine.copy(doses = medicine.doses + 1))
                        },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(Icons.Default.Add, "Increase")
                    }
                }


                Button(
                    onClick = {
                        val newStatus = !medicine.isTaken
                        val newDose = if (newStatus) 0 else medicine.doses

                        onUpdate(medicine.copy(isTaken = newStatus, doses = newDose))
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (medicine.isTaken) Color.Gray else MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(if (medicine.isTaken) "Undo" else "Take")
                }
            }
        }
    }
}