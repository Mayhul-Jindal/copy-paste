package com.example.copy_paste.navigation.nav_graphs

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.copy_paste.navigation.DETAIL_ARGUMENT_KEY1
import com.example.copy_paste.navigation.DETAIL_ARGUMENT_KEY2
import com.example.copy_paste.navigation.HOME_GRAPH_ROUTE
import com.example.copy_paste.navigation.Screen
import com.example.copy_paste.screens.DetailScreen
import com.example.copy_paste.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
){
    navigation(
        route = HOME_GRAPH_ROUTE,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController)
        }
        detailNavGraph(navController)
    }
}

// detail
