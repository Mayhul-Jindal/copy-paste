package com.example.copy_paste.navigation.nav_graphs

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.copy_paste.navigation.AUTH_GRAPH_ROUTE
import com.example.copy_paste.navigation.Screen
import com.example.copy_paste.screens.LoginScreen
import com.example.copy_paste.screens.LoginViewModel
import com.example.copy_paste.screens.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){
    navigation(
        route = AUTH_GRAPH_ROUTE,
        startDestination = Screen.Login.route
    ){
        composable(
            route = Screen.Login.route,

        ){
            val loginviewmodel = viewModel<LoginViewModel>()
            LoginScreen(navController, loginviewmodel)
        }
        composable(
            route = Screen.SignUp.route
        ){
            SignUpScreen(navController)
        }
    }
}