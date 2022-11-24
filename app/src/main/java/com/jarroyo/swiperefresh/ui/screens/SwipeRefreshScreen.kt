package com.jarroyo.swiperefresh.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeRefreshScreen(navController: NavController) {

    var itemCount by remember { mutableStateOf(1) }
    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)

    fun refresh() = refreshScope.launch {
        swipeRefreshState.isRefreshing = true
        delay(5)
        swipeRefreshState.isRefreshing = false

    }

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { refresh() }
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Text("Detail Screen")
            }
            if (!swipeRefreshState.isRefreshing) {
                items(itemCount) {
                    ListItem { Text(text = "Item ${itemCount - it}") }
                }
            }
        }
    }
}