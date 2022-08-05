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

@Composable
fun DetailScreen2(navController: NavHostController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Send to device",
            style = MaterialTheme.typography.body1,
            color = Color.Black,
            fontSize = MaterialTheme.typography.h2.fontSize,
            modifier = Modifier
                .clickable { navController.popBackStack() }
        )

    }
}

@Composable
@Preview(showBackground = true)

fun Display5(){
    DetailScreen2(navController = rememberNavController())
}
