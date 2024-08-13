package com.vinodel.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vinodel.main.imp.presentation.MainScreen
import com.vinodel.splash.imp.presentation.SplashScreen

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun StartApplication(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = NavigationScreens.valueOf(
        backStackEntry?.destination?.route ?: NavigationScreens.SplashScreenNavigation.name
    )
    NavHost(
        navController = navController,
        startDestination = NavigationScreens.SplashScreenNavigation.name,
        modifier = Modifier
            .fillMaxSize()
    ) {
        composable(route = NavigationScreens.SplashScreenNavigation.name) {
            SplashScreen(
                mainScreen = {
                    navController.navigate(NavigationScreens.MainScreenNavigation.name)
                }
            )
        }
        composable(route = NavigationScreens.MainScreenNavigation.name) {
            MainScreen()
        }
    }
}

fun cancelOrderAndNavigateToStart(
    navController: NavHostController
) {
    navController.popBackStack(NavigationScreens.SplashScreenNavigation.name, inclusive = false)
}