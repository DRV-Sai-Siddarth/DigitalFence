package eu.tutorials.DailyDoserApp


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddEdit : Screen("add_edit")
}

@Composable
fun AppNavigation(
    viewModel: MedicineViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController, viewModel)
        }

        composable(
            route = Screen.AddEdit.route + "/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.LongType
                defaultValue = 0L
            })
        ) { entry ->
            val id = entry.arguments?.getLong("id") ?: 0L
            AddMedicineScreen(id = id, navController = navController, viewModel = viewModel)
        }
    }
}