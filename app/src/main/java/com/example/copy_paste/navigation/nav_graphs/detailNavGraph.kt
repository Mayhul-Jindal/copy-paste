package com.example.copy_paste.navigation.nav_graphs

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.copy_paste.data.Copied
import com.example.copy_paste.data.CopiedDao
import com.example.copy_paste.data.CopiedRepoImpl
import com.example.copy_paste.data.CopiedRepository
import com.example.copy_paste.navigation.DETAIL_ARGUMENT_KEY1
import com.example.copy_paste.navigation.DETAIL_ARGUMENT_KEY2
import com.example.copy_paste.navigation.DETAIL_GRAPH_ROUTE
import com.example.copy_paste.navigation.Screen
import com.example.copy_paste.screens.*

fun NavGraphBuilder.detailNavGraph(
    navController: NavHostController
){
    val uri = "https://example.com"
    navigation(
        route = DETAIL_GRAPH_ROUTE,
        startDestination = Screen.Detail.route,
    ){
        composable(
            route = Screen.Detail.route
        ){
            DetailScreen(navController)
        }
        composable(
            route = Screen.Detail2.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY1){
                    type = NavType.StringType
                    defaultValue = "No_Text_given"
                }
            ),
//            arguments = listOf(navArgument("copied_text")),
            deepLinks = listOf(navDeepLink { uriPattern =  "$uri/copied_text={copied_text}" })
        ){
//            Log.d("Args", it.arguments?.getInt(DETAIL_ARGUMENT_KEY1).toString())
//            Log.d("Args", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
            backStackEntry ->
            val arguments = backStackEntry.arguments
            arguments?.getString("copied_text")
                ?.let {
                    DetailScreen2(navController, copiedText = it)
                }
        }
    }
}