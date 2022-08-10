package com.example.copy_paste.navigation.nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.copy_paste.ViewModels.DetailScreenViewModel
import com.example.copy_paste.navigation.HOME_GRAPH_ROUTE
import com.example.copy_paste.navigation.ROOT_GRAPH_ROUTE

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    detailScreenViewModel: DetailScreenViewModel
){
    NavHost(navController = navController,
            startDestination = HOME_GRAPH_ROUTE,
            route = ROOT_GRAPH_ROUTE
    ){
        homeNavGraph(navController, detailScreenViewModel)
        authNavGraph(navController)
    }
}

// yeh home
//composable(
//route = Screen.Home.route
//){
//    HomeScreen(navConroller)
//}
//composable(
//route = Screen.Detail.route,
//arguments = listOf(
//navArgument(DETAIL_ARGUMENT_KEY1){
//    type = NavType.IntType
//    defaultValue = 0
//},
//navArgument(DETAIL_ARGUMENT_KEY2){
//    type = NavType.StringType
//    defaultValue = "No-Text_given"
//}
//)
//){
//    Log.d("Args", it.arguments?.getInt(DETAIL_ARGUMENT_KEY1).toString())
//    Log.d("Args", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
//    DetailScreen(navConroller)
//}

// yeh auth
//composable(
//route = Screen.Login.route
//){
//    LoginScreen(navConroller)
//}
//composable(
//route = Screen.SignUp.route
//){
//    SignUpScreen(navConroller)
//}