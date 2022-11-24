package com.jarroyo.swiperefresh.ui.navigation

sealed class Screens(val route: String) {
    object PullRefresh: Screens("pull_refresh_screen")
    object SwipeRefresh: Screens("swipe_refresh_screen")
}