package com.example.copy_paste

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
                    .clickable {
                        navController.navigate(
                            route = Screen.Detail.passInfo(
                                id = 10,
                                name = "44"
                            )
                        )
                    }
            )
            Row{
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.h5,
                    color = Color.Gray,
                    modifier = Modifier
                        .clickable {
                            /* TODO */
                        }
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Sign up",
                    style = MaterialTheme.typography.h5,
                    color = Color.Gray,
                    modifier = Modifier
                        .clickable {
                            /* TODO */
                        }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)

fun Display1(){
    HomeScreen(navController = rememberNavController())
}

