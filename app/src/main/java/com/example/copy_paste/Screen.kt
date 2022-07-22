package com.example.copy_paste

const val DETAIL_ARGUMENT_KEY1 = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Detail:
        Screen(route = "detail_screen?id={id}&name={name}"){
        fun passInfo(id: Int = 0, name: String = "No_text_given"): String{
            return "detail_screen?id=$id&name=$name"
        }
    }
    object Login: Screen(route = "login_screen")
    object SignUp: Screen(route = "signup_screen")
}
