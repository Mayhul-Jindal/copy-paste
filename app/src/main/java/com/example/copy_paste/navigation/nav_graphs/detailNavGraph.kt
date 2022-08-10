package com.example.copy_paste.navigation.nav_graphs

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.copy_paste.ViewModels.DetailScreenViewModel
import com.example.copy_paste.data.CopiedRepository
import com.example.copy_paste.navigation.DETAIL_ARGUMENT_KEY1
import com.example.copy_paste.navigation.DETAIL_GRAPH_ROUTE
import com.example.copy_paste.navigation.Screen
import com.example.copy_paste.screens.*
import dagger.hilt.android.AndroidEntryPoint

fun NavGraphBuilder.detailNavGraph(
    navController: NavHostController,
    detailScreenViewModel: DetailScreenViewModel
){
    val uri = "https://example.com"
    navigation(
        route = DETAIL_GRAPH_ROUTE,
        startDestination = Screen.Detail.route,
    ){
        composable(
            route = Screen.Detail.route
        ){
            DetailScreen(navController, detailScreenViewModel)
        }
        composable(
            route = Screen.Detail2.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY1){
                    type = NavType.StringType
                    defaultValue = "N"
                }
            ),
//            arguments = listOf(navArgument("copied_text")),
            deepLinks = listOf(navDeepLink { uriPattern =  "$uri/copied_text={copied_text}" })
        ){
//            Log.d("Args", it.arguments?.getString(DETAIL_ARGUMENT_KEY1).toString())
            backStackEntry ->
            val arguments = backStackEntry.arguments
            arguments?.getString(DETAIL_ARGUMENT_KEY1)
                ?.let {
                    DetailScreen2(navController, copiedText = it)
                }
        }
    }
}