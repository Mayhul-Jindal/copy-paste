package com.example.copy_paste

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
fun SignUpScreen(navController: NavHostController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Username   Password   Re-Enter-Password",
            style = MaterialTheme.typography.body1,
            color = Color.Black,
            fontSize = MaterialTheme.typography.h6.fontSize,
            modifier = Modifier
                .clickable { /*TODO*/ }
        )
    }
}

@Composable
@Preview(showBackground = true)

fun display4(){
    SignUpScreen(navController = rememberNavController())
}
