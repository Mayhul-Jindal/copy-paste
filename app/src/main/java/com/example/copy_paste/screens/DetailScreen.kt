package com.example.copy_paste.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
fun DetailScreen(navController: NavHostController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Copy the text you want",
            style = MaterialTheme.typography.body1,
            color = Color.Black,
            fontSize = MaterialTheme.typography.h2.fontSize,
            modifier = Modifier
                .clickable {
                    navController.navigate(
                    route = Screen.Detail2.passInfo(
                        id = 100,
                        name = "hahahahah"
                        )
                    )
                }
        )
    }
}

@Composable
@Preview(showBackground = true)

fun Display2(){
    DetailScreen(navController = rememberNavController())
}
