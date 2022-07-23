package com.example.copy_paste.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.copy_paste.navigation.AUTH_GRAPH_ROUTE
import com.example.copy_paste.navigation.Screen


@Composable
fun HomeScreen(navController: NavHostController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column{
            Text(
                text = "Home",
                style = MaterialTheme.typography.h2,
                color = Color.Black,
                modifier = Modifier
            )
            Text(
                text = "Login/Signup",
                style = MaterialTheme.typography.h5,
                color = Color.Gray,
                modifier = Modifier
                    .clickable {
                        navController.navigate(AUTH_GRAPH_ROUTE)
                    }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)

fun Display1(){
    HomeScreen(navController = rememberNavController())
}

