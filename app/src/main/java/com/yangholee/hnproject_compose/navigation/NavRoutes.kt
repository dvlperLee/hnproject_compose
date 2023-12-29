package com.yangholee.hnproject_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yangholee.hnproject_compose.feature.importAndExport.history.HistoryScreen
import com.yangholee.hnproject_compose.login.LoginScreen
import com.yangholee.hnproject_compose.main.MainScreen

sealed class NavRoutes(val route: String) {
    object login : NavRoutes("login")
    object main : NavRoutes("main")
    object import : NavRoutes("import")
    object mgmt : NavRoutes("mgmt")
    object history : NavRoutes("history")

}
@Composable
fun hnNavHost(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.login.route,
    ) {
        composable(NavRoutes.login.route) {
            LoginScreen(navController = navController)
        }

        composable(NavRoutes.main.route) {
            MainScreen(navController = navController)
        }

        composable(NavRoutes.import.route) {
            MainScreen(navController = navController)
        }

        composable(NavRoutes.history.route) {
            HistoryScreen(navController = navController)
        }
    }
}