package com.example.copy_paste.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.copy_paste.navigation.Screen


@Composable
fun LoginScreen(navController: NavHostController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Username   Password",
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                fontSize = MaterialTheme.typography.h6.fontSize,
                modifier = Modifier
                    .clickable {
                        navController.navigate(
                            route = Screen.Detail.route
                        )
                    }
            )
            Text(
                text = "no Account SignUp",
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                fontSize = MaterialTheme.typography.h6.fontSize,
                modifier = Modifier
                    .clickable {
                        navController.navigate(
                            route = Screen.SignUp.route
                        )
                    }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)

fun Display3(){
    LoginScreen(navController = rememberNavController())
}

