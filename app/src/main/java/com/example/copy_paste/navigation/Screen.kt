package com.example.copy_paste.navigation

const val DETAIL_ARGUMENT_KEY1 = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

const val ROOT_GRAPH_ROUTE = "root"
const val AUTH_GRAPH_ROUTE = "auth"
const val HOME_GRAPH_ROUTE = "home"
const val DETAIL_GRAPH_ROUTE = "detail"

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Login: Screen(route = "login_screen")
    object SignUp: Screen(route = "signup_screen")
    object Detail: Screen(route = "detail_screen")
    object Detail2: Screen(route = "detail2_screen?id={id}&name={name}"){
        fun passInfo(id: Int = 0, name: String = "No_text_given"): String{
            return "detail2_screen?id=$id&name=$name"
        }
    }
}
