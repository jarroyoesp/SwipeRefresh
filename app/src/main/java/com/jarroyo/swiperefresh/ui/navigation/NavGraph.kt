package com.jarroyo.swiperefresh.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jarroyo.swiperefresh.ui.screens.SwipeRefreshScreen
import com.jarroyo.swiperefresh.ui.screens.PullRefreshScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.PullRefresh.route
    )
    {
        composable(route = Screens.PullRefresh.route) {
            PullRefreshScreen(navController)
        }
        composable(route = Screens.SwipeRefresh.route) {
            SwipeRefreshScreen(navController)
        }
    }
}