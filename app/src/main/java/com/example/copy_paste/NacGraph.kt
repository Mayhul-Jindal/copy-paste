package com.example.copy_paste

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navConroller: NavHostController
){
    NavHost(navController = navConroller,
            startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navConroller)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY1){
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(DETAIL_ARGUMENT_KEY2){
                    type = NavType.StringType
                    defaultValue = "No-Text_given"
                }
            )
        ){
            Log.d("Args", it.arguments?.getInt(DETAIL_ARGUMENT_KEY1).toString())
            Log.d("Args", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
            DetailScreen(navConroller)
        }
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navConroller)
        }
        composable(
            route = Screen.SignUp.route
        ){
            SignUpScreen(navConroller)
        }
    }
}